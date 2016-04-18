package com.android.hl.base;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class IBaseAdapter extends BaseAdapter {
	protected List<?> lists;
	protected Context context;
	public List<?> getLists() {
		return lists;
	}

	public void setLists(List<?> lists) {
		this.lists = lists;
	}

	@Override
	public int getCount() {
		if (lists == null) {
			return 0;
		}
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		if (lists == null) {
			return null;
		}
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		if (lists == null) {
			return 0;
		}
		return position;
	}
	
}