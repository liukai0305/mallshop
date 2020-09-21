package com.example.dianshang.adapter.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.utils.DateUtil;

import java.util.ArrayList;

public class SeckillAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.NewProductListBean> list;
    private Context context;
    private LayoutHelper layoutHelper;
    private Handler handler = new Handler();
    private int count = 0;
    private Runnable runnable;
    private TimeThread timeThread;
    private ViewHolder holder1;

    public SeckillAdapter(ArrayList<HomeBean.DataBean.NewProductListBean> list, Context context, LayoutHelper layoutHelper) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_seckill, parent, false);

        return new ViewHolder(inflate) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        holder1 = (ViewHolder) holder;
        initTime();
        timeThread = new TimeThread();
        timeThread.start();
        HomeSeckillAdapter homeSeckillAdapter = new HomeSeckillAdapter(list, context);
        holder1.rcl_seckill.setLayoutManager(new GridLayoutManager(context, 2));
        holder1.rcl_seckill.setAdapter(homeSeckillAdapter);
    }



    @Override
    public int getItemCount() {
        return 1;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView txt_seckill;
        public TextView txt_next;
        public TextView txt_time_left;
        public TextView tv_time_hour;
        public TextView tv_time_minute;
        public TextView tv_time_second;
        public LinearLayout linea_time;
        public RecyclerView rcl_seckill;
        public ConstraintLayout cons_seckill;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.txt_seckill = (TextView) rootView.findViewById(R.id.txt_seckill);
            this.txt_next = (TextView) rootView.findViewById(R.id.txt_next);
            this.txt_time_left = (TextView) rootView.findViewById(R.id.txt_time_left);
            this.tv_time_hour = (TextView) rootView.findViewById(R.id.tv_time_hour);
            this.tv_time_minute = (TextView) rootView.findViewById(R.id.tv_time_minute);
            this.tv_time_second = (TextView) rootView.findViewById(R.id.tv_time_second);
            this.linea_time = (LinearLayout) rootView.findViewById(R.id.linea_time);
            this.rcl_seckill = (RecyclerView) rootView.findViewById(R.id.rcl_seckill);
            this.cons_seckill = (ConstraintLayout) rootView.findViewById(R.id.cons_seckill);
        }

    }

    private void initTime() {
        String time = DateUtil.getTime();
        String[] timeSplit = time.split(":");
        if (timeSplit.length > 0) {
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = 60 - Integer.parseInt(timeSplit[1]);
            int second = 60 - Integer.parseInt(timeSplit[2]);
            if (holder1.txt_next != null && holder1.tv_time_hour != null && holder1.tv_time_second != null && holder1.tv_time_minute != null) {
                holder1.txt_next.setText("下一场" + (hour + 1) + "：00开始");
                holder1.tv_time_hour.setText("00");
                holder1.tv_time_minute.setText(minute + "");
                holder1.tv_time_second.setText(second + "");
                if (minute < 10) {
                    holder1.tv_time_minute.setText("0" + minute);
                }
                if (second < 10) {
                    holder1.tv_time_second.setText("0" + second);
                }
                if (minute == 60) {
                    holder1.tv_time_minute.setText("00");
                }
                if (second == 60) {
                    holder1.tv_time_second.setText("00");
                }
                if (minute == 0 && second == 0) {
                    holder1.tv_time_hour.setText("01");
                    holder1.tv_time_minute.setText("00");
                    holder1.tv_time_second.setText("00");
                }
            }
        }
    }

    private static final int msgKey1 = 1;

    public class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    initTime();
                    break;
                default:
                    break;
            }
        }
    };
}
