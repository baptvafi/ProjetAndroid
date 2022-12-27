package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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


        Context context = getApplicationContext();
        FileInputStream fis;

        // On essaye d'ouvir le fichier "password.txt"
        try {
            fis = context.openFileInput("password.txt");
        } catch (FileNotFoundException e) {
            Toast toast = Toast.makeText(context,"Une erreur c'est produite", Toast.LENGTH_SHORT);
            toast.show();
            return;
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
            Toast toast = Toast.makeText(context,"Une erreur c'est produite", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }finally {
            if(stringBuilder.toString().length() < 0){
                Toast toast = Toast.makeText(context,"Une erreur c'est produite", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            String pass = stringBuilder.toString();

            if(pass.equals(password.getText().toString() + "\n")){
                Intent goControlBoard = new Intent(this, controlBoard.class);
                startActivity(goControlBoard);
            }else{
                Toast toast = Toast.makeText(context,"Le mot de passe est incorrect", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

        }
    }
}