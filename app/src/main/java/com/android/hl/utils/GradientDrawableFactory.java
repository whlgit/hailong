package com.android.hl.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListView;

public class GradientDrawableFactory {

	public enum GradientType {

		/**
		 * 没有弧度
		 */
		GRADIENT_DEFAULT(0),
		/**
		 * 四个角弧度
		 */
		GRADIENT_FULL(1),
		/**
		 * 上边两个角弧度
		 */
		GRADIENT_TOP(2),
		/**
		 * 下边两个角弧度
		 */
		GRADIENT_BOTTOM(3);
		final int nativeInt;

		GradientType(int ni) {
			this.nativeInt = ni;
		}

	}

	public static GradientDrawable createGradient(GradientType type, int shapeXY, int color) {
		int shapeZero = 0;
		GradientDrawable newGradient = new GradientDrawable();
		float[] radii = null;
		switch (type) {
		case GRADIENT_TOP:
			radii = new float[] { shapeXY, shapeXY, shapeXY, shapeXY, shapeZero, shapeZero, shapeZero, shapeZero };
			break;
		case GRADIENT_BOTTOM:
			radii = new float[] { shapeZero, shapeZero, shapeZero, shapeZero, shapeXY, shapeXY, shapeXY, shapeXY };
			break;
		case GRADIENT_FULL:
			radii = new float[] { shapeXY, shapeXY, shapeXY, shapeXY, shapeXY, shapeXY, shapeXY, shapeXY };
			break;
		default:
			radii = new float[] { shapeZero, shapeZero, shapeZero, shapeZero, shapeZero, shapeZero, shapeZero, shapeZero };
			break;
		}
		newGradient.setCornerRadii(radii);
		newGradient.setColor(color);
		return newGradient;
	}

	public static GradientDrawable createGradient(int strokeColor, int fillColor) {
		GradientDrawable newGradient = new GradientDrawable();
		newGradient.setColor(fillColor);
		newGradient.setStroke(1, strokeColor);
		return newGradient;
	}

	public void setListViewTop(ListView listview, Context context) {
		Drawable divider = listview.getDivider();
		View dividerView = new View(context);
		dividerView.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, listview.getDividerHeight()));
		dividerView.setBackground(divider);
		listview.addHeaderView(dividerView);
	}

	public GradientDrawable getGradient(GradientType type, int shapeXY, int shapeZero, int color) {
		GradientDrawable newGradient = new GradientDrawable();
		float[] radii = null;
		switch (type) {
		case GRADIENT_TOP:
			radii = new float[] { shapeXY, shapeXY, shapeXY, shapeXY, shapeXY, shapeXY, shapeXY, shapeXY };
			break;
		case GRADIENT_BOTTOM:
			radii = new float[] { shapeXY, shapeXY, shapeXY, shapeXY, shapeZero, shapeZero, shapeZero, shapeZero };
			break;
		case GRADIENT_FULL:
			radii = new float[] { shapeZero, shapeZero, shapeZero, shapeZero, shapeXY, shapeXY, shapeXY, shapeXY };
			break;
		default:
			radii = new float[] { shapeZero, shapeZero, shapeZero, shapeZero, shapeZero, shapeZero, shapeZero, shapeZero };
			break;
		}

		newGradient.setCornerRadii(radii);// 弧度坐标 X and Y radius top-left,
											// top-right, bottom-right,
											// bottom-left
		newGradient.setCornerRadius(5);// 圆角半径 setCornerRadii or
		// setCornerRadius
		newGradient.setColor(color);// 内部色
		// newGradient.setStroke(10,Color.BLACK);//边框
		return newGradient;
	}
}
