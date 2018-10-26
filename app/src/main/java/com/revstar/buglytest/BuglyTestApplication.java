package com.revstar.buglytest;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create on 2018/10/23 16:46
 * author revstar
 * Email 1967919189@qq.com
 */
public class BuglyTestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initBugly();
    }

    /**
     * 第三个参数测试设置true，发布false
     */
    private void initBugly() {
        Context context=getApplicationContext();
        //获取包名
        String packageName=getApplicationContext().getPackageName();
        //获取当前进程名
        String processName=getProcessName(android.os.Process.myPid());
        //设置是否为上报进程
        CrashReport.UserStrategy strategy=new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName==null||processName.equals(packageName));
        //初始化Bugly
//        CrashReport.initCrashReport(context,"739d107dda",BuildConfig.DEBUG,strategy);
        Bugly.init(context,"739d107dda",BuildConfig.DEBUG);
        //设置状态栏小图标
        Beta.smallIconId=R.drawable.ic_launcher_background;
        //设置通知栏大图标
        Beta.largeIconId=R.drawable.ic_launcher_background;

    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

}
