package com.nhom3.quanlyguixe.data.model;

import android.os.Parcel;
import android.os.Parcelable;

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

    public ParkingLots() {
    }

    public ParkingLots(int parkingLotId, String parkingLotName) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLots)) return false;
        ParkingLots that = (ParkingLots) o;
        return getParkingLotId() == that.getParkingLotId() && Objects.equals(getParkingLotName(), that.getParkingLotName());
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
    }

    public void readFromParcel(Parcel source) {
        this.parkingLotId = source.readInt();
        this.parkingLotName = source.readString();
    }

    protected ParkingLots(Parcel in) {
        this.parkingLotId = in.readInt();
        this.parkingLotName = in.readString();
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
