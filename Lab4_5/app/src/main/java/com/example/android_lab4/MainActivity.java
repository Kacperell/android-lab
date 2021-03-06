package com.example.android_lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> target;
    private SimpleCursorAdapter adapter;
    private MySQLite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] values = new String[]{"Pies", "Kot", "Koń", "Gołąb", "Kruk",
                "Dzik", "Karp", "Osioł", "Chomik", "Mysz", "Jeż", "Karaluch"};

        this.target = new ArrayList<String>();
        this.target.addAll(Arrays.asList(values));

//        this.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
//                this.target);
        this.db = new MySQLite(this);
        this.adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, db.lista(),
                new String[] {"_id", "gatunek"},
                new int[] {android.R.id.text1, android.R.id.text2},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE
        );


        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(this.adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>
                                            adapter, View view, int pos, long id)
            {
                TextView name = (TextView) view.findViewById(android.R.id.text1);
                Animal zwierz = db.pobierz(Integer.parseInt(name.getText().toString()));

                Intent intencja = new Intent(getApplicationContext(), DodajWpis.class);
                intencja.putExtra("element", zwierz);
                startActivityForResult(intencja, 2);

            }
        });


        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {@Override public boolean
        onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            final TextView name = (TextView) view.findViewById(android.R.id.text1);
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case DialogInterface.BUTTON_POSITIVE:
                                    //Yes button clicked
                                    db.usun(name.getText().toString());
                                    adapter.changeCursor(db.lista());
                                    adapter.notifyDataSetChanged();
                                    break;
                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();
                    return true;
                   }
                    });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    public void nowyWpis(MenuItem mi) {
        Intent intencja = new Intent(this, DodajWpis.class);
        startActivityForResult(intencja, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
//            String nowy = (String) extras.get("wpis");
//            target.add(nowy);
//            adapter.notifyDataSetChanged();
            Animal nowy = (Animal) extras.getSerializable("nowy");
            this.db.dodaj(nowy);
            adapter.changeCursor(db.lista());
            adapter.notifyDataSetChanged();
        }else if(requestCode==2 && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Animal nowy = (Animal) extras.getSerializable("nowy");
            this.db.aktualizuj(nowy);
            adapter.changeCursor(db.lista());
            adapter.notifyDataSetChanged();
        }

    }

}