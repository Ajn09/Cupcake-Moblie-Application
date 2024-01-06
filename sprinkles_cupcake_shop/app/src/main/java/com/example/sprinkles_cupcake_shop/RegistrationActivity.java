package com.example.sprinkles_cupcake_shop;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.namespace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RegistrationActivity extends AppCompatActivity {

    private Button buttonRegister, buttonLogin;
    private EditText textName, textUsername, textPassword, textConfirmPassword;
    private SQLiteDatabase db;
    private Spinner spinnerUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        createDatabase();

        buttonRegister = findViewById(R.id.btnRegister);
        buttonLogin = findViewById(R.id.btnRegisterLogin);
        textName = findViewById(R.id.txtRName);
        textUsername = findViewById(R.id.txtRUsername);
        textPassword = findViewById(R.id.txtRPassword);
        textConfirmPassword = findViewById(R.id.txtRConPassword);
        spinnerUserType = findViewById(R.id.spinnerpackage4);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.package4, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUserType.setAdapter(adapter);

        buttonRegister.setOnClickListener(v -> insertIntoDb());
        buttonLogin.setOnClickListener(v -> startActivity(new Intent(RegistrationActivity.this, LoginActivity.class)));
    }

    private void createDatabase() {
        try {
            db = openOrCreateDatabase("HNDMAD8210", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS RegisterTable(username VARCHAR PRIMARY KEY NOT NULL, name VARCHAR, password VARCHAR, cpassword VARCHAR, usertype VARCHAR);");
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error in creating the Database", Toast.LENGTH_LONG).show();
        }
    }

    private void insertIntoDb() {
        try {
            String username = textUsername.getText().toString().trim();
            String name = textName.getText().toString().trim();
            String password = textPassword.getText().toString().trim();
            String cpassword = textConfirmPassword.getText().toString().trim();
            String usertype = spinnerUserType.getSelectedItem().toString().trim();

            if (validateInputs(username, name, password, cpassword, usertype)) {
                String query = "INSERT INTO RegisterTable VALUES('" + username + "','" + name + "','" + password + "','" + cpassword + "', '" + usertype + "');";
                db.execSQL(query);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateInputs(String username, String name, String password, String cpassword, String usertype) {
        if (username.isEmpty() || name.isEmpty() || password.isEmpty() || cpassword.isEmpty() || usertype.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter all details.", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!password.equals(cpassword)) {
            Toast.makeText(getApplicationContext(), "Password and Confirm Password do not match.", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}
