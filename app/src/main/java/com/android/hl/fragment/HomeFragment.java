package com.android.hl.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.R;
import com.android.hl.adapter.TitleIconAdapter;
import com.android.hl.base.BaseFragment;
import com.android.hl.bean.HomeItemBean;
import com.android.hl.service.SimpleService;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment {

    private GridView homeGridView;
    private List<HomeItemBean> list;
    @Override
    protected void initView() {
        RelativeLayout.LayoutParams layoutParams = getRelativeParams(MATCH, WRAP);
        layoutParams.topMargin =-1;
        layoutParams.leftMargin=-1;
        layoutParams.rightMargin =-1;
        homeGridView = new GridView(activity);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        sLayout.addView(homeGridView,layoutParams);
        initData();
    }

    private void initData() {
        list = new ArrayList<HomeItemBean>();
        TitleIconAdapter<HomeItemBean> homeItemBeanTitleIconAdapter = new TitleIconAdapter<HomeItemBean>(activity);
        list.add(new HomeItemBean("1", R.mipmap.ic_launcher));
        list.add(new HomeItemBean("2", R.mipmap.ic_launcher));
        list.add(new HomeItemBean("3", R.mipmap.ic_launcher));
        list.add(new HomeItemBean("4", R.mipmap.ic_launcher));
        list.add(new HomeItemBean("5", R.mipmap.ic_launcher));
        homeItemBeanTitleIconAdapter.setList(list);
        homeGridView.setAdapter(homeItemBeanTitleIconAdapter);
        homeGridView.setNumColumns(2);
        homeGridView.setPadding(0,0,0,-1);
        homeGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void stopService(){
        activity.stopService(getIntent());
    }
    private void startService(){
        activity.startService(getIntent());
    }

    private Intent getIntent() {
      return  new Intent( activity.getApplicationContext(), SimpleService.class);
    }

    @Override
    protected void initTitle() {
        titleStr ="导航页";
    }
}
