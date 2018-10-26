package com.revstar.buglytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.crashreport.CrashReport;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_update;
    Button upgradeInfoTv;
    TextView setinfo;
    Button btnPatchDownload,killprocess;
    Button testhotfix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_update= (Button) this.findViewById(R.id.btn_update);
        upgradeInfoTv= (Button) this.findViewById(R.id.upgradeInfoTv);
        setinfo= (TextView) this.findViewById(R.id.setinfo);
        btnPatchDownload= (Button) this.findViewById(R.id.btnPatchDownload);
        killprocess= (Button) this.findViewById(R.id.killprocess);
        testhotfix= (Button) this.findViewById(R.id.testhotfix);
        btn_update.setOnClickListener(this);
        upgradeInfoTv.setOnClickListener(this);
        killprocess.setOnClickListener(this);
        btnPatchDownload.setOnClickListener(this);
        testhotfix.setOnClickListener(this);
//        CrashReport.testJavaCrash();

    }


    /**
     * 获取升级信息
     */
    private void loadUpgradeInfo() {
        if (upgradeInfoTv == null)
            return;

        /***** 获取升级信息 *****/
        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();

        if (upgradeInfo == null) {
            upgradeInfoTv.setText("无升级信息");
            return;
        }
        StringBuilder info = new StringBuilder();
        info.append("id: ").append(upgradeInfo.id).append("\n");
        info.append("标题: ").append(upgradeInfo.title).append("\n");
        info.append("升级说明: ").append(upgradeInfo.newFeature).append("\n");
        info.append("versionCode: ").append(upgradeInfo.versionCode).append("\n");
        info.append("versionName: ").append(upgradeInfo.versionName).append("\n");
        info.append("发布时间: ").append(upgradeInfo.publishTime).append("\n");
        info.append("安装包Md5: ").append(upgradeInfo.apkMd5).append("\n");
        info.append("安装包下载地址: ").append(upgradeInfo.apkUrl).append("\n");
        info.append("安装包大小: ").append(upgradeInfo.fileSize).append("\n");
        info.append("弹窗间隔（ms）: ").append(upgradeInfo.popInterval).append("\n");
        info.append("弹窗次数: ").append(upgradeInfo.popTimes).append("\n");
        info.append("发布类型（0:测试 1:正式）: ").append(upgradeInfo.publishType).append("\n");
        info.append("弹窗类型（1:建议 2:强制 3:手工）: ").append(upgradeInfo.upgradeType).append("\n");
        info.append("图片地址：").append(upgradeInfo.imageUrl);

        setinfo.setText(info);
        Log.d("信息", String.valueOf(info));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_update:
                Beta.checkUpgrade();
                break;
            case R.id.upgradeInfoTv:
                loadUpgradeInfo();
                break;
            case R.id.btnPatchDownload:
                Beta.downloadPatch();
                break;
            case R.id.killprocess:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            case  R.id.testhotfix:
                testhotfix();
                break;
        }
    }

    private void testhotfix() {
        Toast.makeText(this,LoadBugClass.getBugString(),Toast.LENGTH_LONG).show();
    }
}
