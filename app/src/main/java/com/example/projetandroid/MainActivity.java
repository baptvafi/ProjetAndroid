package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
            case R.id.ParentButton:
                Intent goLogin;
                if(accountAlreadyCreated()){
                    goLogin = new Intent(this, accesParent.class);
                }else{
                    goLogin = new Intent(this, createAccount.class);
                }
                startActivity(goLogin);
                break;
            case R.id.EnfantButton:
                Intent goControlBoard = new Intent(this,controlBoard.class);
                startActivity(goControlBoard);
                break;
        }
    }

    private boolean accountAlreadyCreated() {

        Context context = getApplicationContext();
        FileInputStream fis;

        // On essaye d'ouvir le fichier "password.txt"
        try {
             fis = context.openFileInput("password.txt");
        } catch (FileNotFoundException e) {
            return false;
        }

        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();

        String[] lines;

        // On essaye de lire le fichier
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        }finally {
            if(stringBuilder.toString().length() > 0){
                return true;
            }
        }
        return false;
    }
}