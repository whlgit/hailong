package com.android.hl.bean;

import android.graphics.Bitmap;

import com.android.hl.interfacehl.AdapterTitleIconInterface;

/**
 * Created by Administrator on 2016/4/19.
 */
public class HomeItemBean implements AdapterTitleIconInterface{

    private int mImageID,mID;
    private String mTitle,mText;
    private Bitmap mBitmap;
    private boolean isSelect;

    public HomeItemBean(){

    }
    public HomeItemBean(String title,int iconID){
        mTitle =title;
        mImageID = iconID;
    }


    @Override
    public int getImageID() {
        return mImageID;
    }

    @Override
    public Bitmap getImage() {
        return mBitmap;
    }

    @Override
    public boolean isSelect() {
        return isSelect;
    }

    @Override
    public String getText() {
        return mText;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public int getID() {
        return mID;
    }
}
