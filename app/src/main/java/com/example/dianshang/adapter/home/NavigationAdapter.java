package com.example.dianshang.adapter.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.NavigationBean;


import java.util.List;

public class NavigationAdapter extends DelegateAdapter.Adapter<NavigationAdapter.ViewHolder> {

    private Context context;
    private List<NavigationBean> list;
    private LayoutHelper layoutHelper;
    private OnClickList onClickList;

    public void setOnClickList(OnClickList onClickList) {
        this.onClickList = onClickList;
    }

    public NavigationAdapter(Context context, List<NavigationBean> list, LayoutHelper layoutHelper) {
        this.context = context;
        this.list = list;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_navigation_adapter, parent, false);
        return new ViewHolder(view);
    }

    private static final String TAG = "NavigationAdapter";
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+list.size());
        holder.iv.setBackgroundResource(list.get(position).getImgHead());
        holder.tv.setText(list.get(position).getTv_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClickList!=null){
                    onClickList.OnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_navigation);
            tv = itemView.findViewById(R.id.tv_navigation);
        }
    }

    public interface OnClickList{
        void OnClick(int position);
    }
}
