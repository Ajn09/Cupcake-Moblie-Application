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

public class AnniversaryDayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textAnniversaryAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anniversary_day);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        textAnniversaryAppear = findViewById(R.id.txtAnniversaryDay);
        buttonImage1 = findViewById(R.id.imagebAnniversary1);
        description1 = "Code:001" +
                "Name: Fruity Anniversary Cupcake. " +
                "Price: Rs.120. " +
                "This is made by using Almonds and some fruits like Dates and Raspberry. There is a slice of chocolate on the top.";
        buttonImage1.setOnClickListener(v -> textAnniversaryAppear.setText(description1));

        buttonImage2 = findViewById(R.id.imagebAnniversary2);
        description2 = "Code: C002. " +
                "Name: Choco Anniversary Cupcake. " +
                "Price: Rs.100. " +
                "This is made by Chocolate. Decorated by Chocolate Icing and Fondant Icing.";
        buttonImage2.setOnClickListener(v -> textAnniversaryAppear.setText(description2));

        buttonImage3 = findViewById(R.id.imagebAnniversary3);
        description3 = "Code: C003. " +
                "Name: Mustachos Anniversary Cupcake. " +
                "Price: Rs.120. " +
                "This is made by Chocolate. Decorated by Chocolate Icing and Fondant Icing.";
        buttonImage3.setOnClickListener(v -> textAnniversaryAppear.setText(description3));

        buttonImage4 = findViewById(R.id.imagebAnniversary4);
        description4 = "Code: C004. " +
                "Name: Gold Topped Anniversary Cupcake. " +
                "Price: Rs.130. " +
                "This is made by Butterscotch. Decorated by Gold colour fondant flower and Vanilla Icing.";
        buttonImage4.setOnClickListener(v -> textAnniversaryAppear.setText(description4));

        buttonGo = findViewById(R.id.btnAnniversaryDayGo);
        buttonGo.setOnClickListener(v -> startActivity(new Intent(AnniversaryDayActivity.this, OrderActivity.class)));

        buttonBack = findViewById(R.id.btnAnniversaryBack);
        buttonBack.setOnClickListener(v -> startActivity(new Intent(AnniversaryDayActivity.this, CupcakesActivity.class)));
    }
}
