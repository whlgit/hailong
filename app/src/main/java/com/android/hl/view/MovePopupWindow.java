package com.android.hl.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

/**
 * @ClassName: MovePopupWindow
 * @Description: TODO(类的作用)展示关闭小窗口带动画的PopupWindow
 * @author WHL
 * @date 2016-3-24 上午9:19:23 Constructor：设置宽，高，用于View设置位置和动画移动距离 Method:
 *       setContentView(View contentView, Context mContext) mContext:用于设置半透明背景
 */
@SuppressLint("NewApi")
public class MovePopupWindow extends PopupWindow {
	private AnimatorSet mShowAnimSet, mDismissAnimSet;
	private View mContentView;
	private RelativeLayout mBackgroundLayout;
	private int mHeight, mWidth;
	private int mDuration = 1000 * 1;
	/**
	 * 关闭动画状态
	 */
	private boolean isDismissRun;

	/**
	 * @param width
	 * @param height
	 *            确定移动距离
	 */
	public MovePopupWindow(int width, int height) {
		super(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		mHeight = height > 1 ? height : 200;
		mWidth = width > 1 ? width : 200;
		setOutsideTouchable(true);
		setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
	}

	/**
	 * @deprecated This method is deprecated and use setContentView(View
	 *             contentView, Context mContext)
	 * 
	 */
	@Deprecated
	public void setContentView(View contentView) {

	}

	/**
	 * @param contentView
	 * @param context
	 *            添加透明背景
	 * @author whl 2016-3-23
	 */
	public void setContentView(View contentView, Context context) {
		mContentView = contentView;
		initContentViewBackground(context);
	}
	
	public void setContentView(int layoutResID, Context context){
		setContentView(LayoutInflater.from(context).inflate(layoutResID, null),context);
	}
	
	private void initContentViewBackground(Context context) {
		mBackgroundLayout = new RelativeLayout(context);
		mBackgroundLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		mBackgroundLayout.setBackgroundColor(Color.parseColor("#99999999"));
		mBackgroundLayout.addView(mContentView);
		super.setContentView(mBackgroundLayout);
	}

	@Override
	public void showAsDropDown(View anchor) {
		if (!isShowing()) {
			super.showAsDropDown(anchor);
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, mHeight);
			layoutParams.topMargin = -mHeight;
			mContentView.setLayoutParams(layoutParams);
			mShowAnimSet = new AnimatorSet();
			mShowAnimSet.setDuration(mDuration);
			mShowAnimSet.playSequentially(ObjectAnimator.ofFloat(mContentView, "translationY", 0f, mHeight));
			mShowAnimSet.start();
		}
	}

	@Override
	public void dismiss() {
		if (!isDismissRun) {
			isDismissRun = true;
			mDismissAnimSet = new AnimatorSet();
			mDismissAnimSet.setDuration(mDuration);
			mDismissAnimSet.playSequentially(ObjectAnimator.ofFloat(mContentView, "translationY", mHeight, 0f));
			mDismissAnimSet.start();
			mDismissAnimSet.addListener(new AnimatorListener() {

				@Override
				public void onAnimationStart(Animator animation) {

				}

				@Override
				public void onAnimationRepeat(Animator animation) {

				}

				@Override
				public void onAnimationEnd(Animator animation) {
					myDismiss();
				}

				@Override
				public void onAnimationCancel(Animator animation) {
					myDismiss();
				}
			});
		}
	}

	private void myDismiss() {
		MovePopupWindow.super.dismiss();
		isDismissRun = false;
	}
}
