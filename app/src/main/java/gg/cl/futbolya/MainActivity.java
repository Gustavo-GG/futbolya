package gg.cl.futbolya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //metodo el boton siguiente
    public void registro(View view){
        Intent registro = new Intent(this, segundoActivity.class);
        startActivity(registro);
    }
}