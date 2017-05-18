package com.example.leshka.schedule_2.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.TodayDTO;

import java.util.List;

/**
 * Created by Leshka on 5/17/2017.
 */

public class TodayListAdapter extends RecyclerView.Adapter<TodayListAdapter.TodayViewHolder>{

    private List <TodayDTO> data;

    public TodayListAdapter(List<TodayDTO> data) {
        this.data = data;
    }

    @Override
    public TodayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_item, parent, false);

        return new TodayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodayViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TodayViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;

        public TodayViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardViewToday);
            title = (TextView)itemView.findViewById(R.id.titleToday);
        }


    }
}
