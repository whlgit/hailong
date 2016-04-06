package com.android.hl.test;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;

import com.android.hl.R;
import com.android.hl.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/6.
 */
public class TestActivity extends BaseActivity {
    private Button mStartBT;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_test_hl);
        mStartBT= (Button) findViewById(R.id.test_start_bt);
    }
}
