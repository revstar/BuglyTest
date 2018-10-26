package com.revstar.buglytest;

/**
 * 加载Bug的类
 * Create on 2018/10/26 16:41
 * author revstar
 * Email 1967919189@qq.com
 */
public class LoadBugClass {
    /**
     * 获取Bug字符串
     *
     * @return 返回bug字符串
     */

    public static String getBugString(){

        BugClass bugClass=new BugClass();
        return bugClass.bug();
    }

}
