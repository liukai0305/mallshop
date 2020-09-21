package com.example.dianshang.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;

import java.util.ArrayList;

public class HomeziFreshAdapter extends RecyclerView.Adapter {
    private ArrayList<HomeBean.DataBean.HotProductListBean> list;
    private Context context;

    public HomeziFreshAdapter(ArrayList<HomeBean.DataBean.HotProductListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_rv_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.HotProductListBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv_new_name.setText(bean.getName());
        holder1.tv_new_price.setText("$"+bean.getPrice());
        holder1.tv_new_trait.setText(bean.getSubTitle());
        Glide.with(context).load(bean.getPic()).into(holder1.img_new_tu);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_new_tu;
        public TextView tv_new_name;
        public TextView tv_new_trait;
        public TextView tv_new_price;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_new_tu = (ImageView) rootView.findViewById(R.id.img_new_tu);
            this.tv_new_name = (TextView) rootView.findViewById(R.id.tv_new_name);
            this.tv_new_trait = (TextView) rootView.findViewById(R.id.tv_new_trait);
            this.tv_new_price = (TextView) rootView.findViewById(R.id.tv_new_price);
        }

    }
}
