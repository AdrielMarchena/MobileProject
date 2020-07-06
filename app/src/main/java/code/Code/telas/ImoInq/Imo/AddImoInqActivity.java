package code.Code.telas.ImoInq.Imo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.profalexandre.Code.R;
import code.Code.dbs.ControllerImoInq;
import code.Code.modelos.ImoInqBean;

public class AddImoInqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_imoinq);
        final ControllerImoInq ge = new ControllerImoInq(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btnInserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText idImovel  = (EditText) findViewById(R.id.txtSelectImovel);
                EditText idInquilino  = (EditText) findViewById((R.id.txtSelectInquilino));
                EditText obs = (EditText) findViewById(R.id.txtSelectObs);

                String idImovelString = idImovel.getText().toString();
                String idInquilinoString = idInquilino.getText().toString();
                String obsString = obs.getText().toString();

                ImoInqBean imo = new ImoInqBean();
                imo.setId("");
                imo.setIdImovel(idImovelString);
                imo.setIdInquilino(idInquilinoString);
                imo.setObs(obsString);
                String msg = ge.inserir(imo);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
