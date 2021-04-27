package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailShirt extends AppCompatActivity {
    private Shirt shirt;
    private TextView tvNameShirt, tvPrice;
    private Button btnSubmit;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shirt);
        shirt = (Shirt) getIntent().getSerializableExtra("data_item");
        order = (Order) getIntent().getSerializableExtra("order");

        tvNameShirt = findViewById(R.id.tvNameShirt);
        tvPrice = findViewById(R.id.tvPrice);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvNameShirt.setText(shirt.getName());
        tvPrice.setText("$"+shirt.getPrice());

        btnSubmit.setOnClickListener(v -> handleOnclickButtonSubmit());

    }

    private void handleOnclickButtonSubmit() {
        order.getListOrderDetail().add(new OrderDetail(this.shirt, "XL", 1));

        Intent intent = new Intent(this, Bill.class);
        intent.putExtra("order", this.order);
        startActivity(intent);
    }

}