package com.example.dianshang.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.AdvertiseListBean> listBeans;
    private Context context;
    private LayoutHelper layoutHelper;

    public BannerAdapter(ArrayList<HomeBean.DataBean.AdvertiseListBean> listBeans, Context context, LayoutHelper layoutHelper) {
        this.listBeans = listBeans;
        this.context = context;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_itemone, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.home_banner.setImages(listBeans)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBean.DataBean.AdvertiseListBean brandListBean = (HomeBean.DataBean.AdvertiseListBean) path;
                        Glide.with(context).load(brandListBean.getPic()).into(imageView);
                    }
                })
                .setDelayTime(2000)
                .start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner home_banner;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.home_banner = (Banner) rootView.findViewById(R.id.home_banner);
        }

    }
}
