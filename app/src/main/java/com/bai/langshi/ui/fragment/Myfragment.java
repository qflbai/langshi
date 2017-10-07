package com.bai.langshi.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bai.langshi.R;

/**
 * Created by bai on 2017/10/3.
 */

public class Myfragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragment_my_view = inflater.inflate(R.layout.fragment_my, container, false);
        return fragment_my_view;
    }
}
