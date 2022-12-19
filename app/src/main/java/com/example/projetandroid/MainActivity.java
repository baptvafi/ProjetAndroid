package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button ButtonParent;
    private Button ButtonEnfant;

    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonEnfant = (Button) findViewById(R.id.EnfantButton);
        ButtonParent = (Button) findViewById(R.id.ParentButton);

        ButtonParent.setOnClickListener(this);
        ButtonEnfant.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.parentButton:
                // if password exists: accesParent
                Intent goLogin = new Intent(this,accesParent.class);
                startActivity(goLogin);
                // else: createAccount
                break;
            case R.id.EnfantButton:
                Intent goControlBoard = new Intent(this,controlBoard.class);
                startActivity(goControlBoard);
                break;
        }
    }
}