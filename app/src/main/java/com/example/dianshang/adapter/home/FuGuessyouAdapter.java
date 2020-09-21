package com.example.dianshang.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;

import java.util.ArrayList;

public class FuGuessyouAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.HotProductListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;

    public FuGuessyouAdapter(ArrayList<HomeBean.DataBean.HotProductListBean> list, Context context, LayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_fu_uessyou, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        HomeZiGuessyouAdapter homeZiGuessyouAdapter = new HomeZiGuessyouAdapter(list, context);
        holder1.home_rcy_caini.setLayoutManager(new GridLayoutManager(context,2));
        holder1.home_rcy_caini.setAdapter(homeZiGuessyouAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView caini;
        public RecyclerView home_rcy_caini;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.caini = (TextView) rootView.findViewById(R.id.caini);
            this.home_rcy_caini = (RecyclerView) rootView.findViewById(R.id.home_rcy_caini);
        }

    }
}
