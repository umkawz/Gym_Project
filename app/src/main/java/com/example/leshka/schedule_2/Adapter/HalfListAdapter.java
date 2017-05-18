package com.example.leshka.schedule_2.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.leshka.schedule_2.R;
import com.example.leshka.schedule_2.dto.HalfDTO;

import java.util.List;

/**
 * Created by Leshka on 5/17/2017.
 */

public class HalfListAdapter extends RecyclerView.Adapter<HalfListAdapter.HalfViewHolder> implements View.OnClickListener{

    private List <HalfDTO> data;

    public HalfListAdapter(List<HalfDTO> data) {
        this.data = data;
    }

    @Override
    public HalfViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.half_item, parent, false);

        return new HalfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HalfViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.title.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("1",String.valueOf(holder.title.getText()));
                //Log.d("TAG", "НАЖАТО");
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {

    }

    public static class HalfViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public Button title;

        public HalfViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (Button)itemView.findViewById(R.id.title);
        }


    }
}
