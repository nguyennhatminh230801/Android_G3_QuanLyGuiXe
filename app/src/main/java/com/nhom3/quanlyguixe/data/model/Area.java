package com.nhom3.quanlyguixe.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class Area implements Parcelable {
    @SerializedName("area_id")
    @Expose
    @PrimaryKey
    private int areaID;

    @SerializedName("area_name")
    @Expose
    private String areaName;

    public Area() {
    }

    public Area(int areaID, String areaName) {
        this.areaID = areaID;
        this.areaName = areaName;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return getAreaID() == area.getAreaID() && Objects.equals(getAreaName(), area.getAreaName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAreaID(), getAreaName());
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaID=" + areaID +
                ", areaName='" + areaName + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.areaID);
        dest.writeString(this.areaName);
    }

    public void readFromParcel(Parcel source) {
        this.areaID = source.readInt();
        this.areaName = source.readString();
    }

    protected Area(Parcel in) {
        this.areaID = in.readInt();
        this.areaName = in.readString();
    }

    public static final Parcelable.Creator<Area> CREATOR = new Parcelable.Creator<Area>() {
        @Override
        public Area createFromParcel(Parcel source) {
            return new Area(source);
        }

        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }
    };
}
