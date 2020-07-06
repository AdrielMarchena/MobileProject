package com.example.profalexandre.fatecmobile.telas.Imo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerImovel;
import com.example.profalexandre.fatecmobile.modelos.ImovelBean;
import com.example.profalexandre.fatecmobile.telas.UptUsuActivity;

import java.util.List;

public class ListImoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        ListView ListaDeImoveis;
        List<ImovelBean> imoveis;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_imovel);
            final ControllerImovel ge = new ControllerImovel(getBaseContext());
            ListaDeImoveis = (ListView) findViewById(R.id.listImo);
            imoveis = ge.listarImoveis();
            ArrayAdapter<ImovelBean> adapter = new ArrayAdapter<ImovelBean>(this,android.R.layout.simple_list_item_1,imoveis);
            ListaDeImoveis.setAdapter(adapter);
            ListaDeImoveis.setOnItemClickListener(this); // Clique no item
            ListaDeImoveis.setOnItemLongClickListener(this); // Pressão sobre o item
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi pressionado
            // position é a posição do item no adapter
            ImovelBean imo = (ImovelBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListImoActivity.this, UptImoActivity.class);
            it.putExtra("Imovel",imo);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + imo.getId(),Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi clicado
            // position é a posição do item no adapter
            ImovelBean imo = (ImovelBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListImoActivity.this, UptImoActivity.class);
            it.putExtra("Imovel",imo);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + imo.getId(),Toast.LENGTH_LONG).show();
        }
    }
