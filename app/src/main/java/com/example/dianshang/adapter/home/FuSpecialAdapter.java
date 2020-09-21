package com.example.dianshang.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;

import java.util.ArrayList;

public class FuSpecialAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.AdvertiseListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;
    private TextView zhuanti;
    private ImageView zhuan;
    private ImageView img_fupecia_pian;
    private TextView tv_fupecia_name;
    private TextView tv_fupecia_qian;
    private TextView tv_fupecia_title;

    public FuSpecialAdapter(ArrayList<HomeBean.DataBean.AdvertiseListBean> list, Context context, LayoutHelper layoutHelper) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_fupecia_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.AdvertiseListBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv_fupecia_name.setText(bean.getName());
        holder1.tv_fupecia_title.setText(bean.getNote());
        holder1.tv_fupecia_qian.setText("$"+bean.getSort());
        Glide.with(context).load(bean.getPic()).into(holder1.img_fupecia_pian);
    }

    @Override
    public int getItemCount() {
        return list.size()-4;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView zhuanti;
        public ImageView zhuan;
        public ImageView img_fupecia_pian;
        public TextView tv_fupecia_name;
        public TextView tv_fupecia_qian;
        public TextView tv_fupecia_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.zhuanti = (TextView) rootView.findViewById(R.id.zhuanti);
            this.zhuan = (ImageView) rootView.findViewById(R.id.zhuan);
            this.img_fupecia_pian = (ImageView) rootView.findViewById(R.id.img_fupecia_pian);
            this.tv_fupecia_name = (TextView) rootView.findViewById(R.id.tv_fupecia_name);
            this.tv_fupecia_qian = (TextView) rootView.findViewById(R.id.tv_fupecia_qian);
            this.tv_fupecia_title = (TextView) rootView.findViewById(R.id.tv_fupecia_title);
        }

    }
}
