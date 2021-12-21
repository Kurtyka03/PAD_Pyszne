package com.example.pad_pyszne.Restauracje.MakaronyMenu.MakarooBolonski;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pad_pyszne.GlownaStrona;
import com.example.pad_pyszne.Koszyk;
import com.example.pad_pyszne.MainActivity;
import com.example.pad_pyszne.R;

public class MakaronBolonskiPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makaron_bolonski_page);
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