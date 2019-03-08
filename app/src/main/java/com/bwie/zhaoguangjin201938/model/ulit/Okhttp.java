package com.bwie.zhaoguangjin201938.model.ulit;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: zh
 * @Date: 2019/3/8 13:48
 * @Description: :${赵光金}
 */
public class Okhttp {
    private String string = "http://172.17.8.100/ks/product/getCarts?uid=51";
    private static final Okhttp OKHTTP = new Okhttp();

    public Okhttp() {

    }
    public static Okhttp getdan() {
        return OKHTTP;
    }
private Interceptor getApp(){
    Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response proceed = chain.proceed(request);
            return proceed;
        }
    };
    return interceptor;
}
    public void Get(final getOkhttp getOkhttp) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newBuilder().addInterceptor(getApp());
        Request build = new Request.Builder().url(string).build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                getOkhttp.getstring(string);
            }
        });
    }
    public interface getOkhttp{
        void getstring(String s);
    }
}
