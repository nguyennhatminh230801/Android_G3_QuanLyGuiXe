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
    @PrimaryKey(autoGenerate = true)
    private int parkingLotId;

    @SerializedName("parking_lot_name")
    @Expose
    private String parkingLotName;

    @SerializedName("parking_slot_remaining")
    @Expose
    private Long parkingSlotRemaining;

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

    public ParkingLots(int parkingLotId, String parkingLotName, Long parkingSlotRemaining, Long parkingSlotMax) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
        this.parkingSlotRemaining = parkingSlotRemaining;
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

    public Long getParkingSlotRemaining() {
        return parkingSlotRemaining;
    }

    public void setParkingSlotRemaining(Long parkingSlotRemaining) {
        this.parkingSlotRemaining = parkingSlotRemaining;
    }

    @Override
    public String toString() {
        return "ParkingLots{" +
                "parkingLotId=" + parkingLotId +
                ", parkingLotName='" + parkingLotName + '\'' +
                ", parkingSlotRemaining=" + parkingSlotRemaining +
                ", parkingSlotMax=" + parkingSlotMax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLots)) return false;
        ParkingLots that = (ParkingLots) o;
        return getParkingLotId() == that.getParkingLotId() && Objects.equals(getParkingLotName(), that.getParkingLotName()) && Objects.equals(getParkingSlotRemaining(), that.getParkingSlotRemaining()) && Objects.equals(getParkingSlotMax(), that.getParkingSlotMax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParkingLotId(), getParkingLotName(), getParkingSlotRemaining(), getParkingSlotMax());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.parkingLotId);
        dest.writeString(this.parkingLotName);
        dest.writeValue(this.parkingSlotRemaining);
        dest.writeValue(this.parkingSlotMax);
    }

    public void readFromParcel(Parcel source) {
        this.parkingLotId = source.readInt();
        this.parkingLotName = source.readString();
        this.parkingSlotRemaining = (Long) source.readValue(Long.class.getClassLoader());
        this.parkingSlotMax = (Long) source.readValue(Long.class.getClassLoader());
    }

    protected ParkingLots(Parcel in) {
        this.parkingLotId = in.readInt();
        this.parkingLotName = in.readString();
        this.parkingSlotRemaining = (Long) in.readValue(Long.class.getClassLoader());
        this.parkingSlotMax = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Creator<ParkingLots> CREATOR = new Creator<ParkingLots>() {
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
