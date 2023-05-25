package com.nhom3.quanlyguixe.util.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nhom3.quanlyguixe.util.interfaces.IResultListener;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class BaseViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected MutableLiveData<Boolean> isLoading = new MutableLiveData<>(false);
    protected MutableLiveData<String> error = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLoadingState() {
        return isLoading;
    }

    public MutableLiveData<String> checkHasError() {
        return error;
    }

    public @Inject BaseViewModel() {
    }

    protected void registerDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public <T> Disposable executeTask(
            Single<T> task,
            IResultListener<T> resultListener,
            Boolean loadingVisible
    ) {
        if (loadingVisible) {
            return task
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable -> showLoading())
                    .doOnSuccess(disposable -> hideLoading())
                    .doOnError(disposable -> hideLoading())
                    .subscribe(resultListener::onSuccess, resultListener::onError);
        } else {
            return task
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(resultListener::onSuccess, resultListener::onError);
        }
    }

    protected void showLoading() {
        isLoading.setValue(true);
    }

    protected void hideLoading() {
        isLoading.setValue(false);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}

