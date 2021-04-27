package com.example.myshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ShirtAdapter.OnShirtListener {

    private RecyclerView recyclerView;
    private ShirtAdapter shirtAdapter;
    private ArrayList<Shirt> listShirt;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcvMain);

        listShirt = new ArrayList<>();
        order = new Order();

        createListShirt();

        shirtAdapter = new ShirtAdapter(this, listShirt, this);
        recyclerView.setAdapter(shirtAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
//        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void createListShirt() {
        listShirt.add(new Shirt("1", "Google Shirt", 15));
        listShirt.add(new Shirt("2", "CoderX", 20));
        listShirt.add(new Shirt("3", "Facebook Shirt", 23));
        listShirt.add(new Shirt("4", "Nail Shirt", 3));
        listShirt.add(new Shirt("5", "HelloWorld Shirt", 150));
        listShirt.add(new Shirt("6", "My Shirt", 99999));
        listShirt.add(new Shirt("7", "Boss Cat", 17));
        listShirt.add(new Shirt("8", "New bike Shirt", 1));
    }

    @Override
    public void onShirtClick(int position) {
        Shirt shirt = listShirt.get(position);
        Intent intent = new Intent(this, DetailShirt.class);
        intent.putExtra("data_item", shirt);
        intent.putExtra("order", order);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}