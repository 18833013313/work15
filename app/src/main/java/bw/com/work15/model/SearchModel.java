package bw.com.work15.model;

import java.util.HashMap;

import bw.com.work15.api.Api;
import bw.com.work15.count.ProduckCount;
import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;
import bw.com.work15.request.RequestCallBack;
import bw.com.work15.util.RetrofitUtil;
import bw.com.work15.util.Userservice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchModel implements ProduckCount.ISearchModel {
    @Override
    public void getList(HashMap<String, String> params, final RequestCallBack requestCallBack) {
        Userservice retrofit = RetrofitUtil.getInstanct().getRetrofit();
        Call<SearchBean> searchBeanCall = retrofit.SearchGet(Api.SearchApi, params);
        searchBeanCall.enqueue(new Callback<SearchBean>() {
            @Override
            public void onResponse(Call<SearchBean> call, Response<SearchBean> response) {
                SearchBean body = response.body();
                requestCallBack.onSuccess(body);
            }

            @Override
            public void onFailure(Call<SearchBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void getXQList(HashMap<String, String> params, final RequestCallBack requestCallBack) {
        Userservice retrofit = RetrofitUtil.getInstanct().getRetrofit();
        Call<XQBean> xqBeanCall = retrofit.XQGet(Api.XQApi, params);
        xqBeanCall.enqueue(new Callback<XQBean>() {
            @Override
            public void onResponse(Call<XQBean> call, Response<XQBean> response) {
                XQBean body = response.body();
                requestCallBack.onXQSuccess(body);
            }

            @Override
            public void onFailure(Call<XQBean> call, Throwable t) {

            }
        });
    }
}
