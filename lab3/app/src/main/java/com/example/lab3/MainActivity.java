package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE=1;
    public void kliknij(View view){
        Toast.makeText(getApplicationContext(),
                "Kliknięto przycisk Button",
                Toast.LENGTH_SHORT).show();
                Intent intencja=new Intent(this, LoginActivity.class);
                startActivity(intencja);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void losuj(View view){

        Random r = new Random();
        int liczba = r.nextInt(3)-0;

        Button button = findViewById(R.id.button3);
        button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher_background, 0, 0, 0);
    if(liczba==1) {button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher_background, 0, 0, 0);}
    else if(liczba==2){
        button.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher_foreground, 0, 0, 0);
    }else{
        button.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_menu_save, 0, 0, 0);
    }

        Toast.makeText(getApplicationContext(),
                "Wylosowana liczba:"+liczba,
                Toast.LENGTH_SHORT).show();



    }
    public void image_capture(View view){
        Toast.makeText(getApplicationContext(),
                "Kliknięto przycisk img",
                Toast.LENGTH_SHORT).show();

        Intent intencjaImg=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intencjaImg,REQUEST_IMAGE_CAPTURE);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk FAB",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id)
        {
            case R.id.action_settings:{
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk Settings",
                        Toast.LENGTH_SHORT).show();
                break;

            }
            case R.id.action_2:{
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk 2",
                        Toast.LENGTH_SHORT).show();
                break;

            }
            case R.id.action_3:{
                Toast.makeText(getApplicationContext(),
                        "Kliknięto przycisk 3",
                        Toast.LENGTH_SHORT).show();
                break;

            }
        }


        return super.onOptionsItemSelected(item);
    }
}
