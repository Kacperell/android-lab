package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lab2", "create");
        Toast.makeText(this,"metoda on cereate",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lab2", "on START");
        Toast.makeText(this,"metoda on on START",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lab2", "on resuem");
        Toast.makeText(this,"metoda on  resume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lab2", "on pause");
        Toast.makeText(this,"metoda on  pause",Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Log.d("Lab2", "on stop");
        Toast.makeText(this,"metoda on stop",Toast.LENGTH_SHORT).show();
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("Lab2", "on Restart");
        Toast.makeText(this,"metoda  on Restart",Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lab2", "on Destroy");
        Toast.makeText(this,"metoda on Destroy",Toast.LENGTH_SHORT).show();
    }







}
