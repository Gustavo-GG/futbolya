package gg.cl.futbolya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class ListarRegistros extends AppCompatActivity {

    EditText listar;
    Button btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registros);

        DataBase db = new DataBase(this);

        listar = findViewById(R.id.txtMostrar);
        btnListar = findViewById(R.id.btnListar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Contactos> contacts = db.getAllContactos();
                StringBuilder builder = new StringBuilder();
                for (Contactos cn: contacts){
                    builder.append("Id: " + cn.getId() + "" +
                            " Nombre: " + cn.getNombre() +
                            " Telefono: " + cn.getTelefono()+
                            " Correo: " + cn.getCorreo()+
                            "Pass: " + cn.getPassword()+"\n");
                    listar.setText(builder);
                }
            }
        });
    }
}