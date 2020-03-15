package com.christ.android_mvvm.model;

import android.database.Observable;

import androidx.databinding.ObservableField;

public class UserBean {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> sex = new ObservableField<>();

    public UserBean(){
        name.set("王小明");
        sex.set("男");
    }
}
