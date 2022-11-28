package gg.cl.futbolya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.net.URI;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText correo, contra;
    private ImageButton btfacebook,btinstagram;
    Button btnRegistro,btnIngresar;
    String urlface="https://www.google.cl/";
    DataBase db = new DataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo=(EditText)findViewById(R.id.txtCorreo);
        contra=(EditText)findViewById(R.id.txtContra);
        btnRegistro = findViewById(R.id.btregistro);
        btnIngresar = findViewById(R.id.btingresar);
        btfacebook=findViewById(R.id.bt_facebook);

        btfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _urlface = Uri.parse(urlface);
                Intent i = new Intent(Intent.ACTION_VIEW,_urlface);
                startActivity(i);

                //Log.d("click","ok");
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent anterior = new Intent(getApplicationContext(),segundoActivity.class);
                startActivity(anterior);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validacion(correo.getText().toString(),contra.getText().toString());

            }
        });

    }

    public void validacion(String correo,String contra){

        if (correo.equals("admin") && contra.equals("1234")){
            Intent anterior = new Intent(getApplicationContext(),Opciones.class);
            startActivity(anterior);

            Toast.makeText(MainActivity.this,"Datos ingresados",Toast.LENGTH_SHORT).show();
        }

    }




}