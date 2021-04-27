package com.example.myshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {

    private Context context;
    private List<OrderDetail> listOrderDetail;

    public OrderDetailAdapter(Context context, List<OrderDetail> listOrderDetail) {
        this.context = context;
        this.listOrderDetail = listOrderDetail;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View orderDetailView = inflater.inflate(R.layout.order_detail, parent, false);
        ViewHolder viewHolder = new ViewHolder(orderDetailView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderDetail orderDetail = this.listOrderDetail.get(position);
        holder.nameShirt.setText(orderDetail.getShirt().getName());
        holder.sizeShirt.setText("Size "+orderDetail.getSize());
        holder.priceShirt.setText("$"+orderDetail.tinhTotalGia());
    }

    @Override
    public int getItemCount() {
        return listOrderDetail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameShirt;
        private TextView sizeShirt;
        private TextView priceShirt;
        private TextView numberShirt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameShirt = itemView.findViewById(R.id.tvShirtName);
            sizeShirt = itemView.findViewById(R.id.tvSize);
            priceShirt = itemView.findViewById(R.id.tvPriceShirt);
            numberShirt = itemView.findViewById(R.id.tvNumber);

        }
    }
}
