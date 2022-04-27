package com.example.registrounivalle_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre,etApellido,etEmail,etTelefono,etNota;
    private Button btnRegistrar;
    private Switch swEstudiante;

    private String nombre,apellido,mail;
    private int celular;
    private int nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();

        btnRegistrar.setOnClickListener((view)->{verificarLlenado();});
    }

    private void verificarLlenado() {

        nombre=etNombre.getText().toString().trim();
        apellido=etApellido.getText().toString().trim();
        mail=etEmail.getText().toString().trim();

        if(apellido.matches("")||apellido==null||nombre.matches("")||nombre==null){
            Toast.makeText(this,"Debe ingresar datos!!",Toast.LENGTH_LONG).show();
        }
        else{

                nombre=etNombre.getText().toString();
                apellido=etApellido.getText().toString();


            //mail=etEmail.getText().toString();
            //celular=Integer.parseInt(etTelefono.getText().toString());
            //nota=Integer.parseInt(etNota.getText().toString());
            mostrarValores();
        }

    }

    private void mostrarValores() {
        Toast.makeText(this,
                "El nombre es: "+nombre+
                "\n, el apellido es: "+apellido+
                "\n, el correo es: "+mail+
                "\n, el celular es: "+celular+
                "\n y la nota es: "+nota,Toast.LENGTH_SHORT).show();
    }

    private void recibirInformacion() {
        nombre=etNombre.getText().toString();
        apellido=etApellido.getText().toString();
        mail=etEmail.getText().toString();
        celular=Integer.parseInt(etTelefono.getText().toString());
        nota=Integer.parseInt(etNota.getText().toString());

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