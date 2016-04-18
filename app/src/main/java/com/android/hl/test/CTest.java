package com.android.hl.test;

/**
 * Created by Administrator on 2016/4/18.
 */
public class CTest<T extends CInterface> extends TestSuper<T> {

    private void testOn(){
        T testData = getTestData(1);
        testData.getName();
    }

}
