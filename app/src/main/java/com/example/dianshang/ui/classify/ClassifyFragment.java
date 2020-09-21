package com.example.dianshang.ui.classify;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dianshang.R;
import com.example.dianshang.base.BaseFragment;
import com.example.dianshang.bean.classifybean.ClassifyBean;
import com.example.dianshang.interfaces.classify.IClassify;
import com.example.dianshang.persenter.classify.ClassifyPersenter;


public class ClassifyFragment extends BaseFragment<IClassify.Persenter> implements IClassify.View {

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected IClassify.Persenter initPersenter() {
        return new ClassifyPersenter();
    }

    @Override
    protected void initData() {
        persenter.getClassify();
    }

    @Override
    public void getClassifyReturn(ClassifyBean result) {

    }
}