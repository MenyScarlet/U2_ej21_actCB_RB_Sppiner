package com.example.didact.u2_ej21_actcb_rb_sppiner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaramos las vistas y controles
    Spinner sp_tipo;
    RadioGroup rg_respuestas;
    CheckBox cb_pregunta;
    Button btn_respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Identificamos las vistas
        sp_tipo = (Spinner) findViewById(R.id.sp_tipo);
        rg_respuestas = (RadioGroup) findViewById(R.id.rg_respuestas);
        cb_pregunta = (CheckBox) findViewById(R.id.cb_pregunta);
        btn_respuesta = (Button) findViewById(R.id.btn_resultado);

        //Rellenar el spinner
        String[] tipos = {"Selecciona", "Seguridad", "Velocidad", "Mecánica", "Vial"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, tipos);
        sp_tipo.setAdapter(adaptador);


    }//FIN onCreate

    public void boton1 (View view){
        //Recoger el item seleccionado de una spiner
        String tipoSeleccionado = sp_tipo.getSelectedItem().toString();

        /*Validacion: Si el tipo seleccionado es igual a "Seleciona" avisaremos al
                      usuario de que tiene que selecionar algun tipo, sinolo
                      mostraremos en un toast.*/
        if (tipoSeleccionado.equals("Selecciona")){
            Toast.makeText(this,"Debes selecionar un tipo de test",
                    Toast.LENGTH_LONG).show();
        }else{
            /*Toast.makeText(this, "Text seleccionado: "+tipoSeleccionado,
                    Toast.LENGTH_LONG).show();*/
            btn_respuesta.setEnabled(true);
        }


    }

    public void boton2 (View view){
        //Obtenemos la id, del Radiobutton seleccionado dentro del radiogroup
        int idRadio = rg_respuestas.getCheckedRadioButtonId();

        if (idRadio == -1){
            Toast.makeText(this,"Debes selecionar una respuesta",
                    Toast.LENGTH_LONG).show();

        }else{
            //Creamos un objeto RadioButton desde la id obtenida
            RadioButton radioButtonSeleccionado = (RadioButton)findViewById(idRadio);

            //Del objeto radiobutton creado obtenemos el texto del mismo.
            String textoRadioSeleccionado = radioButtonSeleccionado.getText().toString();

            Toast.makeText(this,"Opción seleccionada"+textoRadioSeleccionado,
                    Toast.LENGTH_LONG).show();

            //Comprobar si el checkbox esta seleccionado
            boolean esRepetida=false;

            if (cb_pregunta.isChecked()){
                esRepetida=true;
            }
            if (esRepetida){
                Toast.makeText(this,"Esta pregunta ya la has contestado",
                        Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Opción seleccionada"+textoRadioSeleccionado,
                        Toast.LENGTH_LONG).show();
            }

        }

    }

}
