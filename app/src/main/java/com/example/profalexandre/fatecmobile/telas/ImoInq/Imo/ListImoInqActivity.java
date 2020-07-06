package com.example.profalexandre.fatecmobile.telas.ImoInq.Imo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerImoInq;
import com.example.profalexandre.fatecmobile.modelos.ImoInqBean;

import java.util.List;

public class ListImoInqActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        ListView ListaDeImoveisInquilinos;
        List<ImoInqBean> imoveisInquilinos;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_imoinq);
            final ControllerImoInq ge = new ControllerImoInq(getBaseContext());
            ListaDeImoveisInquilinos = (ListView) findViewById(R.id.listImoInq);
            imoveisInquilinos = ge.listarImoInq();
            ArrayAdapter<ImoInqBean> adapter = new ArrayAdapter<ImoInqBean>(this,android.R.layout.simple_list_item_1,imoveisInquilinos);
            ListaDeImoveisInquilinos.setAdapter(adapter);
            ListaDeImoveisInquilinos.setOnItemClickListener(this); // Clique no item
            ListaDeImoveisInquilinos.setOnItemLongClickListener(this); // Pressão sobre o item
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi pressionado
            // position é a posição do item no adapter
            ImoInqBean imoInq = (ImoInqBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListImoInqActivity.this, UptImoInqActivity.class);
            it.putExtra("ImovelInquilino",imoInq);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + imoInq.getId(),Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi pressionado
            // position é a posição do item no adapter
            ImoInqBean imoInq = (ImoInqBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListImoInqActivity.this, UptImoInqActivity.class);
            it.putExtra("ImovelInquilino",imoInq);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + imoInq.getId(),Toast.LENGTH_LONG).show();
        }
    }
