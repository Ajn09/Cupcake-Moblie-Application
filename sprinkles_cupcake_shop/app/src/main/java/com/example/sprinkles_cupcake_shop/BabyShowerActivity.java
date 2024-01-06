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

public class BabyShowerActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    String description1, description2, description3, description4;
    TextView textBabyAppear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_shower);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        textBabyAppear = findViewById(R.id.txtBabyShower);
        buttonImage1 = findViewById(R.id.imagebBaby1);
        description1 = "Code: C005. " +
                "Name: Birdy Themed Baby Shower Cupcake. " +
                "Price: Rs.100. " +
                "The Cupcake is made by using Love Cake mixture. Decorated by Vanilla Icing and a Birdy by using Fondant Icing.";
        buttonImage1.setOnClickListener(v -> textBabyAppear.setText(description1));

        buttonImage2 = findViewById(R.id.imagebBaby2);
        description2 = "Code: C006. " +
                "Name: Raspberry Baby Shower Cupcake. " +
                "Price: Rs.120. " +
                "The Cupcake is made by using Raspberry and Almonds. It is decorated by light pink Icing and a flower by using Fondant Icing.";
        buttonImage2.setOnClickListener(v -> textBabyAppear.setText(description2));

        buttonImage3 = findViewById(R.id.imagebBaby3);
        description3 = "Code: C007. " +
                "Name: Baby Shower Cupcake for a Baby Girl. " +
                "Price: Rs.100. " +
                "The Cupcake is made by Chocolate. Decorated by Pink colour Icing. This cupcake is specially made for a Baby Shower for a Girl.";
        buttonImage3.setOnClickListener(v -> textBabyAppear.setText(description3));

        buttonImage4 = findViewById(R.id.imagebBaby4);
        description4 = "Code: C008. " +
                "Name: Baby Shower Cupcake for a Baby Boy. " +
                "Price: Rs.110. " +
                "The Cupcake is made by Vanilla Cake mixture. Decorated by Blue colour Icing and a baby made by using Fondant Icing.";
        buttonImage4.setOnClickListener(v -> textBabyAppear.setText(description4));

        buttonGo = findViewById(R.id.btnBabyShowerGo);
        buttonGo.setOnClickListener(v -> startActivity(new Intent(BabyShowerActivity.this, OrderActivity.class)));

        buttonBack = findViewById(R.id.btnBabyShowerBack);
        buttonBack.setOnClickListener(v -> startActivity(new Intent(BabyShowerActivity.this, CupcakesActivity.class)));
    }
}
