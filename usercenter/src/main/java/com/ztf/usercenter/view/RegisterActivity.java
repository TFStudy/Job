package com.ztf.usercenter.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ztf.core.view.BaseActivity;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.R;
import com.ztf.usercenter.databinding.ActivityRegisterBinding;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.viewmodel.RegViewModel;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegViewModel> {
    private final String TAG=RegisterActivity.class.getSimpleName();
    private Button getyzm;
    private EditText yzm;
    private EditText repwd;
    private Button reg;

    @Override
    protected void initBinding() {
        binding.setVm1(vm);
        binding.setCommand(this);
        getyzm = (Button) findViewById(R.id.getyzm);
        yzm = (EditText) findViewById(R.id.yzm);
        repwd = (EditText) findViewById(R.id.repwd);
        reg = (Button) findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regClick(v);
            }
        });
        getyzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initYzm();
            }
        });
    }

    private void initYzm() {
        String username = vm.userEntity.getUsername();
        LiveData<BaseRespEntity> yams = vm.yams(username);
        yams.observe(this, new Observer<BaseRespEntity>() {
            @Override
            public void onChanged(BaseRespEntity yam) {
                Log.d("cbc", "onChanged: 456");
                if (yam!=null){
                    yzm.setText(yam.getData().toString());
                    showMsg("获取成功");
                }else {
                    Log.d("cbc", "onChanged: 123");
                    showMsg("获取失败");
                }
            }
        });
    }

    @Override
    protected RegViewModel createVM() {
        return new RegViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }
    //注册按钮的点击事件
    public void regClick(View view){
        String username = vm.userEntity.getUsername();
        String pwd = vm.userEntity.getPwd();
        String s = repwd.getText().toString();
        if (s.equals(pwd)) {
            if (TextUtils.isEmpty(username)) {
                showMsg(getResourceString(R.string.user_hint_input_username));
                return;
            }
            if (TextUtils.isEmpty(pwd)) {
                showMsg(getResourceString(R.string.user_hint_input_pwd));
                return;
            }
            LiveData<BaseRespEntity<UserEntity>> reg = vm.reg();
            reg.observe(this, new Observer<BaseRespEntity<UserEntity>>() {
                @Override
                public void onChanged(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
                    if (userEntityBaseRespEntity != null && userEntityBaseRespEntity.getData() != null) {
                        String msg = userEntityBaseRespEntity.getMsg();
                        SharedPreferences user = getSharedPreferences("userid", MODE_PRIVATE);
                        SharedPreferences.Editor edit = user.edit();
                        edit.putString(userEntityBaseRespEntity.getData().getUsername(),userEntityBaseRespEntity.getData().getId()+"");
                        edit.commit();
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        Log.d("cbc", "onChanged: " + msg);
                        showMsg("注册成功");
                    } else {
                        showMsg("注册失败");
                    }
                }
            });
        }else {
            showMsg("两次密码不一致");
        }
    }
}