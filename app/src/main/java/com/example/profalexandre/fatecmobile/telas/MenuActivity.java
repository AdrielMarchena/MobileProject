package com.example.profalexandre.fatecmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.modelos.UsuarioBean;
import com.example.profalexandre.fatecmobile.telas.Imo.AddImoActivity;
import com.example.profalexandre.fatecmobile.telas.Imo.ListImoActivity;
import com.example.profalexandre.fatecmobile.telas.Imo.ListImoParamActivity;
import com.example.profalexandre.fatecmobile.telas.ImoInq.Imo.AddImoInqActivity;
import com.example.profalexandre.fatecmobile.telas.ImoInq.Imo.ListImoInqActivity;
import com.example.profalexandre.fatecmobile.telas.ImoInq.Imo.ListImoInqParamActivity;
import com.example.profalexandre.fatecmobile.telas.Inq.Inq.AddInqActivity;
import com.example.profalexandre.fatecmobile.telas.Inq.Inq.ListInqActivity;
import com.example.profalexandre.fatecmobile.telas.Inq.Inq.ListInqParamActivity;

public class MenuActivity extends AppCompatActivity {

    //Buttons Usuario
    Button addUsu, listUsu, listUsuPar;
    //Buttons Imovel
    Button buttonAddImovel,buttonListAllImovel, buttonListParamImovel ;
    //Buttons Inquilino
    Button buttonAddInquilino, buttonListAllinquilino, buttonListParamInquilino;
    //Buttons Relation
    Button butotnAddImoInq, buttonListAllImoInq, buttonListParamImoInq;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        listUsu = (Button) findViewById(R.id.btlistusu);
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);
        textUsuLogado.setText(usuLogado.getLogin());
        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });
        //Buttons for Imovel
        buttonAddImovel = (Button) findViewById(R.id.btnnovoimo);
        buttonAddImovel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddImoActivity.class);
                startActivity(it);
            }
        });
        buttonListAllImovel = (Button) findViewById(R.id.btnlistartodosimo);
        buttonListAllImovel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListImoActivity.class);
                startActivity(it);
            }
        });
        buttonListParamImovel = (Button) findViewById(R.id.btnlistarparametroimo);
        buttonListParamImovel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListImoParamActivity.class);
                startActivity(it);
            }
        });

        //Buttons for Inquilino
        buttonAddInquilino = (Button) findViewById(R.id.btnnovoinq);
        buttonAddInquilino.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddInqActivity.class);
                startActivity(it);
            }
        });
        buttonListAllinquilino = (Button) findViewById(R.id.btnlistartodosinq);
        buttonListAllinquilino.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListInqActivity.class);
                startActivity(it);
            }
        });
        buttonListParamInquilino = (Button) findViewById(R.id.btnlistarparametroinq);
        buttonListParamInquilino.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListInqParamActivity.class);
                startActivity(it);
            }
        });
        //Butotns for Relation
        butotnAddImoInq = (Button) findViewById(R.id.btnnovorelacao);
        butotnAddImoInq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddImoInqActivity.class);
                startActivity(it);
            }
        });
        buttonListAllImoInq = (Button) findViewById(R.id.btnlistartodosrelacao);
        buttonListAllImoInq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListImoInqActivity.class);
                startActivity(it);
            }
        });
        buttonListParamImoInq = (Button) findViewById(R.id.btnlistarparametrorelacao);
        buttonListParamImoInq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListImoInqParamActivity.class);
                startActivity(it);
            }
        });

    }

}
