package com.example.leshka.schedule_2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leshka.schedule_2.Adapter.HalfListAdapter;
import com.example.leshka.schedule_2.Dialog;
import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.HalfDTO;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Half extends AbstractTabFragment implements HalfListAdapter.HalfListAdapterCallback{

    private static final int LAYOUT = R.layout.fragment_half;

    public static Half getInstance(Context context){
        Bundle args = new Bundle();
        Half fragment = new Half();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.Tab_1_name));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new HalfListAdapter(createMockHalfListData(),this ));
        return view;
    }

    private List<HalfDTO> createMockHalfListData() {
        List<HalfDTO> data = new ArrayList<>();
        String[] s = {
            "1 - Жим лёжа",
                    "2 - Махи вперед",
                    "3 - Разводка лёжа",
                    "4 - Тяга блока к низу",
                    "5 - Pull-over"
        };
        SharedPreferences sPref;
        sPref = getActivity().getSharedPreferences("Gym_file", MODE_PRIVATE);
        for(int i=0;i<5;i++) {
            if (!sPref.contains(s[i])) {
                SharedPreferences.Editor e = sPref.edit();
                e.putString(s[i], "50");
                e.commit();
            }
            data.add(new HalfDTO(s[i],"Вес: " + sPref.getString(s[i],"") + "кг"));
            sPref.getString(s[i], "");
        }
        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(int pos, String str) {
        Log.d("1", String.valueOf(pos));
        DialogFragment newFragment = new Dialog();
        Bundle temp=new Bundle();
        temp.putString("1", str);
        newFragment.setArguments(temp);
        newFragment.show(getFragmentManager(), "dlg1");
    }
}
