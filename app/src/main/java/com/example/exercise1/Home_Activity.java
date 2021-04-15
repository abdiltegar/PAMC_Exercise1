package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private ListView list;
    private ListViewAdapter adapter;
    EditText etSearch;

    String[] listNama;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        listNama = new String[]{"Naruto","Ereh","Goku","Luffy","Hamtaro","Nobita","Tsubasa","Hattori","Doraemon","Inuyasha"};

        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada listNama
        for (int i = 0; i < listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);//Bind strings ke array
        }

        //membuat object dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //Binds adapter ke ListView
        list.setAdapter(adapter);

        etSearch = findViewById(R.id.etSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (Home_Activity.this).adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variable nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //memasukkan value dari variable nama dengan kunci a ke dalam bundle
                bundle.putString("a",nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                pm.setOnMenuItemClickListener(Home_Activity.this);//membuat event untuk pop up menu ketika dipilih
                pm.inflate(R.menu.popup_menu);//menampilkan popup menu dari layout menu
                pm.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.search, menu);
//
//        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if (TextUtils.isEmpty(s)) {
//                    adapter.inflater.getFilter();
//                    list.clearTextFilter();
//                } else {
//                    list.setFilterText(s);
//                }
//                return true;
//            }
//        });
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnView:
                Intent intent = new Intent(getApplicationContext(),LihatData_Activity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnEdit:
//                Toast.makeText(getApplicationContext(),"Ini untuk edit",Toast.LENGTH_LONG).show();
                switch (bundle.getString("a")) {
                    case "Naruto":
                        Toast.makeText(getApplicationContext(), "081222333444", Toast.LENGTH_LONG).show();
                        break;
                    case "Ereh":
                        Toast.makeText(getApplicationContext(), "081234567890", Toast.LENGTH_LONG).show();
                        break;
                    case "Goku":
                        Toast.makeText(getApplicationContext(), "081928374650", Toast.LENGTH_LONG).show();
                        break;
                    case "Luffy":
                        Toast.makeText(getApplicationContext(), "089123456789", Toast.LENGTH_LONG).show();
                        break;
                    case "Hamtaro":
                        Toast.makeText(getApplicationContext(), "089812345678", Toast.LENGTH_LONG).show();
                        break;
                    case "Nobita":
                        Toast.makeText(getApplicationContext(), "089871234567", Toast.LENGTH_LONG).show();
                        break;
                    case "Tsubasa":
                        Toast.makeText(getApplicationContext(), "089876123456", Toast.LENGTH_LONG).show();
                        break;
                    case "Hattori":
                        Toast.makeText(getApplicationContext(), "089876512345", Toast.LENGTH_LONG).show();
                        break;
                    case "Doraemon":
                        Toast.makeText(getApplicationContext(), "089876541234", Toast.LENGTH_LONG).show();
                        break;
                    case "Inuyasha":
                        Toast.makeText(getApplicationContext(), "089876543123", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }
        return false;
    }
}