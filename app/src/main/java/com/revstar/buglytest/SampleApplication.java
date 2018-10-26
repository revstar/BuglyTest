package com.revstar.buglytest;


import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Create on 2018/10/25 10:47
 * author revstar
 * Email 1967919189@qq.com
 */
public class SampleApplication extends TinkerApplication {


    public SampleApplication() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.revstar.buglytest.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
