package com.example.sprinkles_cupcake_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.namespace.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FarewellDayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textFarewellAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farewell_day);
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

        textFarewellAppear = findViewById(R.id.txtFarewellDay);

        buttonImage1 = findViewById(R.id.imagebFarewell1);
        description1 = "Code: C021. " +
                "Name: Choco Farewell Cupcake. " +
                "Price: Rs.100. " +
                "This is made by Chocolate mixture and decorated by Vanilla icing and Rose Flower by Fondant icing.";
        buttonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textFarewellAppear.setText(description1);
            }
        });

        buttonImage2 = findViewById(R.id.imagebFarewell2);
        description2 = "Code: C022. " +
                "Name: Butterfly themed Farewell Cupcake. " +
                "Price: Rs.120. " +
                "This is made by using Chocolate flavoured mixture and decorated by piping royal icing.";
        buttonImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textFarewellAppear.setText(description2);
            }
        });

        buttonImage3 = findViewById(R.id.imagebFarewell3);
        description3 = "Code: C023. " +
                "Name: 'Bye Bye' Farewell Cupcake. " +
                "Price: Rs.120. " +
                "This is made by using Vanilla flavoured mixture and decorated by using Vanilla and Gold colour icing.";
        buttonImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textFarewellAppear.setText(description3);
            }
        });

        buttonImage4 = findViewById(R.id.imagebFarewell4);
        description4 = "Code: C024. " +
                "Name: Blackcurrant Farewell Cupcake. " +
                "Price: Rs.130. " +
                "This cupcake made by Vanilla flavoured mixture and Blackcurrant. White colour icing and Chocolate to decorate it.";
        buttonImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textFarewellAppear.setText(description4);
            }
        });

        buttonGo = findViewById(R.id.btnFarewellDayGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FarewellDayActivity.this, OrderActivity.class));
            }
        });

        buttonBack = findViewById(R.id.btnFarewellBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FarewellDayActivity.this, CupcakesActivity.class));
            }
        });
    }
}
