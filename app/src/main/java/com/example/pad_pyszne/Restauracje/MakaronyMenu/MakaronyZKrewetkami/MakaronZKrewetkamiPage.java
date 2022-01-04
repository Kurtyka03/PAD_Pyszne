package com.example.pad_pyszne.Restauracje.MakaronyMenu.MakaronyZKrewetkami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.pad_pyszne.GlownaStrona;
import com.example.pad_pyszne.Koszyk;
import com.example.pad_pyszne.MainActivity;
import com.example.pad_pyszne.R;

public class MakaronZKrewetkamiPage extends AppCompatActivity {

    String Koszyk, Danie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makaron_zkrewetkami_page);
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

    public void zamow(View view) {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        RadioButton sojowy = findViewById(R.id.radioButton_sojowy);
        RadioButton przenny = findViewById(R.id.radioButton2_przenny);
        RadioButton wieloziarnisty = findViewById(R.id.radioButton3_wieloziarnisty);
        CheckBox Jajko = findViewById(R.id.checkBox_Jajko);
        CheckBox Ser = findViewById(R.id.checkBox_Ser);
        CheckBox Szynka = findViewById(R.id.checkBox_Szynka);
        if(sojowy.isChecked()){
            Danie = "Makaron Sojowy \n Dodatki:";
        }
        if(przenny.isChecked()){
            Danie = "Makaron Przenny \n Dodatki:";
        }
        if(wieloziarnisty.isChecked()){
            Danie = "Makaron Wieloziarnisty \n Dodatki:";
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
    }
    public void makaron(View view) {
        RadioButton a = findViewById(R.id.radioButton_sojowy);
        RadioButton b = findViewById(R.id.radioButton2_przenny);
        RadioButton c = findViewById(R.id.radioButton3_wieloziarnisty);
        Button btn = findViewById(R.id.button_zamow);
        if(a.isChecked() || b.isChecked() || c.isChecked()) btn.setEnabled(true);
    }
}