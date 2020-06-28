package com.ztf.usercenter.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ztf.common.utils.MsgUtils;
import com.ztf.core.view.BaseActivity;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.R;
import com.ztf.usercenter.databinding.ActivityLoginBinding;
import com.ztf.usercenter.entity.UserEntity;
import com.ztf.usercenter.viewmodel.UserViewModel;
import com.ztf.wiget.TitleBar;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, UserViewModel> {
    private final String TAG=LoginActivity.class.getSimpleName();
    private TitleBar titleBar;
    private CheckBox islogin;
    private TextView tomod;

    @Override
    protected void initBinding() {
        binding.setVm(vm);
        binding.setCommand(this);
        titleBar=findViewById(R.id.tb_bar);
        islogin = findViewById(R.id.islogin);
        tomod = (TextView) findViewById(R.id.tomod);
        titleBar.setTitleBarClickListener(new TitleBar.TitleBarClickListener() {
            @Override
            public void leftClick(View view) {
                MsgUtils.INSTANCE.show(LoginActivity.this,"left");
            }

            @Override
            public void rightClick(View view) {
                MsgUtils.INSTANCE.show(LoginActivity.this,"right");
            }
        });
        tomod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ModifypwdActivity.class));
            }
        });
        islogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = islogin.isChecked();
                if (checked){
                    SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
                    SharedPreferences.Editor edit = user.edit();
                    edit.putString("username",vm.userEntity.getUsername());
                    edit.putString("pwd",vm.userEntity.getPwd());
                    edit.commit();
                }else {
                    SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
                    SharedPreferences.Editor edit = user.edit();
                    edit.clear();
                    edit.commit();
                }
            }
        });
    }

    @Override
    protected UserViewModel createVM() {
        return new UserViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
    //登录按钮的点击事件
    public void loginClick(View view){
        String username = vm.userEntity.getUsername();
        String pwd = vm.userEntity.getPwd();
        if (TextUtils.isEmpty(username)){
            showMsg(getResourceString(R.string.user_hint_input_username));
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            showMsg(getResourceString(R.string.user_hint_input_pwd));
            return;
        }
        LiveData<BaseRespEntity<UserEntity>> login = vm.login();
        login.observe(this, new Observer<BaseRespEntity<UserEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserEntity> userEntityBaseRespEntity) {
                if (userEntityBaseRespEntity!=null&&userEntityBaseRespEntity.getData()!=null){
                    showMsg(getResourceString(R.string.user_login_success));
                }else {
                    showMsg(getResourceString(R.string.user_login_failed));
                }
            }
        });
    }
}