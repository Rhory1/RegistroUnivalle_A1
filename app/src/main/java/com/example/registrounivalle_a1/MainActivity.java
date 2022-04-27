package com.example.registrounivalle_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre,etApellido,etEmail,etTelefono,etNota;
    private Button btnRegistrar;
    private Switch swEstudiante;

    private String nombre,apellido,mail;
    private String celular;
    private int nota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
        // la visibilidad del evento en pantalla
        // si se usa View.INVISIBLE aun esta el espacio que ocupa
        //etNota.setVisibility(View.INVISIBLE);
        // Si se usa View.GONE el objeto ya no se ve ni ocupa espacio
        etNota.setVisibility(View.GONE);
        btnRegistrar.setOnClickListener((view)->{verificarLlenado();});

        // el metodo para un switch
        // camios igual a marcado o no marcado
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                habilitatCampoEstudiante(b);
                mostrarMensaje(b);
            }
        });
    }

    private void habilitatCampoEstudiante(boolean marcado) {
        if(marcado){
            etNota.setVisibility(View.VISIBLE);
        }
        else{
            etNota.setVisibility(View.GONE);
        }
    }

    private void mostrarMensaje(Boolean marcado) {
        String mensaje="no estoy marcado";
        if(marcado){
            mensaje="Sí estoy marcado";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }

    private void verificarLlenado() {

        nombre=etNombre.getText().toString().trim();
        apellido=etApellido.getText().toString().trim();

        if(apellido.matches("")||apellido==null||nombre.matches("")||nombre==null){
            Toast.makeText(this,"Debe ingresar datos!!",Toast.LENGTH_LONG).show();
            return;
        }
        else {
//            if(etEmail.getText().toString().trim()==null){
//                mail="";
//            }
//            else{
//                mail=etEmail.getText().toString().trim();
//                celular=etTelefono.getText().toString().trim();
//                nota=Integer.parseInt(etNota.getText().toString().trim());
//            }
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
        celular=etTelefono.getText().toString();
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