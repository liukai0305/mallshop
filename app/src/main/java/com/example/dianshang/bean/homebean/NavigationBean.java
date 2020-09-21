package com.example.dianshang.bean.homebean;



import android.widget.ImageView;
import android.widget.TextView;

public class NavigationBean {
    private int imgHead;
    private String tv_name;

    public NavigationBean(int imgHead, String tv_name) {
        this.imgHead = imgHead;
        this.tv_name = tv_name;
    }

    public int getImgHead() {
        return imgHead;
    }

    public void setImgHead(int imgHead) {
        this.imgHead = imgHead;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }
}
