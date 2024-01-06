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

public class ValentinesDayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textValentineAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valentines_day);
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

        textValentineAppear = findViewById(R.id.txtValentinesday);
        buttonImage1 = findViewById(R.id.imagebValentine1);
        description1 = "Code: C033. " +
                "Name: 'In Love' Valentine Cupcake. " +
                "Price: Rs.130. " +
                " This cupcake made by using Chocolate flavoured mixture. Used Pink colour icing and Pixley Berry to decorate it.";
        buttonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textValentineAppear.setText(description1);
            }
        });

        buttonImage2 = findViewById(R.id.imagebValentine2);
        description2 = "Code: C034. " +
                "Name: Choco Valentine Cupcake. " +
                "Price: Rs.110. " +
                " This cupcake made by using Dark Chocolate flavoured mixture. Used Chocolate icing and Hearts made by fondant icing to decorate it.";
        buttonImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textValentineAppear.setText(description2);
            }
        });

        buttonImage3 = findViewById(R.id.imagebValentine3);
        description3 = "Code: C035. " +
                "Name: Rice Crispy Valentine Cupcake. " +
                "Price: Rs.100. " +
                " This cupcake made by using Rice Crispy. Used White colour icing and heart shaped Jujubes to decorate it.";
        buttonImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textValentineAppear.setText(description3);
            }
        });

        buttonImage4 = findViewById(R.id.imagebValentine4);
        description4 = "Code: C036. " +
                "Name: Red Velvet Valentine Cupcake. " +
                "Price: Rs.130. " +
                " This cupcake made by using Red Velvet. White colour icing and Fondant Icing to decorate it.";
        buttonImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textValentineAppear.setText(description4);
            }
        });

        buttonGo = findViewById(R.id.btnValentinesdayGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ValentinesDayActivity.this, OrderActivity.class));
            }
        });

        buttonBack = findViewById(R.id.btnValentineBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ValentinesDayActivity.this, CupcakesActivity.class));
            }
        });
    }
}
