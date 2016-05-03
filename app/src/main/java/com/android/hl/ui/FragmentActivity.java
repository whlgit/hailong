package com.android.hl.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.base.BaseActivity;
import com.android.hl.fragment.HomeFragment;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushService;

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
        initXG();
    }

    private void initXG() {
        // 开启logcat输出，方便debug，发布时请关闭
        XGPushConfig.enableDebug(this, true);
// 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
// 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
// 具体可参考详细的开发指南
// 传递的参数为ApplicationContext
        Context context = getApplicationContext();
        XGPushManager.registerPush(context, new XGIOperateCallback() {
            /**
             * 操作成功时的回调。
             * @param data 操作成功的业务数据，如注册成功时的token信息等。
             * @param flag 标记码
             */
            @Override
            public void onSuccess(Object data, int flag) {
                Log.i("whl","flagCode:"+flag);
            }
            /**
             * 操作失败时的回调
             * @param data 操作失败的业务数据
             * @param errCode 错误码
             * @param msg 错误信息
             */
            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.i("whl","FailCode:"+errCode+"-----"+msg);
            }
        });

// 2.36（不包括）之前的版本需要调用以下2行代码
//        Intent service = new Intent(context, XGPushService.class);
//        context.startService(service);


// 其它常用的API：
// 绑定账号（别名）注册：registerPush(context,account)或registerPush(context,account, XGIOperateCallback)，其中account为APP账号，可以为任意字符串（qq、openid或任意第三方），业务方一定要注意终端与后台保持一致。
// 取消绑定账号（别名）：registerPush(context,"*")，即account="*"为取消绑定，解绑后，该针对该账号的推送将失效
// 反注册（不再接收消息）：unregisterPush(context)
// 设置标签：setTag(context, tagName)
// 删除标签：deleteTag(context, tagName)
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
