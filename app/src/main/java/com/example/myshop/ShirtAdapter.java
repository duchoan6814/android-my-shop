package com.example.myshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShirtAdapter extends RecyclerView.Adapter<ShirtAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Shirt> shirts;
    private OnShirtListener onShirtListener;

    public ShirtAdapter(Context context, ArrayList<Shirt> shirts, OnShirtListener onShirtListener) {
        this.context = context;
        this.shirts = shirts;
        this.onShirtListener = onShirtListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View shirtView = inflater.inflate(R.layout.shirt_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(shirtView, onShirtListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shirt shirt = shirts.get(position);
        holder.nameShirt.setText(shirt.getName());
        holder.priceShirt.setText("$"+shirt.getPrice());
    }

    @Override
    public int getItemCount() {
        return shirts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameShirt;
        private TextView priceShirt;
        private OnShirtListener onShirtListener;
        public ViewHolder(@NonNull View itemView, OnShirtListener onShirtListener) {
            super(itemView);

            nameShirt = itemView.findViewById(R.id.tvNameShirt);
            priceShirt = itemView.findViewById(R.id.tvPrice);
            this.onShirtListener = onShirtListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onShirtListener.onShirtClick(getAdapterPosition());
        }
    }

    public interface OnShirtListener {
        public void onShirtClick(int position);
    }
}
