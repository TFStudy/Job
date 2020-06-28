package com.ztf.usercenter.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ztf.core.view.BaseActivity;
import com.ztf.net.protocol.BaseRespEntity;
import com.ztf.usercenter.R;
import com.ztf.usercenter.databinding.ActivityModifypwdBinding;
import com.ztf.usercenter.viewmodel.ModifyViewModel;

public class ModifypwdActivity extends BaseActivity<ActivityModifypwdBinding, ModifyViewModel> {

    private EditText phone;
    private Button getyzm;
    private EditText yzm;
    private EditText pwd;
    private EditText repwd;
    private Button mod;

    @Override
    protected void initBinding() {
        binding.setVm(vm);
        binding.setCommand(this);
        phone = (EditText) findViewById(R.id.phone);
        getyzm = (Button) findViewById(R.id.getyzm);
        yzm = (EditText) findViewById(R.id.yzm);
        pwd = (EditText) findViewById(R.id.pwd);
        repwd = (EditText) findViewById(R.id.repwd);
        mod = (Button) findViewById(R.id.mod);
        getyzm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initYzm();
            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initMod();
            }
        });
    }

    private void initMod() {
        String s = phone.getText().toString();
        String pwd1 = pwd.getText().toString();
        String repwd1 = repwd.getText().toString();
        SharedPreferences userid = getSharedPreferences("userid", MODE_PRIVATE);
        String s1= userid.getString(s, "不存在");
        vm.userEntity.setUserid(s1);
        vm.userEntity.setPwd(pwd1);
        if (!s1.equals("不存在")){
            if (pwd1.equals(repwd1)){
                LiveData<BaseRespEntity> modify = vm.modify();
                modify.observe(this, new Observer<BaseRespEntity>() {
                    @Override
                    public void onChanged(BaseRespEntity yam) {
                        if (yam.getData()!=null){
                            SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
                            SharedPreferences.Editor edit = user.edit();
                            edit.clear();
                            edit.commit();
                            startActivity(new Intent(ModifypwdActivity.this,LoginActivity.class));
                            showMsg("修改成功");
                        }else {
                            Log.d("cbc", "onChanged: 123");
                            showMsg("修改失败");
                        }
                    }
                });
            }else {
                showMsg("两次密码不一致");
            }
        }else {
            showMsg("手机号不正确");
        }
    }

    private void initYzm() {
        String username = phone.getText().toString();
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
    protected ModifyViewModel createVM() {
        return new ModifyViewModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modifypwd;
    }
}
