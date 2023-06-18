package com.nhom3.quanlyguixe.data.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
public class ScheduleEmployee implements Parcelable {
    @SerializedName("schedule_id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    int id;

    protected ScheduleEmployee(Parcel in) {
        id = in.readInt();
        idArea = in.readInt();
        areaName = in.readString();
        employeeID = in.readInt();
        fullName = in.readString();
        scheduleTime = in.readString();
        time = in.readString();
    }

    public static final Creator<ScheduleEmployee> CREATOR = new Creator<ScheduleEmployee>() {
        @Override
        public ScheduleEmployee createFromParcel(Parcel in) {
            return new ScheduleEmployee(in);
        }

        @Override
        public ScheduleEmployee[] newArray(int size) {
            return new ScheduleEmployee[size];
        }
    };

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @SerializedName("areaID")
    @Expose
    int idArea;

    @SerializedName("areaName")
    @Expose
    String areaName;

    public ScheduleEmployee(int id, int idArea, String areaName, int employeeID, String fullName, String scheduleTime, String time) {
        this.id = id;
        this.idArea = idArea;
        this.areaName = areaName;
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.scheduleTime = scheduleTime;
        this.time = time;
    }

    @SerializedName("employee_id")
    @Expose
    int employeeID;

    @SerializedName("fullname")
    @Expose
    String fullName;

    @SerializedName("segments")
    @Expose
    String scheduleTime;
    @SerializedName("time")
    @Expose
    String time;




    public ScheduleEmployee() {
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public ScheduleEmployee(int id, int idArea, int employeeID, String fullName, String timeF, String time) {
        this.id = id;
        this.idArea = idArea;
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.scheduleTime = timeF;
        this.time = time;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
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

    public String getTimeF() {
        return scheduleTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ScheduleEmployee{" +
                "id='" + id + '\'' +
                ", idArea=" + idArea +
                ", employeeID=" + employeeID +
                ", fullName='" + fullName + '\'' +
                ", timeF='" + scheduleTime + '\'' +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setTimeF(String timeF) {
        this.scheduleTime = timeF;
    }


    public static DiffUtil.ItemCallback<ScheduleEmployee> getDiffCallback() {
        return new DiffUtil.ItemCallback<ScheduleEmployee>() {
            @Override
            public boolean areItemsTheSame(@NonNull ScheduleEmployee oldItem, @NonNull ScheduleEmployee newItem) {
                return oldItem.getEmployeeID() == newItem.getEmployeeID();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull ScheduleEmployee oldItem, @NonNull ScheduleEmployee newItem) {
                return oldItem.equals(newItem);
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(idArea);
        parcel.writeString(areaName);
        parcel.writeInt(employeeID);
        parcel.writeString(fullName);
        parcel.writeString(scheduleTime);
        parcel.writeString(time);
    }
}
