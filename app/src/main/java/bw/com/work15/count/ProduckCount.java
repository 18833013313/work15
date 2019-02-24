package bw.com.work15.count;

import java.util.HashMap;

import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;
import bw.com.work15.request.RequestCallBack;

public interface ProduckCount {
    abstract class ISearchPersenter{
        protected abstract void getList(HashMap<String, String> params);
        protected abstract void getXQList(HashMap<String, String> params);
    }
    interface ISearchModel{
        void getList(HashMap<String,String> params, RequestCallBack requestCallBack);
        void getXQList(HashMap<String,String> params, RequestCallBack requestCallBack);
    }
    interface ISearchView{
        void onFile(String msg);
        void onSearchSucces(SearchBean searchBean);
        void onXQFile(String msg);
        void onXQSearchSucces(XQBean xqBean);
    }
}
