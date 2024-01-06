package com.example.sprinkles_cupcake_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AdminInterfaceActivity extends AppCompatActivity {

    Button buttonCupcakeInterface, buttonOrderInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_interface);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buttonCupcakeInterface = findViewById(R.id.btnAICupcakeInterface);

        buttonCupcakeInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminInterfaceActivity.this, CupcakeInterfaceActivity.class));
            }
        });

        buttonOrderInterface = findViewById(R.id.btnAIOrderInterface);
        buttonOrderInterface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminInterfaceActivity.this, OrderInterfaceActivity.class));
            }
        });
    }
}
