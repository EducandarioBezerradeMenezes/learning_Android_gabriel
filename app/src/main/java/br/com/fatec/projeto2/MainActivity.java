package br.com.fatec.projeto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtvalor;
    private Spinner stdOp;
    private Button btnincluir;
    private  Button btnexcluir;
    private ListView LstDados;

     private ArrayAdapter<String> AdpOpcoes;
     private  ArrayAdapter<String> AdpDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtvalor = (EditText)findViewById(R.id.edtValor);
        stdOp = (Spinner)findViewById(R.id.Spn);
        btnincluir = (Button)findViewById(R.id.btnIncluir);
        btnexcluir = (Button)findViewById(R.id.btnExcluir);
        LstDados = (ListView)findViewById(R.id.LstView);

        btnincluir.setOnClickListener(this);
        btnexcluir.setOnClickListener(this);

        AdpOpcoes = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        AdpOpcoes.setDropDownViewResource(android.R.layout.simple_spinner_item);
        stdOp.setAdapter(AdpOpcoes);

        AdpOpcoes.add("Opcao 1");
        AdpOpcoes.add("Opcao 2");
        AdpOpcoes.add("Opcao 3");
        AdpOpcoes.add("Opcao 4");

        AdpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        LstDados.setAdapter(AdpDados);

    }


    @Override
    public void onClick(View vio){

    if(vio == btnincluir){
        String item = edtvalor.getText().toString();
        item += " - "+ stdOp.getSelectedItem();
        AdpDados.add(item);


    }else{

        if(vio == btnexcluir){

          if(AdpDados.getCount() > 0){

              String item = AdpDados.getItem(0);
              AdpDados.remove(item);
          }

        }
    }



    }




}
