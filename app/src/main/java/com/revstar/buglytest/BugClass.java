package com.revstar.buglytest;

import android.util.Log;

/**
 * Create on 2018/10/26 16:38
 * author revstar
 * Email 1967919189@qq.com
 */
public class BugClass {
    public String bug(){

        //这段代码会报空指针异常
        String str=null;
//        Log.e("BugClass","get string length:"+str.length());
        return "This  bug is fix";
    }
}
