package com.ztf.core.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ztf.common.utils.MsgUtils;
import com.ztf.core.viewmodel.BaseViewModel;

public abstract class BaseActivity<Binding extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {
    protected Binding binding;
    protected VM vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatusBar();
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        vm=createVM();
        initBinding();
    }
    protected void setStatusBar(){
//        StatusBarUtil.setTransparent(this);
//        StatusBarUtil.setColor(this, BaseAppcation.getAppContext().getResources().getColor(R.color.colorPrimary),0);
    }
    //初始化绑定
    protected abstract void initBinding();
    //创建VM
    protected abstract VM createVM();
    //设置布局id
    protected abstract int getLayoutId();
    //显示提示数据
    protected void showMsg(String msg) {
        MsgUtils.INSTANCE.show(this,msg);
    }
    /**
     * 换取系统资源中的String  支持全球化
     * @param strId String 资源的ID
     * @return
     */
    protected String getResourceString(int strId){
        return getResources().getString(strId);
    }
}
