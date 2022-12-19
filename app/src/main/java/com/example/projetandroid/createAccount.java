package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createAccount extends AppCompatActivity implements View.OnClickListener{
    public Button CreateButton;
    public EditText password1;
    public EditText password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        CreateButton = findViewById(R.id.create);
        CreateButton.setOnClickListener(this);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);
    }

    @Override
    public void onClick(View view){
        // if both passwords same: record password, change activity to login
        if (password1.getText() == password2.getText()){
            // save password
            Intent goLogin = new Intent(this,accesParent.class);
            startActivity(goLogin);
        }
        else{
            // password1 and password2 clear
            //Toast.makeText(this,"incorrect", Toast.LENGTH_LONG).show();
        }
    }
}