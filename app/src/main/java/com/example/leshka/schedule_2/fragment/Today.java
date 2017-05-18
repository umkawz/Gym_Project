package com.example.leshka.schedule_2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leshka.schedule_2.Adapter.TodayListAdapter;
import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.TodayDTO;

import java.util.ArrayList;
import java.util.List;

public class Today extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_today;

    public static Today getInstance(Context context){
        Bundle args = new Bundle();
        Today fragment = new Today();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.Tab_2_name));


        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleViewToday);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new TodayListAdapter(createMockHalfListData()));

        return view;
    }

    private List<TodayDTO> createMockHalfListData() {
        List<TodayDTO> data = new ArrayList<>();
        data.add(new TodayDTO("1 - Становая тяга"));
        data.add(new TodayDTO("2 - Вертикальная тяга"));
        data.add(new TodayDTO("3 - Шраги"));
        data.add(new TodayDTO("4 - Подъем на бицепс"));
        data.add(new TodayDTO("5 - Пресс"));

        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
