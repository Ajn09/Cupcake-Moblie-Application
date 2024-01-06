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

public class BirthdayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonBack, buttonGo;
    TextView textBirthdayAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        textBirthdayAppear = findViewById(R.id.txtBirthday);
        buttonImage1 = findViewById(R.id.imagebBirthday1);
        description1 = "Code: C009. " +
                "Name: Little Elephant themed Cupcake. " +
                "Price: Rs.120. " +
                " This is made by using Vanilla mixture and decorated by fondant icing elephant.";
        buttonImage1.setOnClickListener(v -> textBirthdayAppear.setText(description1));

        buttonImage2 = findViewById(R.id.imagebBirthday2);
        description2 = "Code: C010. " +
                "Name: Choco Birthday Cupcake. " +
                "Price: Rs.100. " +
                " This is made by chocolate mixture and decorated by Vanilla Icing and marbles.";
        buttonImage2.setOnClickListener(v -> textBirthdayAppear.setText(description2));

        buttonImage3 = findViewById(R.id.imagebBirthday3);
        description3 = "Code: C011. " +
                "Name: Girly Birthday Cupcake. " +
                "Price: Rs.110. " +
                " This is made by vanilla cake mixture and decorated by Fondant Icing dress.";
        buttonImage3.setOnClickListener(v -> textBirthdayAppear.setText(description3));

        buttonImage4 = findViewById(R.id.imagebBirthday4);
        description4 = "Code: C012. " +
                "Name: Superman Birthday Cupcake. " +
                "Price: Rs.120. " +
                " This is made specially for boys by using Vanilla flavored mixture and blue color icing.";
        buttonImage4.setOnClickListener(v -> textBirthdayAppear.setText(description4));

        buttonGo = findViewById(R.id.btnBirthdayGo);
        buttonGo.setOnClickListener(v -> startActivity(new Intent(BirthdayActivity.this, OrderActivity.class)));

        buttonBack = findViewById(R.id.btnBirthdayBack);
        buttonBack.setOnClickListener(v -> startActivity(new Intent(BirthdayActivity.this, CupcakesActivity.class)));
    }
}
