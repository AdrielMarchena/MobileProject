package com.example.profalexandre.fatecmobile.telas.Inq.Inq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.profalexandre.fatecmobile.R;
import com.example.profalexandre.fatecmobile.dbs.ControllerInquilino;
import com.example.profalexandre.fatecmobile.modelos.InquilinoBean;

import java.util.List;

public class ListInqActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        ListView ListaDeInquilinos;
        List<InquilinoBean> inquilinos;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_inquilino);
            final ControllerInquilino ge = new ControllerInquilino(getBaseContext());
            ListaDeInquilinos = (ListView) findViewById(R.id.listInq);
            inquilinos = ge.listarInquilinos();
            ArrayAdapter<InquilinoBean> adapter = new ArrayAdapter<InquilinoBean>(this,android.R.layout.simple_list_item_1,inquilinos);
            ListaDeInquilinos.setAdapter(adapter);
            ListaDeInquilinos.setOnItemClickListener(this); // Clique no item
            ListaDeInquilinos.setOnItemLongClickListener(this); // Pressão sobre o item
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi pressionado
            // position é a posição do item no adapter
            InquilinoBean inq = (InquilinoBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListInqActivity.this, UptInqActivity.class);
            it.putExtra("Inquilino",inq);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + inq.getId(),Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi clicado
            // position é a posição do item no adapter
            InquilinoBean inq = (InquilinoBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListInqActivity.this, UptInqActivity.class);
            it.putExtra("Inquilino",inq);
            startActivity(it);
            Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + inq.getId(),Toast.LENGTH_LONG).show();
        }
    }
