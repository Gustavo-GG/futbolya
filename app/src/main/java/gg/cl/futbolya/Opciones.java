package gg.cl.futbolya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opciones extends AppCompatActivity {

    Button btn_listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        //boton siguiente mapa
        Button mapag=(Button) findViewById(R.id.bt_mapa);
        mapag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent1);

            }
        });
        //boton siguiente listar
        Button listarU=(Button) findViewById(R.id.btn_listar);
        listarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(),ListarRegistros.class);
                startActivity(intent3);

            }
        });


    }



}