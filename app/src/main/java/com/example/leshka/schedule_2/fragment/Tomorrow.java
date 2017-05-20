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

import com.example.leshka.schedule_2.Adapter.TomorrowListAdapter;
import com.example.leshka.schedule_2.Dialog;
import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.TomorrowDTO;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Tomorrow extends AbstractTabFragment implements TomorrowListAdapter.TomorrowListAdapterCallback{

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
        rv.setAdapter(new TomorrowListAdapter(createMockHalfListData(),this ));
        return view;
    }

    private List<TomorrowDTO> createMockHalfListData() {
        List<TomorrowDTO> data = new ArrayList<>();
        String[] s = {
            "1 - Присед",
                    "2 - Жим гантелей вверх сидя",
                    "3 - Махи в стороны",
                    "4 - Тяга к подбородку",
                    "5 - Квадратрицепс,икры, жим ногами"
        };
        SharedPreferences sPref;
        sPref = getActivity().getSharedPreferences("Gym_file", MODE_PRIVATE);
        for(int i=0;i<5;i++) {
            if (!sPref.contains(s[i])) {
                SharedPreferences.Editor e = sPref.edit();
                e.putString(s[i], "50");
                e.commit();
            }
            data.add(new TomorrowDTO(s[i],"Вес: " + sPref.getString(s[i],"") + "кг"));
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