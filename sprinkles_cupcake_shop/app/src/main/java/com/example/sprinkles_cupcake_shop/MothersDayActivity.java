package com.example.sprinkles_cupcake_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MothersDayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textMothersDayAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mothers_day);
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

        textMothersDayAppear = findViewById(R.id.txtMothersday);
        buttonImage1 = findViewById(R.id.imagebmother1);
        description1 = "Code: C029. " +
                "Name: Strawberry Mother's Day Cupcake. " +
                "Price: Rs.110. " +
                " This cupcake made by using Vanilla flavoured mixture. Used White colour icing and Strawberry to decorate it.";
        buttonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMothersDayAppear.setText(description1);
            }
        });

        buttonImage2 = findViewById(R.id.imagebmother2);
        description2 = "Code: C030. " +
                "Name: Rainbow themed Cupcake. " +
                "Price: Rs.100. " +
                " This cupcake made by using Vanilla flavoured mixture. Used Rainbow colours icing to decorate it.";
        buttonImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMothersDayAppear.setText(description2);
            }
        });

        buttonImage3 = findViewById(R.id.imagebmother3);
        description3 = "Code: C031. " +
                "Name: Fruity Mother's Day Cupcake. " +
                "Price: Rs.120. " +
                " This cupcake made by using Chocolate flavoured mixture. Used White colour icing and Fruits to decorate it.";
        buttonImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMothersDayAppear.setText(description3);
            }
        });

        buttonImage4 = findViewById(R.id.imagebmother4);
        description4 = "Code: C032. " +
                "Name: Flower themed Cupcake. " +
                "Price: Rs.100. " +
                " This cupcake made by using Vanilla flavoured mixture. Used Piping royal icing to decorate it.";
        buttonImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textMothersDayAppear.setText(description4);
            }
        });

        buttonGo = findViewById(R.id.btnMothersdayGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MothersDayActivity.this, OrderActivity.class));
            }
        });

        buttonBack = findViewById(R.id.btnMothersdayBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MothersDayActivity.this, CupcakesActivity.class));
            }
        });
    }
}
