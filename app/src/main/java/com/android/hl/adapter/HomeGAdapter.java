package com.android.hl.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.R;
import com.android.hl.base.IBaseAdapter;
import com.android.hl.interfacehl.AdapterInterface;


public class HomeGAdapter extends IBaseAdapter {

	private ViewHolder holder;

	public HomeGAdapter(Context context) {
		super.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = initView();
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		AdapterInterface item = (AdapterInterface) lists.get(position);
		holder.titleTV.setText("" + item.getTitle());
		convertView.setBackgroundResource(item.getImageID());
		return convertView;
	}

	private View initView() {
		RelativeLayout layout = new RelativeLayout(context);
		layout.setLayoutParams(new AbsListView.LayoutParams(
				(int)context.getResources().getDimension(R.dimen.home_item_width_hl), (int)context.getResources().getDimension(R.dimen.home_item_height_hl)));
		holder.titleTV = new TextView(context);
		RelativeLayout.LayoutParams tvLayoutParams = new RelativeLayout.LayoutParams(
				(int)context.getResources().getDimension(R.dimen.home_item_width_hl), (int)context.getResources().getDimension(R.dimen.home_item_height_hl));
		tvLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		holder.titleTV.setLayoutParams(tvLayoutParams);
		holder.titleTV.setTextColor(context.getResources().getColor(
				R.color.item_text_hl));
		holder.titleTV.setTextSize(18);
		holder.titleTV.setGravity(Gravity.CENTER);
		layout.addView(holder.titleTV);
		return layout;
	}

	class ViewHolder {
		TextView titleTV, textTV;
		ImageView imageIV;
	}
}
