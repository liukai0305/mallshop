package com.example.dianshang.common;


import com.example.dianshang.app.MyApp;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String Base_Dianshang = "http://169.254.220.9:8085/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "";

}