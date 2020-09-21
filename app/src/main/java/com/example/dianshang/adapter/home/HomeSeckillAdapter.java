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
import java.util.List;

public class HomeSeckillAdapter extends RecyclerView.Adapter {

    private ArrayList<HomeBean.DataBean.NewProductListBean>list;
    private Context context;

    public HomeSeckillAdapter(ArrayList<HomeBean.DataBean.NewProductListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    //    @Override
//    protected void bindData(BaseViewHolder vh, Object data, int position) {
//        HomeBean.DataBean.NewProductListBean bean = (HomeBean.DataBean.NewProductListBean) data;
//        mImgHotTu = (ImageView) vh.getViewById(R.id.img_hot_tu);
//        mTvHotQian = (TextView) vh.getViewById(R.id.tv_hot_qian);
//        mTvHotPrice = (TextView) vh.getViewById(R.id.tv_hot_price);
//        mTvHotName = (TextView) vh.getViewById(R.id.tv_hot_name);
//        mTvHotTrait = (TextView) vh.getViewById(R.id.tv_hot_trait);
//        Glide.with(context).load(bean.getPic()).into(mImgHotTu);
//        mTvHotQian.setText("￥" + bean.getOriginalPrice());
//        mTvHotPrice.setText("秒杀价￥" + bean.getStock());
//        mTvHotName.setText(bean.getName());
//        mTvHotTrait.setText(bean.getSubTitle());
//    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home_seckill, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.NewProductListBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        holder1.tv_hot_name.setText(bean.getName());
        holder1.tv_hot_price.setText("秒杀价$"+bean.getPrice());
        holder1.tv_hot_qian.setText("$"+bean.getGiftPoint());
        holder1.tv_hot_trait.setText(bean.getDetailTitle());
        Glide.with(context).load(bean.getPic()).into(holder1.img_hot_tu);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_hot_tu;
        public TextView tv_hot_qian;
        public TextView tv_hot_price;
        public TextView tv_hot_name;
        public TextView tv_hot_trait;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_hot_tu = (ImageView) rootView.findViewById(R.id.img_hot_tu);
            this.tv_hot_qian = (TextView) rootView.findViewById(R.id.tv_hot_qian);
            this.tv_hot_price = (TextView) rootView.findViewById(R.id.tv_hot_price);
            this.tv_hot_name = (TextView) rootView.findViewById(R.id.tv_hot_name);
            this.tv_hot_trait = (TextView) rootView.findViewById(R.id.tv_hot_trait);
        }

    }
}
