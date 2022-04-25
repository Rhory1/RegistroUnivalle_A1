package com.example.registrounivalle_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre,etApellido,etEmail,etTelefono,etNota;
    private Button btnRegistrar;
    private Switch swEstudiante;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
    }

    private void inicializarVistas() {
        etNombre=findViewById(R.id.etNombre);
        etApellido=findViewById(R.id.etApellido);
        etTelefono=findViewById(R.id.etTelefono);
        etNota=findViewById(R.id.etNota);
        btnRegistrar=findViewById(R.id.btnRegistrar);
        swEstudiante=findViewById(R.id.swEstudiante);
    }
}