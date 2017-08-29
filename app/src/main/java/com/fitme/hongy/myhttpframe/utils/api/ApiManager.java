package com.fitme.hongy.myhttpframe.utils.api;

import com.fitme.hongy.myhttpframe.utils.JsonFactory.JsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by hongy on 2017/8/27.
 */

public class ApiManager {

    private static final String UFACEURL = "http://gs-api.uface.uni-ubi.com/v1/AE4C691B9ECF412ABD6E25D58B0FB8A5";

    String appKey="F5D1C5991285498EB8FC872EFF2DB1A8";
    String timestamp=System.currentTimeMillis()+"";
    String appSecret="68B59DA194AB4F3F8506C83048C5D30E";
    String deviceKey="84E0F420052000B0";

    //okhttp客户端
    private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15,TimeUnit.SECONDS)
            .build();
    //创建retrofit服务接口
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(UFACEURL)
            .client(okHttpClient)
            .addConverterFactory(JsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();
    //设置成公共方法让model访问
    public static final ApiService ufaceApiService = retrofit.create(ApiService.class);
}
