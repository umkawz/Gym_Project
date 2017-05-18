package com.example.leshka.schedule_2.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.TomorrowDTO;

import java.util.List;

/**
 * Created by Leshka on 5/17/2017.
 */

public class TomorrowListAdapter extends RecyclerView.Adapter<TomorrowListAdapter.TomorrowViewHolder>{

    private List <TomorrowDTO> data;

    public TomorrowListAdapter(List<TomorrowDTO> data) {
        this.data = data;
    }

    @Override
    public TomorrowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tomorrow_item, parent, false);

        return new TomorrowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TomorrowViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TomorrowViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;

        public TomorrowViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardViewTomorrow);
            title = (TextView)itemView.findViewById(R.id.titleTomorrow);
        }


    }
}
