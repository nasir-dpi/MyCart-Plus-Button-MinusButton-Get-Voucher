package com.example.mycart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        productList.add(
                new Product(
                        1,
                        "MULTIFUNCTION EXPANDABLE MAGI...",
                        "Master Kitchen, Color Family : Green",
                        6500.00,R.drawable.macbook));
        productList.add(
                new Product(
                        1,
                        "CURREN 8083 Silver Stainless Steel Chr....",
                        "CURREN Watch strap Color : Silver",
                        6500.00,R.drawable.macbook));
        productList.add(
                new Product(
                        1,
                        "Double Part # in ! inflatable Travelling Pi...",
                        "Wall Touch Color Family : Light Green",
                        6500.00,R.drawable.macbook));
        productList.add(
                new Product(
                        1,
                        "Double Part # in ! inflatable Travelling Pi...",
                        "Wall Touch Color Family : Light Green",
                        6500.00,R.drawable.macbook));


        adapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);



    }
}
