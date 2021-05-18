package com.example.a18077431_nguyenphanhuynhduc_android_tuan4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements PurchaseProduct{
    private TextView tvGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGia = findViewById(R.id.txtGia);
        getSupportFragmentManager().beginTransaction().add(R.id.belowFragment,new BelowFragment()).commit();
    }

    @Override
    public void addProduct(int quantity, double donGia) {
        getSupportFragmentManager().beginTransaction().add(R.id.belowFragment,new BelowFragment().newInstance(quantity,donGia)).commit();
        tvGia.setText(new DecimalFormat("#,###.#").format(quantity*donGia)+" đ");
    }

    @Override
    public void subProduct(int quantity, double donGia) {
        getSupportFragmentManager().beginTransaction().add(R.id.belowFragment,new BelowFragment().newInstance(quantity,donGia)).commit();
        tvGia.setText(new DecimalFormat("#,###.#").format(quantity*donGia)+" đ");
    }
}