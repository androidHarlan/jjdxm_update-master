package com.dou361.jjdxm_update;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dou361.update.UpdateHelper;
import com.dou361.update.listener.ForceListener;
import com.dou361.update.type.UpdateType;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        autoUpdate();
    }

    @OnClick({R.id.btn_auto_update, R.id.btn_network, R.id.btn_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_auto_update:
                autoUpdate();
                break;
            case R.id.btn_network:
                String requestStri = "{\"code\":0,\"data\":{\"download_url\":\"http://wap.apk.anzhi.com/data3/apk/201512/20/55089e385f6e9f350e6455f995ca3452_26503500.apk\",\"force\":false,\"update_content\":\"测试更新接口\",\"v_code\":\"10\",\"v_name\":\"v1.0.0.16070810\",\"v_sha1\":\"7db76e18ac92bb29ff0ef012abfe178a78477534\",\"v_size\":12365909}}";
                networkAutoUpdate(requestStri);
                break;
            case R.id.btn_update:
                Intent intent = new Intent(mContext, SettingActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**全局配置的，在SettingActivity中配置了监听会带回来，这里需要清理下*/
        UpdateHelper.getInstance().setUpdateListener(null);
    }

    /**
     * 自动检测更新
     */
    private void autoUpdate() {
        UpdateHelper.getInstance()
                .setUpdateType(UpdateType.autoupdate)
                .setForceListener(new ForceListener() {
                    @Override
                    public void onUserCancel(boolean force) {
                        if (force) {
                            //退出应用
                            finish();
                        }
                    }
                })
                .check(MainActivity.this);
    }

    /**
     * 分离网络的自动检测更新
     */
    private void networkAutoUpdate(String data) {
        UpdateHelper.getInstance()
                .setRequestResultData(data)
                .setForceListener(new ForceListener() {
                    @Override
                    public void onUserCancel(boolean force) {
                        if (force) {
                            //退出应用
                            finish();
                        }
                    }
                })
                .checkNoUrl(MainActivity.this);
    }


}
