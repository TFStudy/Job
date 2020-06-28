package com.ztf.common.utils

import android.content.Context
import android.widget.Toast

object MsgUtils {
    /**
     * 提示消息
     */
    fun show(cxt: Context, msg:String){
        Toast.makeText(cxt,msg,Toast.LENGTH_SHORT).show();
    }
}
