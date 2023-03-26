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
    // faço esta instancia do lado de fora para poder usar no onClick do botões entre outros
    private EditText editTextDescricao,editTextNameQuantidade;
    private String descricao;
    private int quantidade;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       Faz o link entre os botões do xml e o codigo java
        Button buttonAdicionar = (Button)findViewById(R.id.buttonadicionar);
        Button buttonVisualizarTabelas = (Button)findViewById(R.id.buttonVisualizarTabelas);
//        Faz o link entre o editText e o java
         // não se pode fazer o link do id como global pois o app não ira iniciar, deves-se ser feito localmente
//         em uma variavel global
        this.editTextDescricao = (EditText)findViewById(R.id.editTextDescricao);
        this.editTextNameQuantidade = (EditText)findViewById(R.id.editTextNameQuantidade);


        try {
//            faz o set dos onClicks aos butões ligados a uma função cada
            buttonAdicionar.setOnClickListener(buttonAdicionarListener);
            buttonVisualizarTabelas.setOnClickListener(buttonVisualizarTabelasListener);
        }catch (Exception ex){
            Log.e("Buttons","adicionar listeners"+ex);
        }

    }
    // On click do botão de adicionar
    private View.OnClickListener buttonAdicionarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(editTextDescricao.getText().equals("") || editTextNameQuantidade.getText().toString().equals("")){
                msg("Há campos vazios, por favor preenchaos");
            }
        }
    };
    // On click do botão de ver tabelas ou seja passar para proxima pagina
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
    // Chama a proxima tela para aparecer na tela principal
    private void proximaTela(){
        Intent intent = new Intent(this,listagem.class);
        startActivity(intent);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}