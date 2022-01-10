package com.example.pad_pyszne.Restauracje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pad_pyszne.GlownaStrona;
import com.example.pad_pyszne.Koszyk;
import com.example.pad_pyszne.MainActivity;
import com.example.pad_pyszne.R;
import com.example.pad_pyszne.Restauracje.MakaronyMenu.MakaronyZKrewetkami.MakaronZKrewetkamiPage;
import com.example.pad_pyszne.Restauracje.MakaronyMenu.MakarooBolonski.MakaronBolonskiPage;
import com.example.pad_pyszne.Restauracje.PizzaMenu.Hawajska;
import com.example.pad_pyszne.Restauracje.PizzaMenu.Kapiriczioza;

public class Pizza extends AppCompatActivity {

    String Danie;
    int Koszyk;
    Double Cena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
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
        i.putExtra("Cena", Cena);
        i.putExtra("Koszyk", Koszyk);
        startActivity(i);
    }

    public void page_Koszyk(View view) {
        Intent i = new Intent(this, Koszyk.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }

    public void Kapiriczioza(View view) {
        Intent i = new Intent(this, Kapiriczioza.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }

    public void Hawajskaa(View view) {
        Intent i = new Intent(this, Hawajska.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }
}