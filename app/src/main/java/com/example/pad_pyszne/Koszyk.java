package com.example.pad_pyszne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Koszyk extends AppCompatActivity {

    String Danie;
    int Koszyk;
    Double Cena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koszyk);
        TextView zamowenia = findViewById(R.id.Zamowienia);

        //wczytywanie zamowienia klienta
        String DanieS = getIntent().getStringExtra("Danie");
        if(DanieS == null) DanieS = "Lista Zamowien:";
        Danie = DanieS;

        //wczytywanie ilosci dań
        int KoszykD = getIntent().getIntExtra("Koszyk", 0);
        Koszyk = KoszykD;

        TextView Koszyk_TV = findViewById(R.id.KoszykIlosc);
        Koszyk_TV.setText("Ilosc:" + Koszyk);
        zamowenia.setText(Danie);

        //wczytywanie ceny
        Double CenaD = getIntent().getDoubleExtra("Cena",0);
        Cena = CenaD;
    }

    public void page_Glowna(View view) {
        Intent i = new Intent(this, GlownaStrona.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }

    public void page_Zamownienia(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }

    public void page_Koszyk(View view) {
        Intent i = new Intent(this, Koszyk.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }

    public void zamow(View view) {
        if(Koszyk == 0){
            Toast.makeText(this, "Nie zamowiles nic", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, Podanie_Adresu.class);
            i.putExtra("Danie", Danie);
            i.putExtra("Koszyk", Koszyk);
            i.putExtra("Cena", Cena);
            startActivity(i);
        }
    }

    public void Resetuj(View view) {
        Intent i = new Intent(this, Koszyk.class);
        Danie = null;
        Koszyk = 0;
        Cena = 0.0;
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }
}