package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ArrayList<String> huruf = new ArrayList<>();
    Button[] buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(), "Selamat bermain", Toast.LENGTH_LONG).show();

        huruf.add("A");huruf.add("B");huruf.add("C");huruf.add("D");
        huruf.add("E");huruf.add("F");huruf.add("G");huruf.add("H");
        huruf.add("I");huruf.add("J");huruf.add("K");huruf.add("L");
        huruf.add("M");huruf.add("N");huruf.add("O");huruf.add(" ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater Inflater = getMenuInflater();
        Inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.kembali){
            finish();
        }else if (item.getItemId()==R.id.ulangi){
            random();
        }
        return true;
    }

    public void random() {
        int index;
        int temp;
        Random r = new Random();

        Button[] tombol = new Button[16];
        tombol[0]= (Button) findViewById(R.id.a);
        tombol[1]= (Button) findViewById(R.id.b);
        tombol[2]= (Button) findViewById(R.id.c);
        tombol[3]= (Button) findViewById(R.id.d);
        tombol[4]= (Button) findViewById(R.id.e);
        tombol[5]= (Button) findViewById(R.id.f);
        tombol[6]= (Button) findViewById(R.id.g);
        tombol[7]= (Button) findViewById(R.id.h);
        tombol[8]= (Button) findViewById(R.id.i);
        tombol[9]= (Button) findViewById(R.id.j);
        tombol[10]= (Button) findViewById(R.id.k);
        tombol[11]= (Button) findViewById(R.id.l);
        tombol[12]= (Button) findViewById(R.id.m);
        tombol[13]= (Button) findViewById(R.id.n);
        tombol[14]= (Button) findViewById(R.id.o);
        tombol[15]= (Button) findViewById(R.id.p);

        int nilai[]= new int[16];

        for (int i =huruf.size(); i >0; i--){
            index = r.nextInt(i+1);
//            temp = cek(index);
            tombol[i-1].setText(huruf.get(index));

        }
    }

    private int cek(int index) {
        int nilai[]= new int[16];
        int x;String a = " ";
        Random r = new Random();
        for (int i =0; i<16;i++){
            if (i == index){
                if (nilai[i] == 0){
                    nilai[i] = index;
                    a=" ";
                }else{
                    a="sama";
                }
            }
            Log.d(TAG, "onCreate: name " + nilai[i]);
        }

        if (a.equals("sama")){
            if (index == 0 ) {
                index=16;
            }
            index--;
//            x = r.nextInt(index + 1);
            cek(index);
        }
        return index;
    }
}