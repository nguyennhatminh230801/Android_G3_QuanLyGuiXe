package com.nhom3.quanlyguixe.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class ParkingLots implements Parcelable {
    @SerializedName("parking_lot_id")
    @Expose
    @PrimaryKey
    private int parkingLotId;

    @SerializedName("parking_lot_name")
    @Expose
    private String parkingLotName;

    @SerializedName("parking_slot_max")
    @Expose
    private Long parkingSlotMax;


    public ParkingLots() {

    }

    public static DiffUtil.ItemCallback<ParkingLots> getDiffCallback() {
        return new DiffUtil.ItemCallback<ParkingLots>() {
            @Override
            public boolean areItemsTheSame(@NonNull ParkingLots oldItem, @NonNull ParkingLots newItem) {
                return oldItem.getParkingLotId() == newItem.getParkingLotId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull ParkingLots oldItem, @NonNull ParkingLots newItem) {
                return oldItem.equals(newItem);
            }
        };
    }

    public ParkingLots(int parkingLotId, String parkingLotName, Long parkingSlotMax) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
        this.parkingSlotMax = parkingSlotMax;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public Long getParkingSlotMax() {
        return parkingSlotMax;
    }

    public void setParkingSlotMax(Long parkingSlotMax) {
        this.parkingSlotMax = parkingSlotMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLots)) return false;
        ParkingLots parkinglots = (ParkingLots) o;
        return getParkingLotId() == parkinglots.getParkingLotId() && Objects.equals(getParkingLotName(), parkinglots.getParkingLotName()) && Double.compare(parkinglots.getParkingSlotMax(), parkingSlotMax) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParkingLotId(), getParkingLotName());
    }

    @Override
    public String toString() {
        return "ParkingLots{" +
                "parkingLotId=" + parkingLotId +
                ", parkingLotName='" + parkingLotName + '\'' +
                ", parkingSlotMax='" + parkingSlotMax + '\'' +
                '}';
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.parkingLotId);
        dest.writeString(this.parkingLotName);
        dest.writeDouble(this.parkingSlotMax);
    }

    public void readFromParcel(Parcel source) {
        this.parkingLotId = source.readInt();
        this.parkingLotName = source.readString();
        this.parkingSlotMax = source.readLong();
    }

    protected ParkingLots(Parcel in) {
        this.parkingLotId = in.readInt();
        this.parkingLotName = in.readString();
        this.parkingSlotMax = in.readLong();
    }

    public static final Parcelable.Creator<ParkingLots> CREATOR = new Parcelable.Creator<ParkingLots>() {
        @Override
        public ParkingLots createFromParcel(Parcel source) {
            return new ParkingLots(source);
        }

        @Override
        public ParkingLots[] newArray(int size) {
            return new ParkingLots[size];
        }
    };
}
