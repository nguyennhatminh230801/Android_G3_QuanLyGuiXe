package com.nhom3.quanlyguixe.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;

@Entity
public class VehicleControl implements Parcelable {
    @SerializedName("control_id")
    @Expose
    @PrimaryKey
    private int vehicleControlID;

    @SerializedName("vehicle_number")
    @Expose
    private String vehicleNumber;

    @SerializedName("date_time_in")
    @Expose
    private Date dateTimeIn;

    @SerializedName("date_time_out")
    @Expose
    private Date dateTimeOut;

    @SerializedName("employee_id")
    @Expose
    private int employeeID;

    @SerializedName("ticket_id")
    @Expose
    private int ticketID;

    @SerializedName("area_id")
    @Expose
    private int areaID;

    @SerializedName("customer_id")
    @Expose
    private int customerID;

    @SerializedName("photo")
    @Expose
    private String vehicleImageURL;

    public VehicleControl() {
    }

    public VehicleControl(int vehicleControlID, String vehicleNumber, Date dateTimeIn,
                          Date dateTimeOut, int employeeID, int ticketID, int areaID,
                          int customerID, String vehicleImageURL) {
        this.vehicleControlID = vehicleControlID;
        this.vehicleNumber = vehicleNumber;
        this.dateTimeIn = dateTimeIn;
        this.dateTimeOut = dateTimeOut;
        this.employeeID = employeeID;
        this.ticketID = ticketID;
        this.areaID = areaID;
        this.customerID = customerID;
        this.vehicleImageURL = vehicleImageURL;
    }

    public int getVehicleControlID() {
        return vehicleControlID;
    }

    public void setVehicleControlID(int vehicleControlID) {
        this.vehicleControlID = vehicleControlID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getDateTimeIn() {
        return dateTimeIn;
    }

    public void setDateTimeIn(Date dateTimeIn) {
        this.dateTimeIn = dateTimeIn;
    }

    public Date getDateTimeOut() {
        return dateTimeOut;
    }

    public void setDateTimeOut(Date dateTimeOut) {
        this.dateTimeOut = dateTimeOut;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getVehicleImageURL() {
        return vehicleImageURL;
    }

    public void setVehicleImageURL(String vehicleImageURL) {
        this.vehicleImageURL = vehicleImageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleControl)) return false;
        VehicleControl that = (VehicleControl) o;
        return getVehicleControlID() == that.getVehicleControlID() && getEmployeeID() == that.getEmployeeID() && getTicketID() == that.getTicketID() && getAreaID() == that.getAreaID() && getCustomerID() == that.getCustomerID() && Objects.equals(getVehicleNumber(), that.getVehicleNumber()) && Objects.equals(getDateTimeIn(), that.getDateTimeIn()) && Objects.equals(getDateTimeOut(), that.getDateTimeOut()) && Objects.equals(getVehicleImageURL(), that.getVehicleImageURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleControlID(), getVehicleNumber(), getDateTimeIn(), getDateTimeOut(), getEmployeeID(), getTicketID(), getAreaID(), getCustomerID(), getVehicleImageURL());
    }

    @Override
    public String toString() {
        return "VehicleControl{" +
                "vehicleControlID=" + vehicleControlID +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", dateTimeIn=" + dateTimeIn +
                ", dateTimeOut=" + dateTimeOut +
                ", employeeID=" + employeeID +
                ", ticketID=" + ticketID +
                ", areaID=" + areaID +
                ", customerID=" + customerID +
                ", vehicleImageURL='" + vehicleImageURL + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.vehicleControlID);
        dest.writeString(this.vehicleNumber);
        dest.writeLong(this.dateTimeIn != null ? this.dateTimeIn.getTime() : -1);
        dest.writeLong(this.dateTimeOut != null ? this.dateTimeOut.getTime() : -1);
        dest.writeInt(this.employeeID);
        dest.writeInt(this.ticketID);
        dest.writeInt(this.areaID);
        dest.writeInt(this.customerID);
        dest.writeString(this.vehicleImageURL);
    }

    public void readFromParcel(Parcel source) {
        this.vehicleControlID = source.readInt();
        this.vehicleNumber = source.readString();
        long tmpDateTimeIn = source.readLong();
        this.dateTimeIn = tmpDateTimeIn == -1 ? null : new Date(tmpDateTimeIn);
        long tmpDateTimeOut = source.readLong();
        this.dateTimeOut = tmpDateTimeOut == -1 ? null : new Date(tmpDateTimeOut);
        this.employeeID = source.readInt();
        this.ticketID = source.readInt();
        this.areaID = source.readInt();
        this.customerID = source.readInt();
        this.vehicleImageURL = source.readString();
    }

    protected VehicleControl(Parcel in) {
        this.vehicleControlID = in.readInt();
        this.vehicleNumber = in.readString();
        long tmpDateTimeIn = in.readLong();
        this.dateTimeIn = tmpDateTimeIn == -1 ? null : new Date(tmpDateTimeIn);
        long tmpDateTimeOut = in.readLong();
        this.dateTimeOut = tmpDateTimeOut == -1 ? null : new Date(tmpDateTimeOut);
        this.employeeID = in.readInt();
        this.ticketID = in.readInt();
        this.areaID = in.readInt();
        this.customerID = in.readInt();
        this.vehicleImageURL = in.readString();
    }

    public static final Parcelable.Creator<VehicleControl> CREATOR = new Parcelable.Creator<VehicleControl>() {
        @Override
        public VehicleControl createFromParcel(Parcel source) {
            return new VehicleControl(source);
        }

        @Override
        public VehicleControl[] newArray(int size) {
            return new VehicleControl[size];
        }
    };
}
