package com.example.leshka.schedule_2.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Leshka on 5/17/2017.
 */

public class AbstractTabFragment extends Fragment {
    private String title;
    protected View view;
    protected Context context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
