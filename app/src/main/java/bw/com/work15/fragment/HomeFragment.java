package bw.com.work15.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView ;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

import bw.com.work15.R;
import bw.com.work15.adapter.SearchAdapter;
import bw.com.work15.count.ProduckCount;
import bw.com.work15.entity.SearchBean;
import bw.com.work15.entity.XQBean;
import bw.com.work15.presenter.SearchPresenter;

public class HomeFragment extends Fragment implements ProduckCount.ISearchView {

    private XRecyclerView xrlv;
    private Button search;
    private EditText keyword;
    private SearchPresenter searchPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
      //  EventBus.getDefault().register(this);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        xrlv = view.findViewById(R.id.xrlv);
        search = view.findViewById(R.id.search);
        keyword = view.findViewById(R.id.keyword);
        searchPresenter = new SearchPresenter(this);
        HashMap<String,String> params = new HashMap<>();
        params.put("keyword","板鞋");
        params.put("page",1+"");
        params.put("count",17+"");
        searchPresenter.getList(params);
    }

    @Subscribe
    public void getId(String s){
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
     //   Toast.makeText(getContext(),"11111111111",Toast.LENGTH_SHORT).show();
    }
    private void initData() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = keyword.getText().toString();
                Toast.makeText(getContext(),string,Toast.LENGTH_SHORT).show();
                HashMap<String,String> params = new HashMap<>();
                params.put("keyword",string);
                params.put("page",1+"");
                params.put("count",5+"");
                searchPresenter.getList(params);
            }
        });
    }


    @Override
    public void onFile(String msg) {

    }

    @Override
    public void onSearchSucces(SearchBean searchBean) {
        Toast.makeText(getContext(),searchBean.result.size()+"",Toast.LENGTH_SHORT).show();
        SearchAdapter searchAdapter = new SearchAdapter(getContext(),searchBean.result);
        xrlv.setLayoutManager(new GridLayoutManager(getContext(),2));
        xrlv.setAdapter(searchAdapter);
    }

    @Override
    public void onXQFile(String msg) {

    }

    @Override
    public void onXQSearchSucces(XQBean xqBean) {

    }
}
