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
            Toast toast = Toast.makeText(getApplicationContext(),arrayDescricao().get(0),Toast.LENGTH_SHORT);
            toast.show();

        }catch (Exception ex){
            Log.e("captura","captura de array list falhou "+ ex);
        }
//        ArrayAdapter<String> arr;
//        arr= new ArrayAdapter<String>(this, android.R.layout.list_content,arrayDescricao());
//        listviewLista.setAdapter(arr);

    }


    private ArrayList<String>  arrayDescricao(){
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> descricao = bundle.getStringArrayList("descricao");
        return descricao;
    }
    private ArrayList<Integer>  arrayQuantidade(){
        Bundle bundle = getIntent().getExtras();
        ArrayList<Integer> quantidade = bundle.getIntegerArrayList("quantidade");
        return quantidade;
    }


}