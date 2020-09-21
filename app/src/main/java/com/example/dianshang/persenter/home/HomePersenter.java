package com.example.dianshang.persenter.home;

import com.example.dianshang.base.BasePersenter;
import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.common.CommonSubscriber;
import com.example.dianshang.interfaces.home.IHome;
import com.example.dianshang.modle.HttpManager;
import com.example.dianshang.utils.RxUtils;

public class HomePersenter extends BasePersenter<IHome.View> implements IHome.Persenter {
    @Override
    public void getBanner() {
        addSubscribe(HttpManager.getInstance().getDsApi().getBanner()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean homeBannerBean) {
                        mView.getBannerReturn(homeBannerBean);
                    }
                })
        );
    }
}
