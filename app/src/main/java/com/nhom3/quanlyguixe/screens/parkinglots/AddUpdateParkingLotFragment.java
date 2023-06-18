package com.nhom3.quanlyguixe.screens.parkinglots;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.nhom3.quanlyguixe.data.model.ParkingLots;
import com.nhom3.quanlyguixe.databinding.FragmentAddUpdateParkingLotsBinding;
import com.nhom3.quanlyguixe.screens.main.MainActivity;
import com.nhom3.quanlyguixe.util.Constant;
import com.nhom3.quanlyguixe.util.Validator;
import com.nhom3.quanlyguixe.util.base.BaseFragment;
import com.nhom3.quanlyguixe.util.dialog.AlertDialogFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddUpdateParkingLotFragment
        extends BaseFragment<FragmentAddUpdateParkingLotsBinding> {

    private ParkingLotViewModel parkingLotViewModel;


    private boolean isUpdate = false;

    private ParkingLots parkinglots = null;

    @Inject
    NavController navController;

    @Override
    public FragmentAddUpdateParkingLotsBinding inflateViewBinding(LayoutInflater inflater) {
        return FragmentAddUpdateParkingLotsBinding.inflate(inflater);
    }

    @Override
    protected void initScreenData() {
        if (getArguments() != null) {
            isUpdate = getArguments().getBoolean(Constant.KEY_BUNDLE_IS_UPDATE, false);
            parkinglots = getArguments().getParcelable(Constant.KEY_BUNDLE_PARKING_LOT);
        }

        parkingLotViewModel = new ViewModelProvider(this).get(ParkingLotViewModel.class);

        MainActivity mainActivity = (MainActivity) getActivity();

        if (isUpdate && parkinglots != null) {
            Objects.requireNonNull(mainActivity).updateTitleToolBar("Cập nhật nhà xe");

            viewBinding.buttonAddParkingLot.setVisibility(View.GONE);
            viewBinding.buttonUpdateParkingLot.setVisibility(View.VISIBLE);

            viewBinding.textInputParkingLotName.getEditText().setText(parkinglots.getParkingLotName());
            viewBinding.textInputParkingSlotMax.getEditText().setText(String.valueOf(parkinglots.getParkingSlotMax()));
        } else {
            Objects.requireNonNull(mainActivity).updateTitleToolBar("Thêm nhà xe");

            viewBinding.buttonAddParkingLot.setVisibility(View.VISIBLE);
            viewBinding.buttonUpdateParkingLot.setVisibility(View.GONE);
        }
    }

    @Override
    protected void addEvent() {
        viewBinding.buttonClearAllInfo.setOnClickListener(view -> {
            AlertDialogFactory.createClearAllInfoDialog(getContext(), () -> {
                viewBinding.textInputParkingLotName.getEditText().setText("");
                viewBinding.textInputParkingSlotMax.getEditText().setText("");

                viewBinding.textInputParkingLotName.getEditText().requestFocus();

                Toast.makeText(getContext(), "Xóa dữ liệu thành công", Toast.LENGTH_SHORT).show();
            }).show();
        });


        viewBinding.buttonAddParkingLot.setOnClickListener(view -> {
            List<EditText> editTexts = Arrays.asList(
                    viewBinding.textInputParkingLotName.getEditText(),
                    viewBinding.textInputParkingSlotMax.getEditText()
            );

            if (editTexts.stream().anyMatch(Validator::isEmptyEditText)) {
                Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                ParkingLots newParkingLots = new ParkingLots();
                Long amount = Long.valueOf(viewBinding.textInputParkingSlotMax.getEditText().getText().toString());
                newParkingLots.setParkingLotId(0);
                newParkingLots.setParkingLotName(viewBinding.textInputParkingLotName.getEditText().getText().toString());
                newParkingLots.setParkingSlotRemaining(amount);
                newParkingLots.setParkingSlotMax(amount);

                parkingLotViewModel.insertParkingLot(newParkingLots);
            }
        });

        viewBinding.buttonUpdateParkingLot.setOnClickListener(view -> {
            List<EditText> editTexts = Arrays.asList(
                    viewBinding.textInputParkingLotName.getEditText(),
                    viewBinding.textInputParkingSlotMax.getEditText()
            );

            if (editTexts.stream().anyMatch(Validator::isEmptyEditText)) {
                Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                parkinglots.setParkingLotName(viewBinding.textInputParkingLotName.getEditText().getText().toString());
                parkinglots.setParkingSlotMax(Long.valueOf(viewBinding.textInputParkingSlotMax.getEditText().getText().toString()));

                parkingLotViewModel.updateParkingLot(parkinglots);
            }
        });

        viewBinding.textInputParkingLotName.setOnFocusChangeListener((view, isFocus) -> {
            if (!isFocus) {
                boolean isEmpty = viewBinding.textInputParkingLotName.getEditText().getText().toString().isEmpty();
                viewBinding.textInputParkingLotName.setHelperText(isEmpty ? "Vui lòng nhập tên nhà xe" : null);
            }
        });

        viewBinding.textInputParkingSlotMax.setOnFocusChangeListener((view, isFocus) -> {
            if (!isFocus) {
                boolean isEmpty = viewBinding.textInputParkingSlotMax.getEditText().getText().toString().isEmpty();
                viewBinding.textInputParkingSlotMax.setHelperText(isEmpty ? "Vui lòng nhập số vị trí tối đa" : null);
            }
        });
    }

    @Override
    protected void bindToViewModel() {
        parkingLotViewModel.checkHasError().observe(getViewLifecycleOwner(), hasError -> {
            Toast.makeText(getContext(), hasError, Toast.LENGTH_SHORT).show();
        });

        parkingLotViewModel.getBackToPreviousScreen().observe(getViewLifecycleOwner(), backToPreviousScreen -> {
            if (backToPreviousScreen) {
                String displayText = isUpdate ? "Sửa dữ liệu thành công" : "Thêm dữ liệu thành công";
                Toast.makeText(getContext(), displayText, Toast.LENGTH_SHORT).show();
                navController.navigateUp();
            }
        });
    }

    @Override
    public void onDestroy() {
        parkingLotViewModel.resetBackToPreviousScreenState();
        parkinglots = null;
        super.onDestroy();
    }
}
