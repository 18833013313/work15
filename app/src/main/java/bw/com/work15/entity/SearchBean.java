package bw.com.work15.entity;

import java.util.List;

public class SearchBean {



    public String message;
    public String status;
    public List<ResultBean> result;
    public static class ResultBean {
        public int commodityId;
        public String commodityName;
        public String masterPic;
        public int price;
        public int saleNum;

    }
}
