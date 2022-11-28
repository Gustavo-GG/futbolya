package gg.cl.futbolya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class segundoActivity extends AppCompatActivity {

    Button btnRegistro;
    EditText nombre, telefono, correo, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        DataBase db = new DataBase(this);

        nombre = findViewById(R.id.txt_nombres);
        telefono = findViewById(R.id.txt_numero);
        correo = findViewById(R.id.txt_correo);
        password = findViewById(R.id.txt_contraseña);

        btnRegistro = findViewById(R.id.bt_regist);
        //db.agregarContactos(new Contactos("mm","1234","mmmm"));

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.agregarContactos(
                        new Contactos(
                                nombre.getText().toString(),
                                telefono.getText().toString(),
                                correo.getText().toString(),
                                password.getText().toString()
                        )
                );
                //mensaje de boton
                Toast.makeText(segundoActivity.this,"Datos Guardados Correctamente",Toast.LENGTH_SHORT).show();
            }
        });

    }

}