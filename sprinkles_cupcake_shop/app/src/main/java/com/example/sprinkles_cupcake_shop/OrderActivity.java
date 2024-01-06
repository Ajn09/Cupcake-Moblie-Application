package com.example.sprinkles_cupcake_shop;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {
    Button buttonBuy, buttonBack;
    Spinner spinnerOrderCategory, spinnerOrderCode;
    TextView textPrice, textQuantity, textAddress, textTelNo, textCartNo;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
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

        createDatabase();
        buttonBuy = findViewById(R.id.btnOrderBuy);
        buttonBack = findViewById(R.id.btnOrderBack);
        textQuantity = findViewById(R.id.txtOrderquantity);
        textPrice = findViewById(R.id.txtOrderPrice);
        textAddress = findViewById(R.id.txtOrderaaddress);
        textTelNo = findViewById(R.id.txtOrderphoneno);
        textCartNo = findViewById(R.id.txtOrdercartno);
        spinnerOrderCategory = findViewById(R.id.spinnerpackage2);
        spinnerOrderCode = findViewById(R.id.spinnerpackage3);

        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(this, R.array.package2, android.R.layout.simple_spinner_item);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrderCategory.setAdapter(categoryAdapter);

        ArrayAdapter<CharSequence> codeAdapter = ArrayAdapter.createFromResource(this, R.array.package3, android.R.layout.simple_spinner_item);
        codeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrderCode.setAdapter(codeAdapter);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderActivity.this, CupcakesActivity.class));
            }
        });

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertIntoDb();
                startActivity(new Intent(OrderActivity.this, CartActivity.class));
            }
        });
    }

    protected void createDatabase() {
        try {
            db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS OrderTable(cartno VARCHAR PRIMARY KEY  NOT NULL, category VARCHAR, code VARCHAR, unitprice VARCHAR, quantity VARCHAR, address VARCHAR, telephoneno VARCHAR);");
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error Creating Database" + ex, Toast.LENGTH_LONG).show();
        }
    }

    protected void insertIntoDb() {
        try {
            String code = spinnerOrderCode.getSelectedItem().toString().trim();
            String cartno = textCartNo.getText().toString().trim();
            String category = spinnerOrderCategory.getSelectedItem().toString().trim();
            String unitprice = textPrice.getText().toString().trim();
            String quantity = textQuantity.getText().toString().trim();
            String address = textAddress.getText().toString().trim();
            String telephoneno = textTelNo.getText().toString().trim();

            boolean valid = true;

            if (cartno.isEmpty() || category.isEmpty() || code.isEmpty() || unitprice.isEmpty() || quantity.isEmpty() || address.isEmpty() || telephoneno.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_LONG).show();
                valid = false;
            }
            if (valid) {
                String query2 = "INSERT INTO OrderTable VALUES('" + cartno + "', '" + category + "','" + code + "','" + unitprice + "','" + quantity + "','" + address + "', '" + telephoneno + "');";
                db.execSQL(query2);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error" + ex, Toast.LENGTH_LONG).show();
        }
    }
}
