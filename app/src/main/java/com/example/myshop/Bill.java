package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Bill extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        order = (Order) getIntent().getSerializableExtra("order");

        recyclerView = findViewById(R.id.recyclerView);

        OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter(this, order.getListOrderDetail());

        recyclerView.setAdapter(orderDetailAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}