package com.nhom3.quanlyguixe.data.model.manytomany.employee_area;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.nhom3.quanlyguixe.data.model.Area;
import com.nhom3.quanlyguixe.data.model.Employees;

import java.util.List;

public class OneAreaToManyEmployees {
    @Embedded
    private Area area;

    @Relation(parentColumn = "areaID",
            entityColumn = "employeeID",
            associateBy = @Junction(AreaEmployeesCrossReferences.class)
    )
    private List<Employees> employees;
}
