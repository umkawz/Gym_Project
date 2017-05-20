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
    private final TodayListAdapterCallback listener;



    public TodayListAdapter(List<TodayDTO> data, TodayListAdapterCallback listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public TodayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_item, parent, false);

        return new TodayViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(final TodayViewHolder holder, final int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.text_weight.setText((data.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TodayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public TextView title;
        public TextView text_weight;

        private final TodayListAdapterCallback listener;

        public TodayViewHolder(View itemView, TodayListAdapterCallback listener) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardViewToday);
            title = (TextView)itemView.findViewById(R.id.title_Today);
            text_weight = (TextView)itemView.findViewById(R.id.text_weight_Today);

            this.listener = listener;
            this.itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), String.valueOf(title.getText()));
        }
    }

    public interface TodayListAdapterCallback {
        void onItemClick(int pos, String str);
    }


}
