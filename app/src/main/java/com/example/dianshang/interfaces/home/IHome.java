package com.example.dianshang.interfaces.home;

import com.example.dianshang.bean.homebean.HomeBean;
import com.example.dianshang.interfaces.IBasePersenter;
import com.example.dianshang.interfaces.IBaseView;

public interface IHome  {
    interface View extends IBaseView {
        void getBannerReturn(HomeBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getBanner();
    }


}
