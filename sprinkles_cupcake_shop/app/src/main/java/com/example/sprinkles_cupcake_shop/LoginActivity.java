package com.example.sprinkles_cupcake_shop;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    Button ButtonLogin;
    EditText TextUsername, TextPassword;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        ButtonLogin = findViewById(R.id.btnLogin);
        TextUsername = findViewById(R.id.txtLUsername);
        TextPassword = findViewById(R.id.txtLPassword);

        ButtonLogin.setOnClickListener(v -> {
            try {
                String username = TextUsername.getText().toString().trim();
                String password = TextPassword.getText().toString().trim();

                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter the Username", Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter the Password", Toast.LENGTH_LONG).show();
                    return;
                }

                if (username.equals("Admin") && password.equals("12345")) {
                    startActivity(new Intent(LoginActivity.this, AdminInterfaceActivity.class));
                } else {
                    db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);

                    String query = "SELECT * FROM RegisterTable WHERE username = '" + username + "' AND password = '" + password + "'";
                    Cursor result = db.rawQuery(query, null);

                    if (result.moveToFirst()) {
                        do {
                            String usertype = result.getString(4);
                            if ("Member".equals(usertype)) {
                                Intent startNewActivity = new Intent(LoginActivity.this, CupcakesActivity.class);
                                startActivity(startNewActivity);
                            }
                        } while (result.moveToNext());
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Access", Toast.LENGTH_LONG).show();
                    }

                    // Close the cursor and the database
                    result.close();
                    db.close();
                }
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(), "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
