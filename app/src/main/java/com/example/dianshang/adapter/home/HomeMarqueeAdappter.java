package com.example.dianshang.adapter.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.common.AutoTextView;

import java.util.ArrayList;

public class HomeMarqueeAdappter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.HotProductListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;

    private Handler handler = new Handler();
    private int count = 0;
    private Runnable runnable;
    private ViewHolder holder1;
    private ArrayList<String> arrList;

    public HomeMarqueeAdappter(ArrayList<HomeBean.DataBean.HotProductListBean> list, Context context, LayoutHelper layoutHelper) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_textview_adapter, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        holder1 = (ViewHolder) holder;
        arrList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrList.add(list.get(i).getName());
        }
        getGunDong();
        handler.postDelayed(runnable, 0);
    }


    private void getGunDong() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    handler.postDelayed(this, 1000);
                    holder1.autoTextView.next();
                    holder1.autoTextView.setText(arrList.get(count % arrList.size()));
                    count++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends BannerAdapter.ViewHolder {
        public View rootView;
        public ImageView img_home_xiaoxi;
        public AutoTextView autoTextView;
        public RelativeLayout rly;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_home_xiaoxi = (ImageView) rootView.findViewById(R.id.img_home_xiaoxi);
            this.autoTextView = (AutoTextView) rootView.findViewById(R.id.autoTextView);
            this.rly = (RelativeLayout) rootView.findViewById(R.id.rly);
        }

    }
}
