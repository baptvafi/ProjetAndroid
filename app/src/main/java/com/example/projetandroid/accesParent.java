package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class accesParent extends AppCompatActivity implements View.OnClickListener{
    private Button ConfirmButton;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acces_parent);
        ConfirmButton = findViewById(R.id.confirm_button);
        ConfirmButton.setOnClickListener(this);
        password = findViewById(R.id.password);
    }

    @Override
    public void onClick(View view){
        //if (password.getText() == getResources(password)){
        Intent goControlBoard = new Intent(this, controlBoard.class);
        startActivity(goControlBoard);
        //} else: //toast password is incorrect
    }
}