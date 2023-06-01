package com.nhom3.quanlyguixe.data.model.manytomany.employee_area;

import androidx.room.Entity;

import java.util.Date;

@Entity(primaryKeys = {"employeeID", "areaID"})
public class AreaEmployeesCrossReferences {
    public int employeeID;
    public int areaID;

    //Cần kiểm tra cách lưu
    public Date time;
}
