package com.example.dianshang;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dianshang.base.BaseActivity;
import com.example.dianshang.interfaces.IBasePersenter;
import com.example.dianshang.ui.classify.ClassifyFragment;
import com.example.dianshang.ui.home.HomeFragment;
import com.example.dianshang.ui.own.OwnFragment;
import com.example.dianshang.ui.special.SpecialFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity {

    private RelativeLayout rly;
    private ClassifyFragment classifyFragment;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private OwnFragment ownFragment;
    private TabLayout tab;
    private FragmentManager supportFragmentManager;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    protected void initView() {
        supportFragmentManager = getSupportFragmentManager();
        rly = (RelativeLayout) findViewById(R.id.rly);
        tab = (TabLayout) findViewById(R.id.tab);
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        specialFragment = new SpecialFragment();
        ownFragment = new OwnFragment();
        initHome();
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.select_home), 0);
        tab.addTab(tab.newTab().setText("分类").setIcon(R.drawable.select_classify), 1);
        tab.addTab(tab.newTab().setText("专题").setIcon(R.drawable.select_special), 2);
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.select_own), 3);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                initFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected IBasePersenter initPersenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    private void initFragment(int position) {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        switch (position) {
            case 0:
                if (!homeFragment.isAdded()) {
                    fragmentTransaction.add(R.id.rly, homeFragment).hide(classifyFragment).hide(specialFragment).hide(ownFragment);
                }
                fragmentTransaction.show(homeFragment).hide(classifyFragment).hide(specialFragment).hide(ownFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                if (!classifyFragment.isAdded()) {
                    fragmentTransaction.add(R.id.rly, classifyFragment).hide(homeFragment).hide(specialFragment).hide(ownFragment);
                }
                fragmentTransaction.show(classifyFragment).hide(homeFragment).hide(specialFragment).hide(ownFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                if (!specialFragment.isAdded()) {
                    fragmentTransaction.add(R.id.rly, specialFragment).hide(classifyFragment).hide(homeFragment).hide(ownFragment);
                }
                fragmentTransaction.show(specialFragment).hide(classifyFragment).hide(homeFragment).hide(ownFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                if (!ownFragment.isAdded()) {
                    fragmentTransaction.add(R.id.rly, ownFragment).hide(classifyFragment).hide(specialFragment).hide(homeFragment);
                }
                fragmentTransaction.show(ownFragment).hide(classifyFragment).hide(specialFragment).hide(homeFragment);
                fragmentTransaction.commit();
                break;
        }
    }

    private void initHome() {
        supportFragmentManager.beginTransaction()
                .add(R.id.rly, homeFragment)
                .show(homeFragment)
                .commit();
    }
}