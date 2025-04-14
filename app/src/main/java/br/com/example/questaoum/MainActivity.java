package br.com.example.questaoum;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView valorTotal;
    private CheckBox checkArroz, checkLeite, checkCarne, checkFeijao, checkRefrigerante;
    private double precoTotal = 0d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ItensSelecionados();

    }

    public void ItensSelecionados(){


        Produto arroz = new Produto("Arroz 1kg", 2.69);
        Produto leite = new Produto("Leite Longa vida", 2.7);
        Produto carne = new Produto("Carne Friboi", 16.7);
        Produto feijao = new Produto("Feijão Carioquinha 1kg", 3.88);
        Produto refrigerante = new Produto("Refrigerante", 3.88);

        checkArroz = findViewById(R.id.ArrozBox);
        checkLeite = findViewById(R.id.LeiteBox);
        checkCarne = findViewById(R.id.CarneBox);
        checkFeijao = findViewById(R.id.FeijaoBox);
        checkRefrigerante = findViewById(R.id.RefigreranteBox);
        valorTotal = findViewById(R.id.txtValorTotal);

        checkArroz.setOnCheckedChangeListener((buttonView, isChecked) ->atualizarValor(arroz.getValor(), isChecked));
        checkLeite.setOnCheckedChangeListener((buttonView, isChecked) ->atualizarValor(leite.getValor(), isChecked));
        checkCarne.setOnCheckedChangeListener((buttonView, isChecked) ->atualizarValor(carne.getValor(), isChecked));
        checkFeijao.setOnCheckedChangeListener((buttonView, isChecked) ->atualizarValor(feijao.getValor(), isChecked));
        checkRefrigerante.setOnCheckedChangeListener((buttonView, isChecked) ->atualizarValor(refrigerante.getValor(), isChecked));

    }
    private void atualizarValor(double valor, boolean isChecked){
        if(isChecked){
            precoTotal +=valor;
        }else{
            precoTotal -= valor;
        }
        valorTotal.setText("Valor total: R$ " + String.format("%.2f", precoTotal));

    }

}