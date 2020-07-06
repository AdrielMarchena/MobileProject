package com.example.profalexandre.fatecmobile.telas.ImoInq.Imo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerImoInq;
import com.example.profalexandre.fatecmobile.modelos.ImoInqBean;

public class UptImoInqActivity extends AppCompatActivity {

        Button uptImoInq, delImoInq;

        @SuppressLint("SetTextI18n")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_imoinq);
            final ControllerImoInq ge = new ControllerImoInq(getBaseContext());
            final EditText imovel = (EditText)findViewById(R.id.txtImovel);
            final EditText inquilino = (EditText)findViewById((R.id.txtInquilino));
            final EditText obs = (EditText)findViewById(R.id.txtObservacao);

            Intent it = getIntent();
            final ImoInqBean recuperado = (ImoInqBean) it.getSerializableExtra("ImovelInquilino");
            imovel.setText(recuperado.getIdImovel());
            inquilino.setText(recuperado.getIdInquilino());
            obs.setText(recuperado.getObs());

            uptImoInq = (Button) findViewById(R.id.btnAlterar);
            uptImoInq.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String imovelString = imovel.getText().toString();
                    String inquilinoString = inquilino.getText().toString();
                    String obsString = obs.getText().toString();
                    recuperado.setIdImovel(imovelString);
                    recuperado.setIdInquilino(inquilinoString);
                    recuperado.setObs(obsString);
                    String msg = ge.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });

            delImoInq = (Button) findViewById(R.id.btnExcluir);
            delImoInq.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = ge.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });


        }
    }
