package com.example.finai;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddtoContact extends AppCompatActivity {
    EditText fname,lname,pno;
    Button btn;
    String ad,soyad,numara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_contact);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        pno =findViewById(R.id.phone);
        btn =findViewById(R.id.addtocontact);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = openOrCreateDatabase("phonebook",MODE_PRIVATE,null);
                db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, fname VARCHAR, lname VARCHAR, pno VARCHAR)");

                ad=fname.getText().toString();
                soyad=lname.getText().toString();
                numara=pno.getText().toString();
                db.execSQL("INSERT INTO users (fname,lname,pno) VALUES ('" + ad + "','" + soyad + "','" + numara + "')");


                Toast.makeText(AddtoContact.this, "data saved", Toast.LENGTH_SHORT).show();
                db.close();
                fname.setText("");
                lname.setText("");
                pno.setText("");
            }
        });
    }
}