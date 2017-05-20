package com.example.leshka.schedule_2.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.HalfDTO;

import java.util.List;

/**
 * Created by Leshka on 5/17/2017.
 */

public class HalfListAdapter extends RecyclerView.Adapter<HalfListAdapter.HalfViewHolder>{


    private List <HalfDTO> data;
    private final HalfListAdapterCallback listener;



    public HalfListAdapter(List<HalfDTO> data, HalfListAdapterCallback listener) {
        this.data = data;
        this.listener = listener;
    }

    @Override
    public HalfViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.half_item, parent, false);

        return new HalfViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(final HalfViewHolder holder, final int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.text_weight.setText((data.get(position).getWeight()));
//        holder.title.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Log.d("1",String.valueOf(holder.title.getText()));
//                Log.d("1",String.valueOf(holder.getAdapterPosition()));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class HalfViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView cardView;
        public TextView title;
        public TextView text_weight;

        private final HalfListAdapterCallback listener;

        public HalfViewHolder(View itemView, HalfListAdapterCallback listener) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView)itemView.findViewById(R.id.title);
            text_weight = (TextView)itemView.findViewById(R.id.text_weight);

            this.listener = listener;
            this.itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), String.valueOf(title.getText()));
        }
    }

    public interface HalfListAdapterCallback {
        void onItemClick(int pos, String str);
    }


}
