package com.example.pad_pyszne.Restauracje.MakaronyMenu.MakarooBolonski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pad_pyszne.GlownaStrona;
import com.example.pad_pyszne.Koszyk;
import com.example.pad_pyszne.MainActivity;
import com.example.pad_pyszne.R;
import com.example.pad_pyszne.Restauracje.Makarony;

public class MakaronBolonskiPage extends AppCompatActivity {

    String Danie;
    int Koszyk;
    Double Cena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makaron_bolonski_page);
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

        Spinner Sosy = findViewById(R.id.Spinner_Sos);
        ArrayAdapter<CharSequence> Lista = ArrayAdapter.createFromResource(this, R.array.Sos_array, android.R.layout.simple_spinner_item);
        Lista.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Sosy.setAdapter(Lista);
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
        RadioButton sojowy = findViewById(R.id.radioButton_sojowy);
        RadioButton przenny = findViewById(R.id.radioButton2_przenny);
        RadioButton wieloziarnisty = findViewById(R.id.radioButton3_wieloziarnisty);
        CheckBox Jajko = findViewById(R.id.checkBox_Jajko);
        CheckBox Ser = findViewById(R.id.checkBox_Ser);
        CheckBox Szynka = findViewById(R.id.checkBox_Szynka);
        Spinner Sosy = findViewById(R.id.Spinner_Sos);

        Koszyk += 1;
        if(sojowy.isChecked()){
            Danie = Danie + "\n"+ Koszyk +")Bolonesse:\n Makaron Sojowy \n Dodatki:";
        }
        if(przenny.isChecked()){
            Danie = Danie + "\n"+ Koszyk +")Bolonesse:\n Makaron Przenny \n Dodatki:";
        }
        if(wieloziarnisty.isChecked()){
            Danie = Danie + "\n"+ Koszyk +")Bolonesse:\n Makaron Wieloziarnisty \n Dodatki:";
        }
        if(Jajko.isChecked()){
            Danie = Danie + " Jajko ";
        }
        if(Ser.isChecked()){
            Danie = Danie + " Ser ";
        }
        if(Szynka.isChecked()){
            Danie = Danie + " Szynka ";
        }
        switch (Sosy.getSelectedItem().toString()){
            case "Czosnek":
                Danie = Danie + "\nZ sosem Czosnkowym";
                break;
            case "Pomidorowy":
                Danie = Danie + "\nZ sosem Pomidorowym";
                break;
            case "Smietankowy":
                Danie = Danie + "\nZ sosem Smietankowym";
                break;
        }
        Intent i = new Intent(this, Makarony.class);
        i.putExtra("Danie", Danie);
        i.putExtra("Koszyk", Koszyk);
        i.putExtra("Cena", Cena);
        startActivity(i);
    }
    public void makaron(View view) {
        RadioButton a = findViewById(R.id.radioButton_sojowy);
        RadioButton b = findViewById(R.id.radioButton2_przenny);
        RadioButton c = findViewById(R.id.radioButton3_wieloziarnisty);
        Button btn = findViewById(R.id.button_zamow);
        if(a.isChecked() || b.isChecked() || c.isChecked()) btn.setEnabled(true);
    }

}