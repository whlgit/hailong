package com.android.hl.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;

import com.android.hl.ui.FragmentActivity;

public abstract class BaseFragment extends Fragment {
	protected int signWidth = 180, signHeight = 60,
			MATCH = LayoutParams.MATCH_PARENT,
			WRAP = LayoutParams.WRAP_CONTENT;
	protected FragmentActivity activity;
	protected String titleStr ="";
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		initTitle();
		this.activity = (FragmentActivity) activity;
	}
	
	protected abstract void initTitle();
	
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
