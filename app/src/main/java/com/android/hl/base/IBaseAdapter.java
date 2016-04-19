package com.android.hl.base;

import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

import com.android.hl.interfacehl.AdapterInterface;

public abstract class IBaseAdapter<T extends AdapterInterface> extends BaseAdapter {
	protected List<? extends T> list;
	protected Context mContext;
	public List<?  extends T> getList() {
		return list;
	}

	public void setList(List<? extends T> lists) {
		this.list = lists;
	}

	@Override
	public int getCount() {
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		if (list == null) {
			return null;
		}
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		if (list == null) {
			return 0;
		}
		return position;
	}
	
}