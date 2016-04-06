package com.android.hl.base;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * @ClassName: BaseActivity
 * @Description: Activity基类
 * @author WHL
 * @date  2016/4/6 14:45
 * 
 */
public class BaseActivity extends AppCompatActivity {

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
