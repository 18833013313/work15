package bw.com.work15.presenter;

import android.widget.SearchView;

import java.util.HashMap;

import bw.com.work15.count.ProduckCount;
import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;
import bw.com.work15.model.SearchModel;
import bw.com.work15.request.RequestCallBack;

public class SearchPresenter extends ProduckCount.ISearchPersenter {
    private SearchModel searchModel;
    private ProduckCount.ISearchView iSearchView;

    public SearchPresenter(ProduckCount.ISearchView iSearchView) {
        this.searchModel = new SearchModel();
        this.iSearchView = iSearchView;
    }

    @Override
    public void getList(HashMap<String, String> params) {
        searchModel.getList(params, new RequestCallBack() {
            @Override
            public void onFile(String msg) {

            }

            @Override
            public void onSuccess(SearchBean searchBean) {
                iSearchView.onSearchSucces(searchBean);
            }

            @Override
            public void onXQSuccess(XQBean xqBean) {

            }
        });
    }

    @Override
    public void getXQList(HashMap<String, String> params) {
        searchModel.getXQList(params, new RequestCallBack() {
            @Override
            public void onFile(String msg) {

            }

            @Override
            public void onSuccess(SearchBean searchBean) {

            }

            @Override
            public void onXQSuccess(XQBean xqBean) {
                    iSearchView.onXQSearchSucces(xqBean);
            }
        });
    }
}
