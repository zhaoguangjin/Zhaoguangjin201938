package com.bwie.zhaoguangjin201938.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.zhaoguangjin201938.R;
import com.bwie.zhaoguangjin201938.model.bean.Bean;
import com.bwie.zhaoguangjin201938.presenter.Presenter;
import com.bwie.zhaoguangjin201938.view.activity.ZDYview;
import com.bwie.zhaoguangjin201938.view.adapter.GAdapter;
import com.bwie.zhaoguangjin201938.view.intenter.IMView;
import com.google.gson.Gson;

import java.util.List;

/**
 * @Auther: zh
 * @Date: 2019/3/8 14:01
 * @Description: :${赵光金}
 */
public class GWCfragment extends Fragment implements IMView {

    private RecyclerView recyclerview;
    Handler handler = new Handler();
    private CheckBox checked;
    private TextView zong;
    private List<Bean.DataBean> data;
    private GAdapter gAdapter;
    private Button jia;
    private Button jian;
    private TextView shuliang;
    private ZDYview zdyview;
    private double all;
    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gwcfragment, container, false);
        presenter = new Presenter(this);
        presenter.getpresenter();
        recyclerview = view.findViewById(R.id.RecyclerView);
        checked = view.findViewById(R.id.checked);
        zong = view.findViewById(R.id.zong);
        checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox= (CheckBox) v;
                boolean checked = checkBox.isChecked();

                for (int i = 0; i <data.size() ; i++) {
                    data.get(i).setChecked(checked);
                    List<Bean.DataBean.ListBean> list = data.get(i).getList();
                    for (int j = 0; j <list.size() ; j++) {
                        list.get(j).setChecked(checked);
                        String num = list.get(j).getNum();
                        String price = list.get(j).getPrice();
                        double v1 = Double.parseDouble(num);
                        double v2 = Double.parseDouble(price);
                        all += v1 * v2;
                        if (checked) {
                            Log.i("AA", "true");
                            zong.setText("总价为：" + all + "");
                        } else {
                            zong.setText("总价为：");
                            Log.i("AA", "foas");
                        }

                    }
                }

                gAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public void getview(String s) {
        Log.i("AA", "数据" + s);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(s, Bean.class);
        data = bean.getData();
        gAdapter = new GAdapter(getActivity(), data);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        handler.post(new Runnable() {
            @Override
            public void run() {
                recyclerview.setLayoutManager(layoutManager);
                recyclerview.setAdapter(gAdapter);
            }
        });
        gAdapter.setBox(checked);
        gAdapter.setTextView(zong);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.onDestroy();
        }
    }
}
