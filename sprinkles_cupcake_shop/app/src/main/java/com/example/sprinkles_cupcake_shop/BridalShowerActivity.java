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

public class BridalShowerActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textBridalAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal_shower);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        textBridalAppear = findViewById(R.id.txtBrdalShower);
        buttonImage1 = findViewById(R.id.imagebBridal1);
        description1 = "Code: C013. " +
                "Name: Chocolate Bridal Cupcake. " +
                "Price: Rs.110. " +
                " This is made by using Chocolate cake mixture and decorated by Vanilla icing and maroon colour fondant icing flower.";
        buttonImage1.setOnClickListener(v -> textBridalAppear.setText(description1));

        buttonImage2 = findViewById(R.id.imagebBridal2);
        description2 = "Code: C014. " +
                "Name: Romantic Pink Bridal Cupcake. " +
                "Price: Rs.120. " +
                " This is made by vanilla flavoured mixture and decorated by Pink and Gold fondant icing.";
        buttonImage2.setOnClickListener(v -> textBridalAppear.setText(description2));

        buttonImage3 = findViewById(R.id.imagebBridal3);
        description3 = "Code: C015. " +
                "Name: Emballages Bridal Cupcake. " +
                "Price: Rs.130. " +
                " This is made by using Raspberries and decorated by using Pink colour icing.";
        buttonImage3.setOnClickListener(v -> textBridalAppear.setText(description3));

        buttonImage4 = findViewById(R.id.imagebBridal4);
        description4 = "Code: C016. " +
                "Name: 'I Do' Bridal Cupcake. " +
                "Price: Rs.100. " +
                " This is made by using Vanilla flavoured mixture and decorated by using icing and crispy sugar white pearls.";
        buttonImage4.setOnClickListener(v -> textBridalAppear.setText(description4));

        buttonGo = findViewById(R.id.btnBridalShowerGo);
        buttonGo.setOnClickListener(v -> startActivity(new Intent(BridalShowerActivity.this, OrderActivity.class)));

        buttonBack = findViewById(R.id.btnBridalShowerBack);
        buttonBack.setOnClickListener(v -> startActivity(new Intent(BridalShowerActivity.this, CupcakesActivity.class)));
    }
}
