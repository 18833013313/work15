package bw.com.work15.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bw.com.work15.R;
import bw.com.work15.entity.SearchBean;
import bw.com.work15.view.XQActivity;

public class SearchAdapter extends XRecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private Context context;
    private List<SearchBean.ResultBean> list;
    public SearchAdapter(Context context, List<SearchBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).commodityName);
        viewHolder.num.setText(list.get(i).saleNum+"");
        viewHolder.price.setText(list.get(i).price+"");
        Glide.with(context).load(list.get(i).masterPic).into(viewHolder.image);
        final SearchBean.ResultBean resultBean = list.get(i);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(resultBean.commodityId+"");
                Intent intent = new Intent(context,XQActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends XRecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        TextView num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            num = itemView.findViewById(R.id.num);
            image = itemView.findViewById(R.id.image);
        }
    }
}
