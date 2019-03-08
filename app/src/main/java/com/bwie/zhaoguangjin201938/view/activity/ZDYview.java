package com.bwie.zhaoguangjin201938.view.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.zhaoguangjin201938.R;

/**
 * @Auther: zh
 * @Date: 2019/3/8 15:26
 * @Description: :${赵光金}
 */
public class ZDYview extends LinearLayout {

    private final Button jia;
    private final Button jian;
    private final TextView shuliang;

    public ZDYview(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.zdy,this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        shuliang = findViewById(R.id.shuliang);
    }
}
