package com.example.pad_pyszne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Koszyk extends AppCompatActivity {

    String Koszyk, Danie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koszyk);
        String Danie = getIntent().getStringExtra("Danie");

        TextView zamowenia = findViewById(R.id.Zamowienia);

        zamowenia.setText(Danie);
    }

    public void page_Glowna(View view) {
        Intent i = new Intent(this, GlownaStrona.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        startActivity(i);
    }

    public void page_Zamownienia(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        startActivity(i);
    }

    public void page_Koszyk(View view) {
        Intent i = new Intent(this, Koszyk.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        startActivity(i);
    }
}