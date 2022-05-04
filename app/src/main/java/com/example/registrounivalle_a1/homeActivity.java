package com.example.registrounivalle_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class homeActivity extends AppCompatActivity {
    // atributos que representen a sus view
    private TextView textView;


    // variables generales de la clase
    String nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        obtenerDatosPrimeraPantalla();
        mostrarDatos();
    }

    private void mostrarDatos() {
        textView.setText(nombre+", "+apellido);
    }

    private void obtenerDatosPrimeraPantalla() {
        nombre=this.getIntent().getExtras().getString("Nombre_persona","");
        apellido=this.getIntent().getExtras().getString("Apellido_persona","");
    }

    private void inicializarVistas() {
        textView=findViewById(R.id.textView);
    }
}