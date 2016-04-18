package com.android.hl.interfacehl;

import android.graphics.Bitmap;

public interface AdapterInterface {

	/**
	 * item ID
	 * 
	 * @return
	 */
	int getID();

	/**
	 * 图标R文件ID
	 * 
	 * @return
	 */
	int getImageID();

	/**
	 * 图片对象
	 * 
	 * @return
	 */
	Bitmap getImage();

	/**
	 * 是否选中
	 * 
	 * @return
	 */
	boolean isSelect();

	/**
	 * 数据内容
	 * 
	 * @return
	 */
	String getText();

	/**
	 * 数据标题
	 * 
	 * @return
	 */
	String getTitle();
}
