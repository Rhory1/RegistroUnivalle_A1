package com.example.registrounivalle_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class homeActivity extends AppCompatActivity {
    // atributos que representen a sus view
    private TextView txtResultado;


    // variables generales de la clase
    private String nombre, apellido;
    private Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        obtenerDatosPrimeraPantalla();
        //mostrarDatos();
        mostrarDatosDesdeObjeto();
    }

    private void mostrarDatosDesdeObjeto() {
        // getSerializabla devuelve objeto generico, no particular
        // en este caso un casteo ayuda a solamente extraer de ese objeto general lo que
        // a ti te importa
        estudiante=(Estudiante) this.getIntent().getExtras().getSerializable("estudiante_objeto");
        txtResultado.setText(estudiante.getNombre());
    }

    private void mostrarDatos() {
        txtResultado.setText(nombre+", "+apellido);
    }

    private void obtenerDatosPrimeraPantalla() {
        nombre=this.getIntent().getExtras().getString("Nombre_persona","");
        apellido=this.getIntent().getExtras().getString("Apellido_persona","");
    }

    private void inicializarVistas() {
        txtResultado=findViewById(R.id.txtResultado);
    }
}