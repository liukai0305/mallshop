package com.example.dianshang.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;

import java.util.ArrayList;

public class FuPopularityAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.HotProductListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;

    public FuPopularityAdapter(ArrayList<HomeBean.DataBean.HotProductListBean> list, Context context, LayoutHelper layoutHelper) {
        this.list = list;
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_fu_popularity, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        HomeZiPopularityAdapter homeZiPopularityAdapter = new HomeZiPopularityAdapter(list, context);
        holder1.home_rcy_renqi.setLayoutManager(new LinearLayoutManager(context));
        holder1.home_rcy_renqi.setAdapter(homeZiPopularityAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView renqi;
        public ImageView duo;
        public RecyclerView home_rcy_renqi;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.renqi = (TextView) rootView.findViewById(R.id.renqi);
            this.duo = (ImageView) rootView.findViewById(R.id.duo);
            this.home_rcy_renqi = (RecyclerView) rootView.findViewById(R.id.home_rcy_renqi);
        }

    }
}
