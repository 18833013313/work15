package bw.com.work15.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

import bw.com.work15.R;
import bw.com.work15.count.ProduckCount;
import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;
import bw.com.work15.presenter.SearchPresenter;

public class XQActivity extends AppCompatActivity implements ProduckCount.ISearchView {

    private TextView name_xq;
    private TextView price_xq;
    private ImageView image_xq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq);
        EventBus.getDefault().register(this);
        initView();
        initData();
    }
    @Subscribe(sticky = true)
    public void getId(String s){
        HashMap<String,String> params = new HashMap<>();
        params.put("commodityId",s);
        SearchPresenter searchPresenter = new SearchPresenter(this);
        searchPresenter.getXQList(params);
    }
    private void initView() {
        image_xq = findViewById(R.id.image_xq);
        name_xq = findViewById(R.id.name_xq);
        price_xq = findViewById(R.id.price_xq);
    }

    private void initData() {
    }

    @Override
    public void onFile(String msg) {

    }

    @Override
    public void onSearchSucces(SearchBean searchBean) {

    }

    @Override
    public void onXQFile(String msg) {

    }

    @Override
    public void onXQSearchSucces(XQBean xqBean) {
        //Toast.makeText(this,xqBean.result.commodityId+"",Toast.LENGTH_SHORT).show();
        Glide.with(this).load(xqBean.result.picture).into(image_xq);
        name_xq.setText(xqBean.result.categoryName);
        price_xq.setText(xqBean.result.price+"");
    }
}
