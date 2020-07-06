package com.example.profalexandre.fatecmobile.telas.ImoInq.Imo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerImoInq;
import com.example.profalexandre.fatecmobile.modelos.ImoInqBean;

import java.util.List;

public class ListImoInqParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeImovelInquilino;
    List<ImoInqBean> imoveisInquilinos;
    Button pesqImoInq;
    ArrayAdapter<ImoInqBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_imoinq_param);
        final Context con = getBaseContext();
        final ControllerImoInq ge = new ControllerImoInq(con);
        ListaDeImovelInquilino = (ListView) findViewById(R.id.listImoveisInquilinos);
        ListaDeImovelInquilino.setOnItemClickListener(this); // Clique no item
        ListaDeImovelInquilino.setOnItemLongClickListener(this); //
        final EditText obs = (EditText)findViewById(R.id.txtPesquisarObs);

        pesqImoInq = (Button) findViewById(R.id.btnPesquisar);
        pesqImoInq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String proprietarioString = obs.getText().toString();
                ImoInqBean imo = new ImoInqBean();
                imo.setObs(proprietarioString);
                imoveisInquilinos = ge.listarImoInq(imo);
                adapter = new ArrayAdapter<ImoInqBean>(con,android.R.layout.simple_list_item_1,imoveisInquilinos);
                ListaDeImovelInquilino.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ImoInqBean imoInq = (ImoInqBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListImoInqParamActivity.this, UptImoInqActivity.class);
        it.putExtra("ImovelInquilino",imoInq);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + imoInq.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ImoInqBean imoInq = (ImoInqBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListImoInqParamActivity.this, UptImoInqActivity.class);
        it.putExtra("ImovelInquilino",imoInq);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + imoInq.getId(),Toast.LENGTH_LONG).show();
    }
}