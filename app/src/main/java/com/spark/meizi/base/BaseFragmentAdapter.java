package com.spark.meizi.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by SparkYuan on 16/6/20.
 * Github: github.com/SparkYuan
 */
public class BaseFragmentAdapter<T extends Fragment> extends FragmentStatePagerAdapter {

    private List<T> fragments;
    private List<String> titles;

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setData(List<String> titles, List<T> fragments) {
        this.titles = titles;
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public void setData(List<T> fragments){
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return (null == fragments) ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null)
            return titles.get(position);
        else
            return "";
    }
}