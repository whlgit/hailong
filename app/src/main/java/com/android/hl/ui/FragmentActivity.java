package com.android.hl.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.base.BaseActivity;
import com.android.hl.fragment.HomeFragment;

/**
 * Created by Administrator on 2016/4/14.
 */
public class FragmentActivity extends BaseActivity {

    private RelativeLayout activityLayout;
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;
    @android.support.annotation.IdRes
    private int FRAMEID = 10086;
    private TextView titleTV;
    @android.support.annotation.IdRes
    private int TITLEID = 10016;
    private HomeFragment homeFragment;
    private int title_height, padding, margin;
    private String app_name;
//    private InsertFragment insertFragment;
//    private AccountAllListFragment accountAllListFragment;
//    private SimpleFragment simpleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValues();
        initLayout();
        initTitle();
        initFragment();
    }

    private void initFragment() {
        startFragment(0);
    }

    public void startFragment(int fragmentID) {
        if (fragmentID == 0) {
            selectFragment(fragmentID);
        } else {
            selectFragment(fragmentID);
        }
    }

    public void upTitleText(String title) {
        titleTV.setText(title);
    }

    public void selectFragment(int position) {
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                homeFragment = new HomeFragment();
                transaction.replace(FRAMEID, homeFragment);
                break;
            case 1:
//                insertFragment = new InsertFragment();
//                transaction.replace(FRAMEID, insertFragment);
                break;
            case 2:
//                accountAllListFragment = new AccountAllListFragment();
//                transaction.replace(FRAMEID, accountAllListFragment);
                break;
            case 3:
//                simpleFragment = new SimpleFragment();
//                transaction.replace(FRAMEID, simpleFragment);
                break;
            case 4:
//                accountAllListFragment = new AccountAllListFragment();
//                transaction.replace(FRAMEID, accountAllListFragment);
                break;
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (position != 0) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    private void initTitle() {
        titleTV = new TextView(this);
        android.widget.RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, title_height);
        titleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        titleTV.setBackgroundColor(Color.BLUE);
        titleTV.setTextColor(Color.GREEN);
//        titleTV.setBackgroundColor(Color.parseColor("#00000000"));
//        titleTV.setTextColor(Color.parseColor("#00000000"));
        titleTV.setTextSize(20);
        titleTV.setGravity(Gravity.CENTER);
        titleTV.setId(TITLEID);
        activityLayout.addView(titleTV, titleParams);
    }

    private void initLayout() {
        activityLayout = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(activityLayout, layoutParams);
        initView();
        activityLayout.setBackgroundColor(Color.WHITE);
    }

    /**
     * 配置数据初始化
     */
    private void initValues() {
        title_height =  (int) density*50;
        margin =   (int) density*50;
        padding = (int) density*50;
        app_name ="test";
    }

    private void initView() {
        frameLayout = new FrameLayout(this);
        android.widget.RelativeLayout.LayoutParams frameParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        frameParams.addRule(RelativeLayout.BELOW, TITLEID);
//        frameLayout.setPadding(padding, padding, padding, padding);
        activityLayout.addView(frameLayout, frameParams);
        frameLayout.setBackgroundColor(Color.parseColor("#00000000"));
        frameLayout.setId(FRAMEID);
    }


}
