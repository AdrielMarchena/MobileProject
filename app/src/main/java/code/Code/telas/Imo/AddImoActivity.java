package code.Code.telas.Imo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.Code.R;
import code.Code.dbs.ControllerImovel;
import code.Code.modelos.ImovelBean;

public class AddImoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_imovel);
        final ControllerImovel ge = new ControllerImovel(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText endereco  = (EditText) findViewById(R.id.txtEndereco);
                EditText proprietario  = (EditText) findViewById((R.id.txtProprietario));
                EditText valorAluguel = (EditText) findViewById(R.id.txtValorAluguel);

                String enderecoString = endereco.getText().toString();
                String proprietarioString = proprietario.getText().toString();
                String valorString = valorAluguel.getText().toString();

                ImovelBean imo = new ImovelBean();
                imo.setId("");
                imo.setEndereco(enderecoString);
                imo.setProprietario(proprietarioString);
                imo.setValorAluguel(Double.parseDouble(valorString));
                String msg = ge.inserir(imo);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
