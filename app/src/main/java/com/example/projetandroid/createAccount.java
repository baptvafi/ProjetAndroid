package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

import pops.peip2.myapplication.R;



public class createAccount extends AppCompatActivity implements View.OnClickListener{
    public Button CreateButton;
    public EditText password1;
    public EditText password2;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        context = getApplicationContext();

        CreateButton = (Button) findViewById(R.id.create);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);

        CreateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        // if both passwords same: record password, change activity to login

        if(password1.getText().toString().equals("")){
            Toast toast = Toast.makeText(getApplicationContext(),"Le mot de passe ne peut pas" +
                    " être vide", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if (password1.getText().toString().equals(password2.getText().toString())){
            String filename = "password.txt";
            File file = new File(context.getFilesDir(), filename);

            // S'il n'existe pas on créer le fichier
            if(!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Une erreur s'est produite", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
            }

            String fileContents = password1.getText().toString();
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                        context.openFileOutput("password.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(fileContents);
                outputStreamWriter.close();
            }
            catch (IOException e) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Une erreur s'est produite", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            Intent goLogin = new Intent(this,accesParent.class);
            startActivity(goLogin);
        }else{
            Toast toast = Toast.makeText(context,"Les mots de passe ne sont " +
                    "pas identique", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
    }
}