package com.example.dianshang.interfaces.classify;

import com.example.dianshang.bean.classifybean.ClassifyBean;
import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.interfaces.IBasePersenter;
import com.example.dianshang.interfaces.IBaseView;
import com.example.dianshang.interfaces.home.IHome;

public interface IClassify {
    interface View extends IBaseView {
        void getClassifyReturn(ClassifyBean result);
    }

    interface Persenter extends IBasePersenter<IClassify.View> {
        void getClassify();
    }
}
