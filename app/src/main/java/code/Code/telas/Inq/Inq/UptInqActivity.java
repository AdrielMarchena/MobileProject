package code.Code.telas.Inq.Inq;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.Code.R;
import code.Code.dbs.ControllerInquilino;
import code.Code.modelos.InquilinoBean;

public class UptInqActivity extends AppCompatActivity {

        Button uptInq, delInq;

        @SuppressLint("SetTextI18n")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_inq);
            final ControllerInquilino ge = new ControllerInquilino(getBaseContext());
            final EditText nome = (EditText)findViewById(R.id.txtNomeInquilino);

            Intent it = getIntent();
            final InquilinoBean recuperado = (InquilinoBean) it.getSerializableExtra("Inquilino");
            nome.setText(recuperado.getNome());

            uptInq = (Button) findViewById(R.id.btnAlterar);
            uptInq.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String nomeString = nome.getText().toString();

                    recuperado.setNome(nomeString);

                    String msg = ge.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });

            delInq = (Button) findViewById(R.id.btnExcluir);
            delInq.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = ge.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });


        }
    }
