package com.android.hl.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.hl.R;
import com.android.hl.base.IBaseAdapter;
import com.android.hl.interfacehl.AdapterTitleIconInterface;
import com.android.hl.utils.GradientDrawableFactory;


public class TitleIconAdapter<T extends AdapterTitleIconInterface> extends IBaseAdapter<T> {

	private ViewHolder holder;

	public TitleIconAdapter(Context context) {
		super.mContext = context;
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
		upLayoutData(position, convertView);
		return convertView;
	}

	private void upLayoutData(int position, View convertView) {
		T item = list.get(position);
		holder.titleTV.setText("" + item.getTitle());
		Log.i("whl","width:"+getWidth()+"----View_Width:"+convertView.getWidth());
//		convertView.setBackgroundResource(item.getImageID());
	}

	private View initView() {
		RelativeLayout layout = new RelativeLayout(mContext);
		int widthPixels = getWidth();
		int	height = widthPixels / 2;
		AbsListView.LayoutParams layoutParams =new AbsListView.LayoutParams(height+1,height+1);
		layout.setLayoutParams(layoutParams);
		holder.titleTV = new TextView(mContext);
		RelativeLayout.LayoutParams tvLayoutParams = new RelativeLayout.LayoutParams(
				(int) mContext.getResources().getDimension(R.dimen.home_item_width_hl), (int) mContext.getResources().getDimension(R.dimen.home_item_height_hl));
		tvLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		holder.titleTV.setLayoutParams(tvLayoutParams);
		holder.titleTV.setTextColor(mContext.getResources().getColor(
				R.color.item_text_hl));
		holder.titleTV.setTextSize(18);
		holder.titleTV.setGravity(Gravity.CENTER);
		layout.addView(holder.titleTV);
		layout.setBackground(GradientDrawableFactory.createGradient(Color.BLACK,Color.WHITE));
//		layout.setBackgroundColor(Color.GREEN);
		return layout;
	}

	private int getWidth() {
		return mContext.getResources().getDisplayMetrics().widthPixels;
	}

	class ViewHolder {
		TextView titleTV, textTV;
		ImageView imageIV;
	}
}
