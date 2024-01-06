package com.example.sprinkles_cupcake_shop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.namespace.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class OrderInterfaceActivity extends AppCompatActivity {
    Button buttonOIOk, buttonOIView;
    TextView textOICode, textOIUPrice, textOIQuantity, textOIAddress;
    EditText textOICartNo;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_interface);
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

        buttonOIOk = findViewById(R.id.btnOIOK);

        buttonOIOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderInterfaceActivity.this, OrderReceiptActivity.class));
            }
        });

        textOICartNo = findViewById(R.id.txtOIcartno);
        textOICode = findViewById(R.id.txtOICupcakeCode);
        textOIUPrice = findViewById(R.id.txtOIUnitPrice);
        textOIQuantity = findViewById(R.id.txtOIQuantity);
        textOIAddress = findViewById(R.id.txtOIAddress);

        buttonOIView = findViewById(R.id.btnOIView);
        buttonOIView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String cartno = textOICartNo.getText().toString().trim();
                    db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);
                    String query2 = "SELECT * FROM OrderTable WHERE cartno = ?;";
                    Cursor result = db.rawQuery(query2, new String[]{cartno});

                    if (result.moveToFirst()) {
                        do {
                            textOICode.setText(result.getString(2));
                            textOIUPrice.setText(result.getString(3));
                            textOIQuantity.setText(result.getString(4));
                            textOIAddress.setText(result.getString(5));
                        } while (result.moveToNext());
                    } else {
                        Toast.makeText(getApplicationContext(), "No data found for cart number: " + cartno, Toast.LENGTH_LONG).show();
                    }

                    result.close();
                    db.close();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), "Error: " + ex, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
