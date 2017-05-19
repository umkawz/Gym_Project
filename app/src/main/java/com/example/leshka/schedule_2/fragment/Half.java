package com.example.leshka.schedule_2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.leshka.schedule_2.Adapter.HalfListAdapter;
import com.example.leshka.schedule_2.Dialog;
import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.HalfDTO;

import java.util.ArrayList;
import java.util.List;

public class Half extends AbstractTabFragment implements HalfListAdapter.HalfListAdapterCallback{

    private static final int LAYOUT = R.layout.fragment_half;
    private Button button;

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
        data.add(new HalfDTO("1 - Жим лёжа"));
        data.add(new HalfDTO("2 - Махи вперед"));
        data.add(new HalfDTO("3 - Разводка лёжа"));
        data.add(new HalfDTO("4 - Тяга блока к низу"));
        data.add(new HalfDTO("5 - Pull-over"));
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
