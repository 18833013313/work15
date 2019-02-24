package bw.com.work15.util;

import java.util.HashMap;

import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface Userservice {
    @GET
    Call<SearchBean> SearchGet(@Url String Url, @QueryMap HashMap<String,String> map);
    @GET
    Call<XQBean> XQGet(@Url String Url, @QueryMap HashMap<String,String> map);
}
