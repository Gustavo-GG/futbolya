package gg.cl.futbolya;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION= 3;
    private static String DATABASE_NAME = "Contactos";
    private static String TABLA = "contactos";
    private static String KEY = "id";
    private static String NOMBRE = "nombre";
    private static String TELEFONO = "telefono";
    private static String CORREO = "email";
    private static String PASSWORD = "password";

    public DataBase(Context context){
        super(context, DATABASE_NAME,
                null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CONTACTO = "CREATE TABLE " + TABLA + " ("
                + KEY + " INTEGER PRIMARY KEY,"+NOMBRE + " TEXT,"
                + TELEFONO + " TEXT,"
                + CORREO + " TEXT,"
                +PASSWORD + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE_CONTACTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA);
        onCreate(db);
    }

    void agregarContactos(Contactos contactos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, contactos.getNombre());
        valores.put(TELEFONO, contactos.getTelefono());
        valores.put(CORREO, contactos.getCorreo());
        valores.put(PASSWORD, contactos.getPassword());

        db.insert(TABLA,null,valores);
        db.close();
    }

    public List<Contactos> getAllContactos(){
        List<Contactos> listaContactos = new
                ArrayList<Contactos>();
        String query = "SELECT * FROM " + TABLA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Contactos contactos = new Contactos();
                contactos.setId(Integer.parseInt(cursor.getString(0)));
                contactos.setNombre(cursor.getString(1));
                contactos.setTelefono(cursor.getString(2));
                contactos.setCorreo(cursor.getString(3));
                contactos.setPassword(cursor.getString(4));
                listaContactos.add(contactos);

            }while (cursor.moveToNext());
        }
        return listaContactos;
    }

    void actualizarContactos(Contactos contactos){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(NOMBRE, contactos.getNombre());
        valores.put(TELEFONO, contactos.getTelefono());
        valores.put(CORREO, contactos.getCorreo());
        valores.put(PASSWORD, contactos.getPassword());

        db.update(TABLA,valores,KEY + " = ?",
                new String[]{String.valueOf(contactos.getId())});
        db.close();
    }
    void eliminarContactos(Contactos contactos){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLA,KEY + " = ? ",
                new String[]{String.valueOf(contactos.getId())});
        db.close();
    }
}

