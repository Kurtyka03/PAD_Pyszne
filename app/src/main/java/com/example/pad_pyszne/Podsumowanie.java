package com.example.pad_pyszne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Podsumowanie extends AppCompatActivity {

    String Danie;
    int Koszyk;
    Double Cena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podsumowanie);
        //wczytywanie zamowienia klienta
        String DanieS = getIntent().getStringExtra("Danie");
        if(DanieS == null) DanieS = "Lista Zamowien:";
        Danie = DanieS;

        //wczytywanie ilosci dań
        int KoszykD = getIntent().getIntExtra("Koszyk", 0);
        Koszyk = KoszykD;

        TextView Koszyk_TV = findViewById(R.id.KoszykIlosc);
        Koszyk_TV.setText("Ilosc:" + Koszyk);

        //wczytywanie ceny
        Double CenaD = getIntent().getDoubleExtra("Cena",0);
        Cena = CenaD;

        String Adres = getIntent().getStringExtra("Adres");
        String Phone = getIntent().getStringExtra("Telefon");

        TextView Zamownie = findViewById(R.id.ZamowieniePod);

        int Napiwek = getIntent().getIntExtra("Napiwek",0);

        Zamownie.setText("Zamownie na : " + Adres + "\nTelefon : " + Phone +
            "\nCena Zamowenie : " + Cena + "zł" + "\nNapiwek : "+ Napiwek + "zł\n" + Danie);
    }

    public void page_Glowna(View view) {
        Intent i = new Intent(this, GlownaStrona.class);
        startActivity(i);
    }

    public void page_Zamownienia(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void page_Koszyk(View view) {
        Intent i = new Intent(this, Koszyk.class);
        startActivity(i);
    }
}