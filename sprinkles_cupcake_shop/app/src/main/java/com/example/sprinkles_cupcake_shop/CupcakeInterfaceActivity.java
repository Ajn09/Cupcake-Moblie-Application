package com.example.sprinkles_cupcake_shop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.namespace.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CupcakeInterfaceActivity extends AppCompatActivity {
    Button buttonAdd, buttonView, buttonUpdate, buttonDelete, buttonBack;
    EditText textCode, textName, textDescription, textPrice;
    Spinner spinnerOccasion;
    SQLiteDatabase db;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcake_interface);
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
        buttonAdd = findViewById(R.id.btnCIAdd);
        buttonView = findViewById(R.id.btnCIView);
        buttonUpdate = findViewById(R.id.btnCIUpdate);
        buttonDelete = findViewById(R.id.btnCIDelete);
        buttonBack = findViewById(R.id.btnCIBack);
        textCode = findViewById(R.id.txtCICode);
        textName = findViewById(R.id.txtCIName);
        textDescription = findViewById(R.id.txtCIdescription);
        textPrice = findViewById(R.id.txtCIprice);
        spinnerOccasion = findViewById(R.id.spinnerpackage1);

        adapter = ArrayAdapter.createFromResource(this, R.array.package1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOccasion.setAdapter(adapter);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakeInterfaceActivity.this, AdminInterfaceActivity.class));
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertIntoDb();
            }
        });

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewData();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });
    }

    protected void createDatabase() {
        try {
            db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS CupcakeTable(code VARCHAR PRIMARY KEY NOT NULL, name VARCHAR, description VARCHAR, price VARCHAR, occasion VARCHAR);");
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error Creating Database" + ex, Toast.LENGTH_LONG).show();
        }
    }

    protected void insertIntoDb() {
        try {
            String code = textCode.getText().toString().trim();
            String name = textName.getText().toString().trim();
            String description = textDescription.getText().toString().trim();
            String price = textPrice.getText().toString().trim();
            String occasion = spinnerOccasion.getSelectedItem().toString().trim();

            boolean valid = true;

            if (code.isEmpty() || name.isEmpty() || description.isEmpty() || price.isEmpty() || occasion.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_LONG).show();
                valid = false;
            }
            if (valid) {
                String query1 = "INSERT INTO CupcakeTable values('" + code + "','" + name + "','" + description + "','" + price + "', '" + occasion + "');";
                db.execSQL(query1);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error" + ex, Toast.LENGTH_LONG).show();
        }
    }

    protected void viewData() {
        try {
            String code = textCode.getText().toString().trim();
            String query1 = "SELECT * FROM CupcakeTable WHERE code='" + code + "';";
            db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);
            Cursor result = db.rawQuery(query1, null);
            if (result.moveToFirst()) {
                do {
                    textName.setText(result.getString(1));
                    textDescription.setText(result.getString(2));
                    textPrice.setText(result.getString(3));
                    spinnerOccasion.setSelection(adapter.getPosition(result.getString(4)));
                } while (result.moveToNext());
            } else {
                Toast.makeText(getApplicationContext(), "Data not Found", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error" + ex, Toast.LENGTH_LONG).show();
        }
    }

    protected void updateData() {
        try {
            String code = textCode.getText().toString().trim();
            String name = textName.getText().toString().trim();
            String description = textDescription.getText().toString().trim();
            String price = textPrice.getText().toString().trim();
            String occasion = spinnerOccasion.getSelectedItem().toString().trim();

            String query1 = "UPDATE CupcakeTable SET name='" + name + "', description='" + description + "', price='" + price + "', occasion='" + occasion + "' WHERE code='" + code + "';";
            db.execSQL(query1);

            Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error" + ex, Toast.LENGTH_LONG).show();
        }
    }

    protected void deleteData() {
        try {
            String code = textCode.getText().toString().trim();
            String query1 = "DELETE FROM CupcakeTable WHERE code='" + code + "';";
            db.execSQL(query1);

            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error" + ex, Toast.LENGTH_LONG).show();
        }
    }
}
