package com.example.leshka.schedule_2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leshka.schedule_2.Adapter.TomorrowListAdapter;
import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.TomorrowDTO;

import java.util.ArrayList;
import java.util.List;

public class Tomorrow extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_tommorow;

    public static Tomorrow getInstance(Context context){
        Bundle args = new Bundle();
        Tomorrow fragment = new Tomorrow();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.Tab_3_name));


        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleViewTomorrow);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new TomorrowListAdapter(createMockTommorow()));

        return view;
    }

    private List<TomorrowDTO> createMockTommorow() {
        List <TomorrowDTO> data = new ArrayList<>();
        data.add(new TomorrowDTO("1 - Присед"));
        data.add(new TomorrowDTO("2 - Жим гантелей вверх сидя"));
        data.add(new TomorrowDTO("3 - Махи в стороны"));
        data.add(new TomorrowDTO("4 - Тяга к подбородку"));
        data.add(new TomorrowDTO("5 - Квадратрицепс,икры, жим ногами"));

        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
