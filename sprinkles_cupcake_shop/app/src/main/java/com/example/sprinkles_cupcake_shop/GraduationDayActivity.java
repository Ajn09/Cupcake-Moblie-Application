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

public class GraduationDayActivity extends AppCompatActivity {
    ImageButton buttonImage1, buttonImage2, buttonImage3, buttonImage4;
    Button buttonGo, buttonBack;
    TextView textGraduationAppear;
    String description1, description2, description3, description4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduation_day);
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

        textGraduationAppear = findViewById(R.id.txtGraduationDay);

        buttonImage1 = findViewById(R.id.imagebGraduation1);
        description1 = "Code: C025. " +
                "Name: Greeny Graduation Cupcake. " +
                "Price: Rs.110. " +
                "This cupcake made by using Vanilla flavoured mixture. Green colour icing and Fondant icing Oak Hole Cap to decorate it.";
        buttonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textGraduationAppear.setText(description1);
            }
        });

        buttonImage2 = findViewById(R.id.imagebGraduation2);
        description2 = "Code: C026. " +
                "Name: Black and Gold themed Cupcake. " +
                "Price: Rs.120. " +
                "This cupcake made by using Chocolate flavoured mixture. Gold colour icing had used to decorate it.";
        buttonImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textGraduationAppear.setText(description2);
            }
        });

        buttonImage3 = findViewById(R.id.imagebGraduation3);
        description3 = "Code: C027. " +
                "Name: Cheese cake Graduation Cupcake. " +
                "Price: Rs.100. " +
                "This cupcake made by using cheese cake mixture and blackcurrant. Decorated by using Oak Hole Cap made by Fondant Icing.";
        buttonImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textGraduationAppear.setText(description3);
            }
        });

        buttonImage4 = findViewById(R.id.imagebGraduation4);
        description4 = "Code: C028. " +
                "Name: Red Velvet Graduation Cupcake. " +
                "Price: Rs.130. " +
                "This cupcake made by using Vanilla flavoured mixture and Red Velvet. Used White colour icing and Fondant Icing to decorate it.";
        buttonImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textGraduationAppear.setText(description4);
            }
        });

        buttonGo = findViewById(R.id.btnGraduationDayGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GraduationDayActivity.this, OrderActivity.class));
            }
        });

        buttonBack = findViewById(R.id.btnGraduationBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GraduationDayActivity.this, CupcakesActivity.class));
            }
        });
    }
}
