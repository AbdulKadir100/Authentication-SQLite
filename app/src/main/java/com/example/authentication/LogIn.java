package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.authentication.MainActivity;

public class LogIn extends AppCompatActivity {
    EditText editTextEmail,editTextPass;
    Button buttonLogin;
    DbHelper db;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editTextEmail = findViewById(R.id.email);
        editTextPass = findViewById(R.id.pass);
        buttonLogin = findViewById(R.id.log);

        db = new DbHelper(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sign();

            }
        });
    }

    public void sign() {

        email = editTextEmail.getText().toString();
        password = editTextPass.getText().toString();

        if (email.equals("") && password.equals("")) {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        } else {
            db.insertData(email, password);
            editTextEmail.setText("");
            editTextPass.setText("");
            Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }
    }
}