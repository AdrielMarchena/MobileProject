package code.Code.telas.Inq.Inq;

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
import code.Code.dbs.ControllerInquilino;
import code.Code.modelos.InquilinoBean;

import java.util.List;

public class ListInqParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeInquilino;
    List<InquilinoBean> inquilinos;
    Button pesqInq;
    ArrayAdapter<InquilinoBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_inquilino_param);
        final Context con = getBaseContext();
        final ControllerInquilino ge = new ControllerInquilino(con);
        ListaDeInquilino = (ListView) findViewById(R.id.listInquilinos);
        ListaDeInquilino.setOnItemClickListener(this); // Clique no item
        ListaDeInquilino.setOnItemLongClickListener(this); //
        final EditText inquilino = (EditText)findViewById(R.id.txtPesquisaNome);

        pesqInq = (Button) findViewById(R.id.btnPesquisar);
        pesqInq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String inquilinoString = inquilino.getText().toString();
                InquilinoBean inq = new InquilinoBean();
                inq.setNome(inquilinoString);
                inquilinos = ge.listarInquilinos(inq);
                adapter = new ArrayAdapter<InquilinoBean>(con,android.R.layout.simple_list_item_1,inquilinos);
                ListaDeInquilino.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        InquilinoBean inq = (InquilinoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListInqParamActivity.this, UptInqActivity.class);
        it.putExtra("Inquilino",inq);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + inq.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        InquilinoBean inq = (InquilinoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListInqParamActivity.this, UptInqActivity.class);
        it.putExtra("Inquilino",inq);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + inq.getId(),Toast.LENGTH_LONG).show();
    }
}