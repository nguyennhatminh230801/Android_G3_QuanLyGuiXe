package com.nhom3.quanlyguixe.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity
public class Employees implements Parcelable {
    @SerializedName("employee_id")
    @Expose
    @PrimaryKey
    private int employeeID;

    @SerializedName("fullname")
    @Expose
    private String fullName;

    @SerializedName("date_of_birth")
    @Expose
    private Date dateOfBirth;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("photo")
    @Expose
    private String employeeImageURL;

    public Employees() {
    }

    public Employees(int employeeID, String fullName, Date dateOfBirth, String phoneNumber, String email, String employeeImageURL) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.employeeImageURL = employeeImageURL;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeImageURL() {
        return employeeImageURL;
    }

    public void setEmployeeImageURL(String employeeImageURL) {
        this.employeeImageURL = employeeImageURL;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeID=" + employeeID +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", employeeImageURL='" + employeeImageURL + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.employeeID);
        dest.writeString(this.fullName);
        dest.writeLong(this.dateOfBirth != null ? this.dateOfBirth.getTime() : -1);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.email);
        dest.writeString(this.employeeImageURL);
    }

    public void readFromParcel(Parcel source) {
        this.employeeID = source.readInt();
        this.fullName = source.readString();
        long tmpDateOfBirth = source.readLong();
        this.dateOfBirth = tmpDateOfBirth == -1 ? null : new Date(tmpDateOfBirth);
        this.phoneNumber = source.readString();
        this.email = source.readString();
        this.employeeImageURL = source.readString();
    }

    protected Employees(Parcel in) {
        this.employeeID = in.readInt();
        this.fullName = in.readString();
        long tmpDateOfBirth = in.readLong();
        this.dateOfBirth = tmpDateOfBirth == -1 ? null : new Date(tmpDateOfBirth);
        this.phoneNumber = in.readString();
        this.email = in.readString();
        this.employeeImageURL = in.readString();
    }

    public static final Creator<Employees> CREATOR = new Creator<Employees>() {
        @Override
        public Employees createFromParcel(Parcel source) {
            return new Employees(source);
        }

        @Override
        public Employees[] newArray(int size) {
            return new Employees[size];
        }
    };
}
