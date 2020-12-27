package com.bunoza.domagoj.recyclerapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView tvName;
    private ImageButton btnRemove;
    private NameClickListener clickListener;


    public NameViewHolder(@NonNull View itemView, NameClickListener listener ) {
        super(itemView);
        this.clickListener = listener;
        tvName =  itemView.findViewById(R.id.tvName);
        itemView.setOnClickListener(this);
        this.btnRemove = itemView.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    clickListener.onButtonClick(getAdapterPosition());
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        });
    }

    public void setName(String name){
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        clickListener.onNameClick(getAdapterPosition());
    }
}
