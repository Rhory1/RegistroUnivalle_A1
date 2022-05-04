package com.example.registrounivalle_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        btnRegistrar.setOnClickListener((view)->{recibirInformacion();
            //verificarLlenado();
            pasarSegundaPantalla();});

        // el metodo para un switch
        // cambios igual a marcado o no marcado
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                habilitarCampoEstudiante(b);
                mostrarMensaje(b);
            }
        });
    }

    private void pasarSegundaPantalla() {
        // se va a utilizar el componente llamado INTENT
        // requiere de
        // parametro 1: de donde o de que pantalla va a venir
        // parametro 2: a que pantalla van a ir
        // el metodo que lanzara la pantalla se llama .startActivity()
        // es necesario para eso que INTENT haya resuelto el deseo del paso de pantalla
        Intent intencion=new Intent(this,homeActivity.class);
        // configurar paso de datos entre pantallas usando INTENT
        /*
        el intent tiene un archivo digamos temporal
        se puede entender que el archivo se llamase EXTRAS, ese
        ese archivo temporal contiene registros en formato Clave:valor (Key):(Value)
        cada registro solo puede contener un dato
        el dato solo puede ser DATO PRIMITIVO (int,String,float)
        cada registro se llama EXTRA
         */
        intencion.putExtra("Nombre_persona:",nombre);
        intencion.putExtra("Apellido_persona:",apellido);
        startActivity(intencion);
    }

    private void habilitarCampoEstudiante(boolean marcado) {
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

        if(apellido.equals("")||nombre.equals("")){
            Toast.makeText(this,"Debe ingresar datos!!",Toast.LENGTH_LONG).show();
        }
        else {
//            if(etEmail.getText().toString().trim()==null){
//                mail="";
//            }
//            else{
            // OJO NO SE HA INICIALIZADO etMail POR ESO FALLA!!
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
        nombre=etNombre.getText().toString().trim();
        apellido=etApellido.getText().toString().trim();
        mail=etEmail.getText().toString().trim();
        celular=etTelefono.getText().toString();
        if(etNota.getText().toString().equals("")){
            nota=0;
        }
        else{
            nota=Integer.parseInt(etNota.getText().toString());
        }

    }


    private void inicializarVistas() {
        etNombre=findViewById(R.id.etNombre);
        etApellido=findViewById(R.id.etApellido);
        // MUCHO CUIDADO, NO SE HABIA INICIALIZADO etMail
        etEmail=findViewById(R.id.etMail);
        etTelefono=findViewById(R.id.etTelefono);
        etNota=findViewById(R.id.etNota);
        btnRegistrar=findViewById(R.id.btnRegistrar);
        swEstudiante=findViewById(R.id.swEstudiante);
    }



}