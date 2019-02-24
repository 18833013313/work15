package bw.com.work15.request;

import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;

public interface RequestCallBack {
    void onFile(String msg);
    void onSuccess(SearchBean searchBean);
    void onXQSuccess(XQBean xqBean);
}
