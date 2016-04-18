package com.android.hl.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @ClassName: BaseActivity
 * @Description: Activity基类
 * @author WHL
 * @date  2016/4/6 14:45
 * 
 */
public class BaseActivity extends Activity {
    protected float density;
    protected float widthPixels;
    protected float heightPixels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        initDisplay();
    }

    private void initWindow() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏
    }

    private void initDisplay() {
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        density = displayMetrics.density;
        widthPixels = displayMetrics.widthPixels;
        heightPixels = displayMetrics.heightPixels;
    }

    public int getWidthDisplay(int sacle, int radix) {
        return (int) (widthPixels * getScale(sacle, radix));
    }

    public int getDisplay(float sacle) {
        return (int) (density * sacle);
    }

    public int getHeightDisplay(int sacle, int radix) {
        return (int) (heightPixels * getScale(sacle, radix));
    }

    private float getScale(int scale, int radix) {
        return (float) scale / radix;
    }

    public void showToast(String text){
        Toast.makeText(getApplicationContext(), ""+text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
    /**
     * 定时无操作返回主界面
     */
    private Runnable backHome = new Runnable() {

        @Override
        public void run() {
            moveTaskToBack(true);
        }
    };
    Handler handler = new Handler();
    /**
     * 返回主界面时间
     */
    private long uptimeMillis = 5 * 60 * 1000;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {

        }
        if (ev.getAction() == MotionEvent.ACTION_UP) {

        }
        handler.removeCallbacks(backHome);
        handler.postDelayed(backHome, uptimeMillis);
        return super.dispatchTouchEvent(ev);
    }
    private int x;
    /**
    * 计数log
    * @author whl  2016/4/6 14:49
    */
    public void log(String message) {
        Log.i("whl", (x++) + ":" + message);
    }

    /**
    * Toast 调用
    * @author whl  2016/4/6 14:47
    */
    public void show(String message) {
        Toast.makeText(getApplicationContext(), "" + message, Toast.LENGTH_SHORT).show();
    }
}
