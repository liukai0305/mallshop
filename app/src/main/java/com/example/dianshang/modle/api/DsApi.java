package com.example.dianshang.modle.api;


import com.example.dianshang.bean.classifybean.ClassifyBean;
import com.example.dianshang.bean.homebean.HomeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface DsApi {
    //首页
    @GET("home/content")
    Flowable<HomeBean> getBanner();

    //分类
    @GET("product/categoryTreeList")
    Flowable<ClassifyBean> getClassify();

}
