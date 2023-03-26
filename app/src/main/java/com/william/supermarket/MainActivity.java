package com.william.supermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonAdicionar = (Button)findViewById(R.id.buttonadicionar);
        Button buttonVisualizarTabelas = (Button)findViewById(R.id.buttonVisualizarTabelas);
        //EditText editTextDescricao = (EditText)findViewById(R.id.editTextDescricao);
        //EditText editTextNameQuantidade = (EditText)findViewById(R.id.editTextNameQuantidade);

        try {
            buttonAdicionar.setOnClickListener(buttonAdicionarListener);
            buttonVisualizarTabelas.setOnClickListener(buttonVisualizarTabelasListener);
        }catch (Exception ex){
            Log.e("Buttons","adicionar listeners"+ex);
        }
    }
    private View.OnClickListener buttonAdicionarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    private View.OnClickListener buttonVisualizarTabelasListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                Log.i("Buttons","Clicado");
                proximaTela();
            }catch (Exception ex){
                Log.e("Buttons","Proxima tela: "+ex);
            }
        }
    };
    private void msg(String msg){
        Toast toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        toast.show();

    }
    private void proximaTela(){
        Intent intent = new Intent(this,listagem.class);
        startActivity(intent);
    }
}