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

public class HomeBrandAdapter extends RecyclerView.Adapter {

    private ArrayList<HomeBean.DataBean.BrandListBean> listBeans;
    private Context context;

    public HomeBrandAdapter(ArrayList<HomeBean.DataBean.BrandListBean> listBeans, Context context) {
        this.listBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_brand, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.BrandListBean brandListBean = listBeans.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(brandListBean.getLogo()).into(holder1.img_brand_iv);
        holder1.tv_brand_money.setText(brandListBean.getSort()+"元起");
        holder1.tv_brand_title.setText(brandListBean.getName());
    }

    @Override
    public int getItemCount() {
        return listBeans.size()-2;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_brand_title;
        public TextView tv_brand_money;
        public TextView tv_barand_xin;
        public ImageView img_brand_iv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_brand_title = (TextView) rootView.findViewById(R.id.tv_brand_title);
            this.tv_brand_money = (TextView) rootView.findViewById(R.id.tv_brand_money);
            this.tv_barand_xin = (TextView) rootView.findViewById(R.id.tv_barand_xin);
            this.img_brand_iv = (ImageView) rootView.findViewById(R.id.img_brand_iv);
        }

    }
}
