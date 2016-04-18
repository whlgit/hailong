package com.android.hl.fragment;

import android.widget.GridView;
import android.widget.RelativeLayout;

import com.android.hl.base.BaseFragment;


public class HomeFragment extends BaseFragment {

    private GridView homeGridView;
    @Override
    protected void initView() {
        RelativeLayout.LayoutParams layoutParams = getRelativeParams(MATCH, WRAP);
        homeGridView = new GridView(activity);
        sLayout.addView(homeGridView,layoutParams);
        initData();
    }

    private void initData() {

    }

    @Override
    protected void initTitle() {
        titleStr ="导航页";
    }
}
