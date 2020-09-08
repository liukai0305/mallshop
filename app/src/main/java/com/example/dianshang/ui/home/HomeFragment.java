package com.example.dianshang.ui.home;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dianshang.R;
import com.example.dianshang.base.BaseFragment;
import com.example.dianshang.bean.homebean.HomeBannerBean;
import com.example.dianshang.common.AutoTextView;
import com.example.dianshang.interfaces.home.IHome;
import com.example.dianshang.persenter.home.HomePersenter;
import com.example.dianshang.utils.DateUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<IHome.Persenter> implements IHome.View {


    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.huati)
    TextView huati;
    @BindView(R.id.youxuan)
    TextView youxuan;
    @BindView(R.id.tehui)
    TextView tehui;
    @BindView(R.id.qiandao)
    TextView qiandao;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.img_home_xiaoxi)
    ImageView imgHomeXiaoxi;
    @BindView(R.id.autoTextView)
    AutoTextView autoTextView;
    @BindView(R.id.ll1)
    RelativeLayout ll1;
    @BindView(R.id.gengduo)
    ImageView gengduo;
    @BindView(R.id.pin)
    TextView pin;
    @BindView(R.id.home_rcy_pinpai)
    RecyclerView homeRcyPinpai;
    @BindView(R.id.txt_seckill)
    TextView txtSeckill;
    @BindView(R.id.txt_next)
    TextView txtNext;
    @BindView(R.id.txt_time_left)
    TextView txtTimeLeft;
    @BindView(R.id.tv_time_hour)
    TextView tvHour;
    @BindView(R.id.tv_time_minute)
    TextView tvMinute;
    @BindView(R.id.tv_time_second)
    TextView tvSecond;
    @BindView(R.id.linea_time)
    LinearLayout lineaTime;
    @BindView(R.id.rcl_seckill)
    RecyclerView rclSeckill;
    @BindView(R.id.cons_seckill)
    ConstraintLayout consSeckill;
    @BindView(R.id.xin)
    TextView xin;
    @BindView(R.id.geng)
    ImageView geng;
    @BindView(R.id.home_rcy_xin)
    RecyclerView homeRcyXin;
    @BindView(R.id.renqi)
    TextView renqi;
    @BindView(R.id.duo)
    ImageView duo;
    @BindView(R.id.home_rcy_renqi)
    RecyclerView homeRcyRenqi;
    @BindView(R.id.zhuanti)
    TextView zhuanti;
    @BindView(R.id.zhuan)
    ImageView zhuan;
    @BindView(R.id.home_rcy_zhuanti)
    RecyclerView homeRcyZhuanti;
    @BindView(R.id.caini)
    TextView caini;
    @BindView(R.id.home_rcy_caini)
    RecyclerView homeRcyCaini;
    private List<String> arrList = new ArrayList<String>();
    private Handler handler = new Handler();
    private int count = 0;
    private Runnable runnable;
    private TimeThread timeThread;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        initTime();
        timeThread = new TimeThread();
        timeThread.start();
    }

    private void initTime() {
        String time = DateUtil.getTime();
        String[] timeSplit = time.split(":");
        if (timeSplit.length > 0) {
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = 60 - Integer.parseInt(timeSplit[1]);
            int second = 60 - Integer.parseInt(timeSplit[2]);
            if (txtNext != null && tvHour != null && tvSecond != null && tvMinute != null) {
                txtNext.setText("下一场" + (hour + 1) + "：00开始");
                tvHour.setText("00");
                tvMinute.setText(minute + "");
                tvSecond.setText(second + "");
                if (minute < 10) {
                    tvMinute.setText("0" + minute);
                }
                if (second < 10) {
                    tvSecond.setText("0" + second);
                }
                if (minute == 60) {
                    tvMinute.setText("00");
                }
                if (second == 60) {
                    tvSecond.setText("00");
                }
                if (minute == 0 && second == 0) {
                    tvHour.setText("01");
                    tvMinute.setText("00");
                    tvSecond.setText("00");
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

    private void getGunDong() {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    handler.postDelayed(this, 1000);
                    autoTextView.next();
                    autoTextView.setText(arrList.get(count % arrList.size()));
                    count++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    protected IHome.Persenter initPersenter() {
        return new HomePersenter();
    }

    @Override
    protected void initData() {
        persenter.getBanner();
    }

    @Override
    public void getBannerReturn(HomeBannerBean result) {
        homeBanner.setImages(result.getData().getAdvertiseList())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBannerBean.DataBean.AdvertiseListBean brandListBean = (HomeBannerBean.DataBean.AdvertiseListBean) path;
                        Glide.with(context).load(brandListBean.getPic()).into(imageView);
                    }
                })
                .setDelayTime(2000)
                .start();
        List<HomeBannerBean.DataBean.AdvertiseListBean> list = result.getData().getAdvertiseList();
        for (int i = 0; i < list.size(); i++) {
            arrList.add(list.get(i).getName());
        }
        getGunDong();
        handler.postDelayed(runnable, 0);
    }
}