package com.example.leshka.schedule_2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leshka.schedule_2.Adapter.TodayListAdapter;
import com.example.leshka.schedule_2.Dialog;
import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.TodayDTO;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Today extends AbstractTabFragment implements TodayListAdapter.TodayListAdapterCallback{

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
        rv.setAdapter(new TodayListAdapter(createMockHalfListData(),this ));
        return view;
    }

    private List<TodayDTO> createMockHalfListData() {
        List<TodayDTO> data = new ArrayList<>();
        String[] s = {
            "1 - Становая тяга",
                    "2 - Вертикальная тяга",
                    "3 - Шраги",
                    "4 - Подъем на бицепс",
                    "5 - Пресс"
        };
        SharedPreferences sPref;
        sPref = getActivity().getSharedPreferences("Gym_file", MODE_PRIVATE);
        for(int i=0;i<5;i++) {
            if (!sPref.contains(s[i])) {
                SharedPreferences.Editor e = sPref.edit();
                e.putString(s[i], "50");
                e.commit();
            }
            data.add(new TodayDTO(s[i],"Вес: " + sPref.getString(s[i],"") + "кг"));
            sPref.getString(s[i], "");
        }
        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(int pos, String str) {
        DialogFragment newFragment = new Dialog();
        Bundle temp=new Bundle();
        temp.putString("1", str);
        newFragment.setArguments(temp);
        newFragment.show(getFragmentManager(), "dlg1");
    }
}
