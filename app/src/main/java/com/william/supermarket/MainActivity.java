package com.william.supermarket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // faço esta instancia do lado de fora para poder usar no onClick do botões entre outros
    private EditText editTextDescricao, editTextNameQuantidade;


    //    arrays para serem passados as colunas, para a listagem
    private ArrayList<CharSequence> arrayDescricao = new ArrayList<>();
    private ArrayList<Integer> arrayQuantidade = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       Faz o link entre os botões do xml e o codigo java
        Button buttonAdicionar = (Button) findViewById(R.id.buttonadicionar);
        Button buttonVisualizarTabelas = (Button) findViewById(R.id.buttonVisualizarTabelas);
//        Faz o link entre o editText e o java
        // não se pode fazer o link do id como global pois o app não ira iniciar, deves-se ser feito localmente
//         em uma variavel global
        this.editTextDescricao = (EditText) findViewById(R.id.editTextDescricao);
        this.editTextNameQuantidade = (EditText) findViewById(R.id.editTextNameQuantidade);


        try {
//            faz o set dos onClicks aos butões ligados a uma função cada
            buttonAdicionar.setOnClickListener(buttonAdicionarListener);
            buttonVisualizarTabelas.setOnClickListener(buttonVisualizarTabelasListener);
        } catch (Exception ex) {
            Log.e("Buttons", "adicionar listeners" + ex);
        }

    }

    // On click do botão de adicionar
    private View.OnClickListener buttonAdicionarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (editTextDescricao.getText().equals("") || editTextNameQuantidade.getText().toString().equals("")) {
                msg("Há campos vazios, por favor preenchaos");
            } else {
                arrayDescricao.add(editTextDescricao.getText().toString());
                arrayQuantidade.add((Integer.parseInt(editTextNameQuantidade.getText().toString())));
                Log.i("entrada", "Descrição : adicionado com sucesso");
                telaListagem();

            }
        }
    };
    // On click do botão de ver tabelas ou seja passar para proxima pagina
    private View.OnClickListener buttonVisualizarTabelasListener = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            try {
                Log.i("Buttons", "Clicado");
                telaListagem();

            } catch (Exception ex) {
                Log.e("Buttons", "Proxima tela: " + ex);
            }
        }
    };

    private void msg(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    // Chama a proxima tela para aparecer na tela principal
    private void telaListagem() {
        Intent intent = new Intent(this,listagem.class);
        Bundle bundle = new Bundle();
        bundle.putCharSequenceArrayList("descricao",this.arrayDescricao);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}