package com.android.hl.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.hl.R;
import com.android.hl.base.BaseActivity;
import com.android.hl.ui.HomeActivity;
import com.android.hl.view.MovePopupWindow;

/**
 * Created by Administrator on 2016/4/6.
 */
public class TestActivity extends BaseActivity {
    private Button mStartBThl;
    private EditText mEditTest;
    private String name = HomeActivity.testNameHL;
    private boolean test;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hl);
        mStartBThl = (Button) findViewById(R.id.test_start_bt);
        mEditTest=(EditText)findViewById(R.id.test_edit_et);

        mStartBThl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                testClick();
                testInPut();
            }
        });
    }

    private void testInPut() {
        showOrHide();
        test =isShowInput(TestActivity.this);
        Log.i("whl","key_board"+test);
//        if (test){
//            hideInPut(mEditTest);
//        }else {
//            showInPut(mEditTest);
//        }
    }

    private void hideInPut(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_HIDDEN);
    }

    private void showInPut(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    private void showOrHide() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void hideSystemInput(Activity activity){
        ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private boolean isShowInput(Context context){
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.isActive();
    }


    MovePopupWindow mMovePopupWindow;
    View mMoveLayout;
    boolean isShow;
    private void testClick() {
        isShow = !isShow;
        if (mMovePopupWindow==null)
            showLayout();
        if (isShow){
            if (mMovePopupWindow!=null&&mMovePopupWindow.isShowing())
                mMovePopupWindow.dismiss();
        }else {
            mMovePopupWindow.showAsDropDown(mStartBThl);
        }


    }

    private void showLayout() {
//        mMovePopupWindow = new MovePopupWindow((int) (getResources().getDimension(R.dimen.test_layout_height_hl)), (int) (getResources().getDimension(R.dimen.test_layout_height_hl)));
//        mMoveLayout = LayoutInflater.from(this).inflate(R.layout.layout_test_hl, null);
//        mMovePopupWindow.setContentView(mMoveLayout,this);

    }
}
