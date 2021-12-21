package com.example.pad_pyszne.Restauracje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pad_pyszne.GlownaStrona;
import com.example.pad_pyszne.Koszyk;
import com.example.pad_pyszne.MainActivity;
import com.example.pad_pyszne.R;
import com.example.pad_pyszne.Restauracje.MakaronyMenu.MakaronyZKrewetkami.MakaronZKrewetkamiPage;
import com.example.pad_pyszne.Restauracje.MakaronyMenu.MakarooBolonski.MakaronBolonskiPage;

public class Makarony extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makarony);
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

    public void MakaronZKrewetkami(View view) {
        Intent i = new Intent(this, MakaronZKrewetkamiPage.class);
        startActivity(i);
    }

    public void MakaronBolonski(View view) {
        Intent i = new Intent(this, MakaronBolonskiPage.class);
        startActivity(i);
    }
}