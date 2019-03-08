package com.bwie.zhaoguangjin201938.presenter;

import com.bwie.zhaoguangjin201938.model.ulit.Okhttp;
import com.bwie.zhaoguangjin201938.view.fragment.GWCfragment;

/**
 * @Auther: zh
 * @Date: 2019/3/8 13:46
 * @Description: :${赵光金}
 */
public class Presenter {
    GWCfragment gwCfragment;
    private final Okhttp getdan;

    public Presenter(GWCfragment gwCfragment1) {
        this.gwCfragment = gwCfragment1;
        getdan = Okhttp.getdan();
    }


    public void getpresenter() {
        getdan.Get(new Okhttp.getOkhttp() {
            @Override
            public void getstring(String s) {
                gwCfragment.getview(s);
            }
        });
    }
    public  void onDestroy() {
        if (gwCfragment==null) {
            gwCfragment.onDestroy();
        }

    }

}
