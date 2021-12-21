package com.example.pad_pyszne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pad_pyszne.Restauracje.Makarony;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void page_Makarony(View view) {
        Intent i = new Intent(this, Makarony.class);
        startActivity(i);
    }
}