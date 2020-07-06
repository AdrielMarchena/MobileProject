package com.example.profalexandre.fatecmobile.telas.Inq.Inq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerInquilino;
import com.example.profalexandre.fatecmobile.modelos.InquilinoBean;

public class AddInqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inquilino);
        final ControllerInquilino ge = new ControllerInquilino(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btnInserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome  = (EditText) findViewById(R.id.txtNome);

                String nomeString = nome.getText().toString();


                InquilinoBean inq = new InquilinoBean();
                inq.setId("");
                inq.setNome(nomeString);
                String msg = ge.inserir(inq);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
