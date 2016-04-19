package com.android.hl.adapter;




import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.base.IBaseAdapter;

/**
 * @author andhl 简单示例
 */
public class SimpleAdapter extends IBaseAdapter {
	private ViewHolder holder;

	public SimpleAdapter(Context context) {
		super.mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		if (convertView == null) {
			convertView = initView();
			holder = new ViewHolder();
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	private View initView() {
		RelativeLayout layout = new RelativeLayout(mContext);
		layout.setLayoutParams(new AbsListView.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		holder.titleTV = new TextView(mContext);
		RelativeLayout.LayoutParams tvLayoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		holder.titleTV.setGravity(Gravity.CENTER);
		holder.titleTV.setTextColor(Color.GREEN);
		layout.addView(holder.titleTV, tvLayoutParams);
		return layout;
	}

	class ViewHolder {
		TextView titleTV, textTV;
		ImageView imageIV;
	}
}