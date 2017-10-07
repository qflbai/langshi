package com.bai.langshi.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bai.langshi.R;
import com.bai.langshi.ui.fragment.ChannerFragment;
import com.bai.langshi.ui.fragment.DiscoverFragment;
import com.bai.langshi.ui.fragment.Myfragment;
import com.bai.langshi.util.http.RetrofitUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TabLayout mTabLayout;
    private Toolbar mToolBar;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initUIData();

    }


    private void initView(){
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

    }


    private void initUIData() {
        mToolBar.inflateMenu(R.menu.menu);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();

        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new ChannerFragment());
        fragmentList.add(new Myfragment());

        titleList.add("发现");
        titleList.add("频道");
        titleList.add("我的");

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(), fragmentList, titleList);
        mViewPager.setAdapter(viewpagerAdapter);


        mTabLayout.setupWithViewPager(mViewPager);

        RetrofitUtil.getInfo();
    }

    class ViewpagerAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> fragmentList;
        private ArrayList<String> titleList;
        public ViewpagerAdapter(FragmentManager fm,ArrayList<Fragment> fragmentList,ArrayList<String> titleList) {
            super(fm);
            this.fragmentList = fragmentList;
            this.titleList = titleList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }


    }
}
