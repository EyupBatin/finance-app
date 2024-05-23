package com.example.finai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogintoContact extends AppCompatActivity {
    EditText fname, lname, pno;
    Button loginBtn;
    String ad, soyad, numara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginto_contact);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        pno = findViewById(R.id.phone);
        loginBtn = findViewById(R.id.LogintoContact);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad = fname.getText().toString();
                soyad = lname.getText().toString();
                numara = pno.getText().toString();

                // Veritabanı bağlantısını aç
                SQLiteDatabase db = openOrCreateDatabase("phonebook", MODE_PRIVATE, null);

                // Kullanıcıyı sorgula
                Cursor cursor = db.rawQuery("SELECT * FROM users WHERE fname = ? AND lname = ? AND pno = ?", new String[]{ad, soyad, numara});

                // Eğer kullanıcı bulunduysa
                if (cursor.moveToFirst()) {
                    Toast.makeText(LogintoContact.this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();

                            Intent in = new Intent(LogintoContact.this,Main_page.class);
                            startActivity(in);

                } else {
                    Toast.makeText(LogintoContact.this, "Kullanıcı bulunamadı!", Toast.LENGTH_SHORT).show();
                }

                // Cursor ve veritabanı bağlantısını kapat
                cursor.close();
                db.close();
            }
        });
    }
}