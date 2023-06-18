package com.nhom3.quanlyguixe.screens.shiftmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nhom3.quanlyguixe.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int flags[];
    List<String> stringList = new ArrayList<>();

    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<String> countryNames) {
        this.context = applicationContext;
        this.stringList = countryNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_spinner_info, null);
       // TextView names =  view.findViewById(R.id.tvData);
       // names.setText(stringList.get(i));
        return view;
    }
}
