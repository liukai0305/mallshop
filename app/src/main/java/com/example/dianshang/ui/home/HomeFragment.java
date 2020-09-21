package com.example.dianshang.ui.home;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.dianshang.R;
import com.example.dianshang.adapter.home.BannerAdapter;
import com.example.dianshang.adapter.home.BrandAdapter;
import com.example.dianshang.adapter.home.FuFreshAdapter;
import com.example.dianshang.adapter.home.FuGuessyouAdapter;
import com.example.dianshang.adapter.home.FuPopularityAdapter;
import com.example.dianshang.adapter.home.FuSpecialAdapter;
import com.example.dianshang.adapter.home.HomeBrandAdapter;
import com.example.dianshang.adapter.home.HomeMarqueeAdappter;
import com.example.dianshang.adapter.home.HomeSeckillAdapter;
import com.example.dianshang.adapter.home.NavigationAdapter;
import com.example.dianshang.adapter.home.SeckillAdapter;
import com.example.dianshang.base.BaseFragment;
import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.bean.homebean.NavigationBean;
import com.example.dianshang.interfaces.home.IHome;
import com.example.dianshang.persenter.home.HomePersenter;
import com.example.dianshang.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<IHome.Persenter> implements IHome.View {


    @BindView(R.id.rcy)
    RecyclerView rcy;

    private ArrayList<HomeBean.DataBean.AdvertiseListBean> list;
    private BannerAdapter bannerAdapter;
    private ArrayList<NavigationBean> navigationList;
    private HomeMarqueeAdappter homeMarqueeAdappter;
    private ArrayList<HomeBean.DataBean.HotProductListBean> list1;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBean;
    private ArrayList<HomeBean.DataBean.NewProductListBean> newProductListBeans;
    private SeckillAdapter seckillAdapter;
    private ArrayList<HomeBean.DataBean.HotProductListBean> XinXianList;
    private FuFreshAdapter fuFreshAdapter;
    private ArrayList<HomeBean.DataBean.HotProductListBean> renqilist;
    private FuPopularityAdapter fuPopularityAdapter;
    private ArrayList<HomeBean.DataBean.AdvertiseListBean> zhuantilist;
    private FuSpecialAdapter fuSpecialAdapter;
    private ArrayList<HomeBean.DataBean.HotProductListBean> cainiList;
    private FuGuessyouAdapter fuGuessyouAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        //头部
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        rcy.setLayoutManager(virtualLayoutManager);
        rcy.setAdapter(delegateAdapter);
        //轮播图
        list = new ArrayList<>();
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        bannerAdapter = new BannerAdapter(list, getActivity(), singleLayoutHelper);
        delegateAdapter.addAdapter(bannerAdapter);
        //横向导航
        NavigationBean data1 = new NavigationBean(R.mipmap.huati, "话题");
        NavigationBean data2 = new NavigationBean(R.mipmap.youxuan, "优选");
        NavigationBean data3 = new NavigationBean(R.mipmap.tehui, "特惠");
        NavigationBean data4 = new NavigationBean(R.mipmap.qiandao, "签到");
        navigationList = new ArrayList<>();
        navigationList.add(data1);
        navigationList.add(data2);
        navigationList.add(data3);
        navigationList.add(data4);
        GridLayoutHelper helper = new GridLayoutHelper(4);
        NavigationAdapter navigationAdapter = new NavigationAdapter(context, navigationList, helper);
        navigationAdapter.notifyDataSetChanged();
        navigationAdapter.setOnClickList(new NavigationAdapter.OnClickList() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(context, "哈哈" + position, Toast.LENGTH_SHORT).show();
            }
        });
        delegateAdapter.addAdapter(navigationAdapter);
        //广告
        list1 = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        homeMarqueeAdappter = new HomeMarqueeAdappter(list1, getActivity(), linearLayoutHelper);
        delegateAdapter.addAdapter(homeMarqueeAdappter);
        //品牌
        brandListBean = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        BrandAdapter brandAdapter = new BrandAdapter(brandListBean, getActivity(), linearLayoutHelper1);
        delegateAdapter.addAdapter(brandAdapter);

        //秒杀
        newProductListBeans = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper2 = new LinearLayoutHelper();
        seckillAdapter = new SeckillAdapter(newProductListBeans, getActivity(), linearLayoutHelper2);
        delegateAdapter.addAdapter(seckillAdapter);

        //新鲜
        XinXianList = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper3 = new LinearLayoutHelper();
        fuFreshAdapter = new FuFreshAdapter(XinXianList, getActivity(), linearLayoutHelper3);
        delegateAdapter.addAdapter(fuFreshAdapter);

        //人气
        renqilist = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper4 = new LinearLayoutHelper();
        fuPopularityAdapter = new FuPopularityAdapter(renqilist, getActivity(), linearLayoutHelper4);
        delegateAdapter.addAdapter(fuPopularityAdapter);

        //专题
        zhuantilist = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper5 = new LinearLayoutHelper();
        fuSpecialAdapter = new FuSpecialAdapter(zhuantilist, getActivity(), linearLayoutHelper5);
        delegateAdapter.addAdapter(fuSpecialAdapter);

        //猜你
        cainiList = new ArrayList<>();
        LinearLayoutHelper linearLayoutHelper6 = new LinearLayoutHelper();
        fuGuessyouAdapter = new FuGuessyouAdapter(cainiList, getActivity(), linearLayoutHelper6);
        delegateAdapter.addAdapter(fuGuessyouAdapter);

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
    public void getBannerReturn(HomeBean result) {
        //轮播图
        list.addAll(result.getData().getAdvertiseList());
        bannerAdapter.notifyDataSetChanged();
        //上下广告
        list1.addAll(result.getData().getHotProductList());
        homeMarqueeAdappter.notifyDataSetChanged();
        //品牌
        brandListBean.addAll(result.getData().getBrandList());
        bannerAdapter.notifyDataSetChanged();
        //秒杀
        newProductListBeans.addAll(result.getData().getNewProductList());
        seckillAdapter.notifyDataSetChanged();
        //新鲜
        XinXianList.addAll(result.getData().getHotProductList());
        fuFreshAdapter.notifyDataSetChanged();
        //人气
        renqilist.addAll(result.getData().getHotProductList());
        fuPopularityAdapter.notifyDataSetChanged();
        //专题
        zhuantilist.addAll(result.getData().getAdvertiseList());
        fuSpecialAdapter.notifyDataSetChanged();
        //猜你
        cainiList.addAll(result.getData().getHotProductList());
        fuGuessyouAdapter.notifyDataSetChanged();
    }
}