package com.nhom3.quanlyguixe.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class Customers implements Parcelable {
    @SerializedName("customer_id")
    @Expose
    @PrimaryKey
    private int customerID;

    @SerializedName("customer_name")
    @Expose
    private String customerName;

    public Customers() {
    }

    public Customers(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customers)) return false;
        Customers customers = (Customers) o;
        return getCustomerID() == customers.getCustomerID() && Objects.equals(getCustomerName(), customers.getCustomerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerID(), getCustomerName());
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.customerID);
        dest.writeString(this.customerName);
    }

    public void readFromParcel(Parcel source) {
        this.customerID = source.readInt();
        this.customerName = source.readString();
    }

    protected Customers(Parcel in) {
        this.customerID = in.readInt();
        this.customerName = in.readString();
    }

    public static final Parcelable.Creator<Customers> CREATOR = new Parcelable.Creator<Customers>() {
        @Override
        public Customers createFromParcel(Parcel source) {
            return new Customers(source);
        }

        @Override
        public Customers[] newArray(int size) {
            return new Customers[size];
        }
    };
}
