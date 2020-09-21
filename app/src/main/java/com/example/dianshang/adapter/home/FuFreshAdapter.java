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

public class FuFreshAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.HotProductListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;

    public FuFreshAdapter(ArrayList<HomeBean.DataBean.HotProductListBean> list, Context context, LayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_fu_fresh, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;

        HomeziFreshAdapter homeFuFreshAdapter = new HomeziFreshAdapter(list, context);
        holder1.home_rcy_xin.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        holder1.home_rcy_xin.setAdapter(homeFuFreshAdapter);


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView xin;
        public ImageView geng;
        public RecyclerView home_rcy_xin;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.xin = (TextView) rootView.findViewById(R.id.xin);
            this.geng = (ImageView) rootView.findViewById(R.id.geng);
            this.home_rcy_xin = (RecyclerView) rootView.findViewById(R.id.home_rcy_xin);
        }

    }
}
