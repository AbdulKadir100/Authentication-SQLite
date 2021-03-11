package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextEmail, editTextPass;
    Button buttonSign;
    TextView textView;

    DbHelper db;
    String name;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.user);
        editTextEmail = findViewById(R.id.email);
        editTextPass = findViewById(R.id.pass);
        buttonSign = findViewById(R.id.sign);
        textView = findViewById(R.id.editTextTextPersonName);

        db = new DbHelper(this);

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             sign();
            // startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LogIn.class));
                finish();
            }
        });

    }

    public void sign() {
        name = editTextName.getText().toString();
        email = editTextEmail.getText().toString();
        password = editTextPass.getText().toString();

        if (name.equals("") && email.equals("") && password.equals("")) {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        } else {
            db.insertData(name, email, password);
            editTextName.setText("");
            editTextEmail.setText("");
            editTextPass.setText("");
            Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
           startActivity(new Intent(MainActivity.this,Home.class));

        }
    }
}