package com.dev.izcax.hitungbensin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.izcax.hitungbensin.Adapter.TabFragmentPagerAdapter;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.rengwuxian.materialedittext.validation.RegexpValidator;

public class MainActivity extends AppCompatActivity {
    MaterialEditText edtjarakmotor,edtjarakmobil,edtwaktumotor,
            edtwaktumobil, edthargamotor, edthargamobil;
    TextView txtHslmotor, txtHslmobil;
    EditText edtjenis;

    //deklarasi semua komponen View yang akan digunakan
    private Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabs;

    public static int jarakmotor, hargamotor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up toolbar
        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hitung Bensin");

        //inisialisasi tab dan pager
        pager = (ViewPager)findViewById(R.id.pager);
        tabs = (TabLayout)findViewById(R.id.tabs);

        //set object adapter kedalam ViewPager
        pager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));

        //Manimpilasi sedikit untuk set TextColor pada Tab
        tabs.setTabTextColors(getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(android.R.color.black));

        //set tab ke ViewPager
        tabs.setupWithViewPager(pager);

        //konfigurasi Gravity Fill untuk Tab berada di posisi yang proposional
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    public void motor(View v){
        edtjarakmotor = (MaterialEditText)findViewById(R.id.edtjarakmotor);
        edthargamotor = (MaterialEditText)findViewById(R.id.edthargamotor);
        edtwaktumotor = (MaterialEditText)findViewById(R.id.edtwaktumotor);
        txtHslmotor = (TextView)findViewById(R.id.txtHslmotor);
        edtjenis = (EditText) findViewById(R.id.edtjenis);
        edtjarakmotor.validateWith(new RegexpValidator("Masukkan Angka", "\\d+"));
        edthargamotor.validateWith(new RegexpValidator("Masukkan Angka", "\\d+"));
        edtwaktumotor.validateWith(new RegexpValidator("Masukkan Angka", "\\d+"));

        String jenis = edtjenis.getText().toString();

        if (jenis.equals("Bebek")){
            jarakmotor = Integer.parseInt(edtjarakmotor.getText().toString());
            hargamotor = Integer.parseInt(edthargamotor.getText().toString());
            int hitungbebek = (jarakmotor/50)*hargamotor; //1:50
            String biayamotor = String.valueOf(hitungbebek);
            txtHslmotor.setText("Perkiraan biaya sebesar: "+"Rp "+biayamotor+",-");
        } else if (jenis.equals("Matic")){
            jarakmotor = Integer.parseInt(edtjarakmotor.getText().toString());
            hargamotor = Integer.parseInt(edthargamotor.getText().toString());
            int hitungmatic = (jarakmotor/60)*hargamotor; //1:60
            String biayamatic = String.valueOf(hitungmatic);
            txtHslmotor.setText("Perkiraan biaya sebesar: "+"Rp "+biayamatic+",-");
        } else {
            Toast.makeText(getApplicationContext(),"Pilih jenis motor", Toast.LENGTH_SHORT).show();
        }
    }

    public void mobil (View v){
        edtjarakmobil = (MaterialEditText)findViewById(R.id.edtjarakmobil);
        edthargamobil = (MaterialEditText)findViewById(R.id.edthargamobil);
        edtwaktumobil = (MaterialEditText)findViewById(R.id.edtwaktumobil);
        edtjarakmobil.validateWith(new RegexpValidator("Masukkan Angka", "\\d+"));
        edthargamobil.validateWith(new RegexpValidator("Masukkan Angka", "\\d+"));
        edtwaktumobil.validateWith(new RegexpValidator("Masukkan Angka", "\\d+"));
        txtHslmobil = (TextView)findViewById(R.id.txtHslmobil);

        int jarakmobil = Integer.parseInt(edtjarakmobil.getText().toString());
        int hargamobil = Integer.parseInt(edthargamobil.getText().toString());
        int hitungmobil = (jarakmobil/50)*hargamobil; //1:20
        String biayamobil = String.valueOf(hitungmobil);
        txtHslmobil.setText("Perkiraan biaya sebesar: "+"Rp "+biayamobil+",-");
    }

}