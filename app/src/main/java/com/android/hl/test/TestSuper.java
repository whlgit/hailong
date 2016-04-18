package com.android.hl.test;

import java.util.List;

/**
 * Created by Administrator on 2016/4/18.
 */
public class TestSuper<T extends SuperInterface> {
     protected List<? extends T> list;
     protected T getTestData(int index){
         return list.get(index);
     }
}
