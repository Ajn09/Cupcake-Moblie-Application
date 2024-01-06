package com.example.sprinkles_cupcake_shop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CartActivity extends AppCompatActivity {
    private TextView txtYoCategory, txtYoCode, txtYoQuantity, txtYoUPrice, txtYoCartNo;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        Button btnCancel = findViewById(R.id.btnYourOrderCancel);
        Button btnCartOk = findViewById(R.id.btnYourOrderOk);
        Button btnView = findViewById(R.id.btnYourOrderShow);
        txtYoCartNo = findViewById(R.id.txtYourOrdercartno);
        txtYoCategory = findViewById(R.id.txtYourOrederCategory);
        txtYoCode = findViewById(R.id.txtYourOrderCode);
        txtYoQuantity = findViewById(R.id.txtYourOrderQuantity);
        txtYoUPrice = findViewById(R.id.txtYourOrderUnitPrice);

        btnCancel.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "You have canceled the order.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(CartActivity.this, MainActivity.class));
        });

        btnCartOk.setOnClickListener(v -> startActivity(new Intent(CartActivity.this, OrderReceiptActivity.class)));

        btnView.setOnClickListener(v -> ViewData());
    }

    private void ViewData() {
        try {
            String cartNo = txtYoCartNo.getText().toString().trim();
            String query = "SELECT * FROM OrderTable WHERE cartno=?";
            db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);

            try (Cursor result = db.rawQuery(query, new String[]{cartNo})) {
                if (result.moveToFirst()) {
                    int categoryIndex = result.getColumnIndex("category");
                    int codeIndex = result.getColumnIndex("code");
                    int priceIndex = result.getColumnIndex("unit_price");
                    int quantityIndex = result.getColumnIndex("quantity");

                    txtYoCategory.setText(result.getString(categoryIndex));
                    txtYoCode.setText(result.getString(codeIndex));
                    txtYoUPrice.setText(result.getString(priceIndex));
                    txtYoQuantity.setText(result.getString(quantityIndex));
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error: " + ex, Toast.LENGTH_LONG).show();
        }
    }
}
