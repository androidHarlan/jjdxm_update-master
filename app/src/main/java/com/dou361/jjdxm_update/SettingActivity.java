package com.dou361.jjdxm_update;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dou361.update.UpdateHelper;
import com.dou361.update.listener.UpdateListener;
import com.dou361.update.type.UpdateType;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {


    private Context mContext;
    /**
     * 自动更新和手动更新放在一起监听方法会相互影响，这里做下过滤
     * 一般自动更新放到MainActivity里面的，手动检测更新放到设置里面的
     */
    private boolean isAutoUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        mContext = this;
    }


    @OnClick({R.id.btn_update, R.id.btn_network_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                update();
                break;
            case R.id.btn_network_update:
                String requestStri = "{\"code\":0,\"data\":{\"download_url\":\"http://wap.apk.anzhi.com/data3/apk/201512/20/55089e385f6e9f350e6455f995ca3452_26503500.apk\",\"force\":false,\"update_content\":\"测试更新接口\",\"v_code\":\"10\",\"v_name\":\"v1.0.0.16070810\",\"v_sha1\":\"7db76e18ac92bb29ff0ef012abfe178a78477534\",\"v_size\":12365909}}";
                networkUpdate(requestStri);
                break;
        }
    }

    /**
     * 手动检测更新
     */
    private void update() {
        isAutoUpdate = false;
        UpdateHelper.getInstance()
                .setUpdateType(UpdateType.checkupdate)
                .setUpdateListener(new UpdateListener() {
                    @Override
                    public void noUpdate() {
                        if (!isAutoUpdate) {
                            Toast.makeText(mContext, "已经是最新版本了", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCheckError(int code, String errorMsg) {
                        if (!isAutoUpdate) {
                            Toast.makeText(mContext, "检测更新失败：" + errorMsg, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onUserCancel() {
                        if (!isAutoUpdate) {
                            Toast.makeText(mContext, "用户取消", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .check(SettingActivity.this);
    }


    /**
     * 分离网络的检测更新
     */
    private void networkUpdate(String data) {
        isAutoUpdate = false;
        UpdateHelper.getInstance()
                .setRequestResultData(data)
                .setUpdateListener(new UpdateListener() {
                    @Override
                    public void noUpdate() {
                        if (!isAutoUpdate) {
                            Toast.makeText(mContext, "已经是最新版本了", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCheckError(int code, String errorMsg) {
                        if (!isAutoUpdate) {
                            Toast.makeText(mContext, "检测更新失败：" + errorMsg, Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onUserCancel() {
                        if (!isAutoUpdate) {
                            Toast.makeText(mContext, "用户取消", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .checkNoUrl(SettingActivity.this);
    }


}
