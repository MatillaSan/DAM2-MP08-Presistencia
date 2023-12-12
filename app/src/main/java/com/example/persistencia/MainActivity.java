package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextNom = findViewById(R.id.editTextNom);
        EditText editTextCognom = findViewById(R.id.editTextCognom);
        EditText editTextTelefon = findViewById(R.id.editTextTelefon);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        Button buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("contactes.txt", Context.MODE_APPEND);
                    String data = "";
                    data += editTextNom.getText().toString() + ";";
                    data += editTextCognom.getText().toString() + ";";
                    data += editTextTelefon.getText().toString() + ";";
                    data += editTextEmail.getText().toString() + ";\n";
                    fileOutputStream.write(data.getBytes());
                    Toast.makeText(MainActivity.this, "S'ha guardat el contacte.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}