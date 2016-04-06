package com.android.hl.test;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.android.hl.R;
import com.android.hl.base.BaseActivity;
import com.android.hl.view.MovePopupWindow;

/**
 * Created by Administrator on 2016/4/6.
 */
public class TestActivity extends BaseActivity {
    private Button mStartBT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hl);
        mStartBT = (Button) findViewById(R.id.test_start_bt);
        mStartBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });
    }


    MovePopupWindow mMovePopupWindow;
    View mMoveLayout;
    boolean isShow;
    private void click() {
        isShow = !isShow;
        if (mMovePopupWindow==null)
            showLayout();
        if (isShow){
            if (mMovePopupWindow!=null&&mMovePopupWindow.isShowing())
                mMovePopupWindow.dismiss();
        }else {
            mMovePopupWindow.showAsDropDown(mStartBT);
        }


    }

    private void showLayout() {
        mMovePopupWindow = new MovePopupWindow((int) (getResources().getDimension(R.dimen.test_layout_height_hl)), (int) (getResources().getDimension(R.dimen.test_layout_height_hl)));
        mMoveLayout = LayoutInflater.from(this).inflate(R.layout.layout_test_hl, null);
        mMovePopupWindow.setContentView(mMoveLayout,this);

    }
}
