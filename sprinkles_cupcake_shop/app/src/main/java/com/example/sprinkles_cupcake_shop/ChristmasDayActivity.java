package com.example.sprinkles_cupcake_shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ChristmasDayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textChristmasAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas_day);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        textChristmasAppear = findViewById(R.id.txtChristmasDay);
        buttonImage1 = findViewById(R.id.imagebChristmas1);
        description1 = "Code: C017. " +
                "Name: Rain Deer Christmas Cupcake. " +
                "Price: Rs.120. " +
                " This is made by using chocolate mixture and also used chocolate icing to decorate.";
        buttonImage1.setOnClickListener(v -> textChristmasAppear.setText(description1));

        buttonImage2 = findViewById(R.id.imagebChristmas2);
        description2 = "Code: C018. " +
                "Name: Christmas Tree Cupcake. " +
                "Price: Rs.100. " +
                " This is made by using Almonds and some fruits like Cherry and Raspberry. Here used some M&M to decorate it.";
        buttonImage2.setOnClickListener(v -> textChristmasAppear.setText(description2));

        buttonImage3 = findViewById(R.id.imagebChristmas3);
        description3 = "Code: C019. " +
                "Name: Snowman Christmas Cupcake. " +
                "Price: Rs.110. " +
                " This is made by using Love Cake mixture. Here used some Fondant Icing to decorate it.";
        buttonImage3.setOnClickListener(v -> textChristmasAppear.setText(description3));

        buttonImage4 = findViewById(R.id.imagebChristmas4);
        description4 = "Code: C020. " +
                "Name: Santa Clause Cupcake. " +
                "Price: Rs.120. " +
                " This is made by using Chocolate and Almonds. Here used some Sugar Spread to decorate the cupcake.";
        buttonImage4.setOnClickListener(v -> textChristmasAppear.setText(description4));

        buttonGo = findViewById(R.id.btnChristmasDayGo);
        buttonGo.setOnClickListener(v -> startActivity(new Intent(ChristmasDayActivity.this, OrderActivity.class)));

        buttonBack = findViewById(R.id.btnChristmasBack);
        buttonBack.setOnClickListener(v -> startActivity(new Intent(ChristmasDayActivity.this, CupcakesActivity.class)));
    }
}
