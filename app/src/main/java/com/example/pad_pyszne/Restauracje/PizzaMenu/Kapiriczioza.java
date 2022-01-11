package com.example.pad_pyszne.Restauracje.PizzaMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pad_pyszne.GlownaStrona;
import com.example.pad_pyszne.Koszyk;
import com.example.pad_pyszne.MainActivity;
import com.example.pad_pyszne.R;
import com.example.pad_pyszne.Restauracje.Makarony;

public class Kapiriczioza extends AppCompatActivity {

    String Danie;
    int Koszyk;
    Double Cena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapiriczioza);
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

        //spinner
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
        RadioButton Puszyste = findViewById(R.id.radioButton2_Puszyste);
        RadioButton Cienkie = findViewById(R.id.radioButton_Cienkie);
        RadioButton Firmowe = findViewById(R.id.radioButton3_Firmowe);
        CheckBox Jajko = findViewById(R.id.checkBox_Jajko);
        CheckBox Ser = findViewById(R.id.checkBox_Ser);
        CheckBox Szynka = findViewById(R.id.checkBox_Szynka);
        Spinner Sosy = findViewById(R.id.Spinner_Sos);
        Switch Rozmiar = findViewById(R.id.Rozmiar);

        if(Koszyk == 7){
            Toast.makeText(this, "Osiagnieto limit zamowien", Toast.LENGTH_SHORT).show();
        }else {
            Koszyk += 1;
            if (Rozmiar.isChecked()) {
                Danie = Danie + "\n" + Koszyk + ")Kapriczioza Duza";
                Cena += 30;
            } else {
                Danie = Danie + "\n" + Koszyk + ")Kapriczioza Mala";
                Cena += 25;
            }
            if (Puszyste.isChecked()) {
                Danie = Danie + " na Puszystym ciescie \n Dodatki: ";
            }
            if (Cienkie.isChecked()) {
                Danie = Danie + " na Cienkim ciescie \n Dodatki: ";
            }
            if (Firmowe.isChecked()) {
                Danie = Danie + " na Firmowym ciescie \n Dodatki: ";
            }
            if (Jajko.isChecked()) {
                Danie = Danie + " Jajko ";
                Cena += 4;
            }
            if (Ser.isChecked()) {
                Danie = Danie + " Ser ";
                Cena += 2.2;
            }
            if (Szynka.isChecked()) {
                Danie = Danie + " Szynka ";
                Cena += 3.5;
            }
            switch (Sosy.getSelectedItem().toString()) {
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
    }
    public void Ciasto(View view) {
        RadioButton a = findViewById(R.id.radioButton2_Puszyste);
        RadioButton b = findViewById(R.id.radioButton_Cienkie);
        RadioButton c = findViewById(R.id.radioButton3_Firmowe);
        Button btn = findViewById(R.id.button_zamow);
        if(a.isChecked() || b.isChecked() || c.isChecked()) btn.setEnabled(true);
    }
}