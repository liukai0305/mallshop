package com.example.dianshang.modle.api;


import com.example.dianshang.bean.homebean.HomeBannerBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface DsApi {
    @GET("home/content")
    Flowable<HomeBannerBean> getBanner();
}
