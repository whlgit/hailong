package com.android.hl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.hl.R;
import com.android.hl.base.BaseActivity;
import com.android.hl.test.TestActivity;

public class HomeActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_hl);
        View view = findViewById(R.id.test_hl);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,TestActivity.class));
            }
        });
    }
}
