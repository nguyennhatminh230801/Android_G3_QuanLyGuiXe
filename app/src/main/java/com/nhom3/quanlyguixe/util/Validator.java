package com.nhom3.quanlyguixe.util;

import android.widget.EditText;

public class Validator {

    public static boolean isEmptyEditText(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

}
