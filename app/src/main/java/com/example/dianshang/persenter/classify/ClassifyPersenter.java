package com.example.dianshang.persenter.classify;

import com.example.dianshang.base.BasePersenter;
import com.example.dianshang.bean.classifybean.ClassifyBean;
import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.common.CommonSubscriber;
import com.example.dianshang.interfaces.classify.IClassify;
import com.example.dianshang.modle.HttpManager;
import com.example.dianshang.utils.RxUtils;

public class ClassifyPersenter extends BasePersenter<IClassify.View> implements IClassify.Persenter {
    @Override
    public void getClassify() {
        addSubscribe(HttpManager.getInstance().getDsApi().getClassify()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ClassifyBean>(mView) {
                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        mView.getClassifyReturn(classifyBean);
                    }
                })
        );
    }
}
