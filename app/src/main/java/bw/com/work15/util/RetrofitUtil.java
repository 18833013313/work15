package bw.com.work15.util;

import bw.com.work15.api.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil instanct;
    private final Retrofit retrofit;

    public RetrofitUtil() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()

                .build();
        retrofit = new Retrofit
                .Builder()
                .baseUrl(Api.BaseApi)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
    public Userservice getRetrofit(){
        return retrofit.create(Userservice.class);
    }
    public static RetrofitUtil getInstanct() {
        if(instanct == null){
            synchronized (RetrofitUtil.class){
                if (instanct == null){
                    instanct = new RetrofitUtil();
                }
            }
        }
        return instanct;
    }
}
