package com.android.hl.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

import com.android.hl.ui.FragmentActivity;

public abstract class BaseFragment extends Fragment {
	protected int signWidth = 180, signHeight = 60,
			MATCH = LayoutParams.MATCH_PARENT,
			WRAP = LayoutParams.WRAP_CONTENT;
	protected FragmentActivity activity;
	protected RelativeLayout sLayout;
	protected String titleStr ="";
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		initTitle();
		this.activity = (FragmentActivity) activity;
	}

	protected abstract void initView();

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		initLayout();
		initView();
		return sLayout;
	}

	protected abstract void initTitle();

	protected void initLayout(){
		sLayout = new RelativeLayout(activity);
		RelativeLayout.LayoutParams layoutParams = getRelativeParams(
				MATCH, MATCH);
		sLayout.setLayoutParams(layoutParams);
	}
	protected RelativeLayout.LayoutParams getRelativeParams(
			int width, int height) {
		return new RelativeLayout.LayoutParams(width, height);
	}
	public class TextFragment {
		String fragmentName;
		int fragmentID;

		public TextFragment(String fragmentName, int fragmentID) {
			this.fragmentName = fragmentName;
			this.fragmentID = fragmentID;
		}

		public String getFragmentName() {
			return fragmentName;
		}

		public void setFragmentName(String fragmentName) {
			this.fragmentName = fragmentName;
		}

		public int getFragmentID() {
			return fragmentID;
		}

		public void setFragmentID(int fragmentID) {
			this.fragmentID = fragmentID;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		activity.upTitleText(titleStr);
	}
	
	public DisplayMetrics getDisplayMetrics(Context context) {
		return context.getResources().getDisplayMetrics();
	}

	protected void showToast(String text) {
		activity.showToast(text);
	}
}
