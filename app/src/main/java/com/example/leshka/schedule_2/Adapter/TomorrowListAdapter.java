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
    private final TomorrowListAdapterCallback listener;



    public TomorrowListAdapter(List<TomorrowDTO> data, TomorrowListAdapterCallback listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public TomorrowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tomorrow_item, parent, false);

        return new TomorrowViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(final TomorrowViewHolder holder, final int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.text_weight.setText((data.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class TomorrowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public TextView title;
        public TextView text_weight;

        private final TomorrowListAdapterCallback listener;

        public TomorrowViewHolder(View itemView, TomorrowListAdapterCallback listener) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView_Tomorrow);
            title = (TextView)itemView.findViewById(R.id.title_Tomorrow);
            text_weight = (TextView)itemView.findViewById(R.id.text_weight_Tomorrow);

            this.listener = listener;
            this.itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), String.valueOf(title.getText()));
        }
    }

    public interface TomorrowListAdapterCallback {
        void onItemClick(int pos, String str);
    }


}
