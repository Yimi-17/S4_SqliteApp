package edu.upeu.yimi.s4_sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB= new DBHelper( this);

        Boolean checkInsertData= DB.insertUserData("Yimi", "96337112", "11/02/2002");
        if (checkInsertData)
            Toast.makeText(MainActivity.this, "Datos Insertados", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Datos NO Insertados", Toast.LENGTH_SHORT).show();

        Cursor res=DB.getUserData();

        StringBuffer buffer= new StringBuffer();

        while(res.moveToNext()){
            buffer.append("name :"+res.getString(0)+"\n");
            buffer.append("contact :"+res.getString(1)+"\n");
            buffer.append("Date of Birth :"+res.getString(2)+"\n");

        }
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(" Usuario Ingresados");
        builder.setMessage(buffer);
        builder.show();


    }
}