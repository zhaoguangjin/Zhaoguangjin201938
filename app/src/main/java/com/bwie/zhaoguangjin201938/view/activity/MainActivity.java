package com.bwie.zhaoguangjin201938.view.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bwie.zhaoguangjin201938.R;
import com.bwie.zhaoguangjin201938.presenter.Presenter;
import com.bwie.zhaoguangjin201938.view.fragment.GWCfragment;
import com.bwie.zhaoguangjin201938.view.fragment.WDfragment;
import com.bwie.zhaoguangjin201938.view.intenter.IMView;

public class MainActivity extends FragmentActivity {


    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.RadioGroup);
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.FrameLayout, new GWCfragment());
        transaction.commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.re_1:
                        fragmentTransaction.replace(R.id.FrameLayout, new GWCfragment());
                        break;
                    case R.id.re_2:
                        fragmentTransaction.replace(R.id.FrameLayout, new WDfragment());
                        break;
                }
                fragmentTransaction.commit();
            }
        });

    }


}
