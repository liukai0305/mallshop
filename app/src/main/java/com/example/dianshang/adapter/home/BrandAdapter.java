package com.example.dianshang.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;

import java.util.ArrayList;

public class BrandAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.BrandListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;

    public BrandAdapter(ArrayList<HomeBean.DataBean.BrandListBean> list, Context context, LayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_barnd, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        HomeBrandAdapter rvAdapter = new HomeBrandAdapter(list, context);

        holder1.gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "品牌更多", Toast.LENGTH_SHORT).show();
            }
        });
        holder1.home_rcy_pinpai.setLayoutManager(new GridLayoutManager(context, 2));
        holder1.home_rcy_pinpai.setAdapter(rvAdapter);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends HomeMarqueeAdappter.ViewHolder {
        public View rootView;
        public View view;
        public TextView pin;
        public ImageView gengduo;
        public RecyclerView home_rcy_pinpai;


        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.view = (View) rootView.findViewById(R.id.view);
            this.pin = (TextView) rootView.findViewById(R.id.pin);
            this.gengduo = (ImageView) rootView.findViewById(R.id.gengduo);
            this.home_rcy_pinpai = (RecyclerView) rootView.findViewById(R.id.home_rcy_pinpai);

        }

    }
}
