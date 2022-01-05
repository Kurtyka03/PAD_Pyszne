package com.example.pad_pyszne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Podanie_Adresu extends AppCompatActivity {

    String Danie;
    int Koszyk;
    Double Cena;
    int NapiwekInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podanie_adresu);
        SeekBar Napiwek = findViewById(R.id.Napiwek);
        TextView Ilosc_Napiwku = findViewById(R.id.Ilosc_napiwku);
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

        Napiwek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                NapiwekInt = Napiwek.getProgress();
                Ilosc_Napiwku.setText(NapiwekInt + " zł");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    public void zamow(View view) {
        EditText Adres = findViewById(R.id.editTextTextPostalAddress);
        EditText Phone = findViewById(R.id.editTextPhone);
        boolean Telefon = Pattern.matches("^[0-9]{9}$",Phone.getText());
        //boolean Adress = Pattern.matches("^[a-zA-Z0-9]$",Adres.getText());
        if(Telefon){
            Intent i = new Intent(this, Podsumowanie.class);
            i.putExtra("Adres", Adres.getText().toString());
            i.putExtra("Telefon", Phone.getText().toString());
            i.putExtra("Danie", Danie);
            i.putExtra("Koszyk", Koszyk);
            i.putExtra("Cena", Cena);
            i.putExtra("Napiwek", NapiwekInt);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Nieprawidlowe dane", Toast.LENGTH_SHORT).show();
        }
    }
}