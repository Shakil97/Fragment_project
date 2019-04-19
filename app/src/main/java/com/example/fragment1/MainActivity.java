package com.example.fragment1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements listfrag.ItemSelected {
    TextView tvdes;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvdes=findViewById(R.id.tvdes);
        descriptions=getResources().getStringArray(R.array.descriptions);
        if(findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.fragDetails))
                    .show(manager.findFragmentById(R.id.fragList))
                    .commit();
        }
        if(findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragDetails))
                    .show(manager.findFragmentById(R.id.fragList))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {
        tvdes.setText(descriptions[index]);

        if (findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager manager=this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.fragDetails))
                    .hide(manager.findFragmentById(R.id.fragList))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
