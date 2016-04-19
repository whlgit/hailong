package com.android.hl.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.android.hl.R;
import com.android.hl.base.BaseActivity;
import com.android.hl.test.TestActivity;
import com.android.hl.view.MovePopupWindow;

public class HomeActivity extends BaseActivity{
    public static String testNameHL;
    public String testHL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hl);
        View view = findViewById(R.id.test_hl);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,FragmentActivity.class));
            }
        });
    }

        EditText editText;
        View button;
    private void openWindow(){
        View layout = LayoutInflater.from(HomeActivity.this).inflate(R.layout.activity_test_hl, null);

        button = layout.findViewById(R.id.test_start_bt);
        editText = (EditText) layout.findViewById(R.id.test_edit_et);
        MovePopupWindow window = new MovePopupWindow(500,500);
        window.setContentView(layout,HomeActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testClose();
            }
        });

    }
    private void testClose() {
        InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(button.getWindowToken(),0);

    }

}
