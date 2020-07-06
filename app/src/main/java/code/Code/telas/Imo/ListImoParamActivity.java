package code.Code.telas.Imo;

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

import com.example.profalexandre.Code.R;
import code.Code.dbs.ControllerImovel;
import code.Code.modelos.ImovelBean;

import java.util.List;

public class ListImoParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeImovel;
    List<ImovelBean> imoveis;
    Button pesqImo;
    ArrayAdapter<ImovelBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_imovel_param);
        final Context con = getBaseContext();
        final ControllerImovel ge = new ControllerImovel(con);
        ListaDeImovel = (ListView) findViewById(R.id.listImoveis);
        ListaDeImovel.setOnItemClickListener(this); // Clique no item
        ListaDeImovel.setOnItemLongClickListener(this); //
        final EditText proprietario = (EditText)findViewById(R.id.txtProprietario);

        pesqImo = (Button) findViewById(R.id.btnPesquisar);
        pesqImo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String proprietarioString = proprietario.getText().toString();
                ImovelBean imo = new ImovelBean();
                imo.setProprietario(proprietarioString);
                imoveis = ge.listarImoveis(imo);
                adapter = new ArrayAdapter<ImovelBean>(con,android.R.layout.simple_list_item_1,imoveis);
                ListaDeImovel.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        ImovelBean imo = (ImovelBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListImoParamActivity.this, UptImoActivity.class);
        it.putExtra("Imovel",imo);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + imo.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        ImovelBean imo = (ImovelBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListImoParamActivity.this, UptImoActivity.class);
        it.putExtra("Usuario",imo);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + imo.getId(),Toast.LENGTH_LONG).show();
    }
}