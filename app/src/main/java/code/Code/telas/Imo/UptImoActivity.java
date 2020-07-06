package code.Code.telas.Imo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.Code.R;
import code.Code.dbs.ControllerImovel;
import code.Code.modelos.ImovelBean;

public class UptImoActivity extends AppCompatActivity {

        Button uptImo, delImo;

        @SuppressLint("SetTextI18n")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_imo);
            final ControllerImovel ge = new ControllerImovel(getBaseContext());
            final EditText endereco = (EditText)findViewById(R.id.txtEndereco);
            final EditText proprietario = (EditText)findViewById((R.id.txtProprietario));
            final EditText valorAluguel = (EditText)findViewById(R.id.txtValorAluguel);
            Intent it = getIntent();
            final ImovelBean recuperado = (ImovelBean) it.getSerializableExtra("Imovel");
            endereco.setText(recuperado.getEndereco());
            proprietario.setText(recuperado.getProprietario());
            valorAluguel.setText(Double.toString(recuperado.getValorAluguel()));

            uptImo = (Button) findViewById(R.id.btnAlterar);
            uptImo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String enderecoString = endereco.getText().toString();
                    String proprietarioString = proprietario.getText().toString();
                    String valorString = valorAluguel.getText().toString();
                    recuperado.setEndereco(enderecoString);
                    recuperado.setProprietario(proprietarioString);
                    recuperado.setValorAluguel(Double.parseDouble(valorString.replace(",",".")));
                    String msg = ge.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });

            delImo = (Button) findViewById(R.id.btnExcluir);
            delImo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = ge.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });


        }
    }
