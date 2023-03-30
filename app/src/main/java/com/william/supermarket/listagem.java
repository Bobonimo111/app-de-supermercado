package com.william.supermarket;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        ListView listviewLista = (ListView)findViewById(R.id.ListViewLista);


        try{
            Bundle bundle = getIntent().getExtras();
            ArrayList<CharSequence> item = bundle.getCharSequenceArrayList("descricao");
            ArrayAdapter<String> adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1,item);

            listviewLista.setAdapter(adapter);

        }catch (Exception ex){
            Log.e("captura","captura de array list falhou "+ ex);
        }
//        ArrayAdapter<String> arr;
//        arr= new ArrayAdapter<String>(this, android.R.layout.list_content,arrayDescricao());
//        listviewLista.setAdapter(arr);

    }




}