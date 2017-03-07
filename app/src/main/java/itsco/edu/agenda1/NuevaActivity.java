package itsco.edu.agenda1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevaActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button btnOk;
    private Button btnCancelar;

    private EditText txtNombre;
    private EditText txtTelefono;
    private EditText txtEmail;

    @Override
    public void onClick(View v) {
        if(v.getId()==btnOk.getId()){
            Intent data = getIntent();

            Tarea t = new Tarea();
            t.setNombre(txtNombre.getText().toString());
            // data.putExtra("TITULO",
            //   txtTitulo.getText().toString());
            t.setTelefono(txtTelefono.getText().toString());
            t.setEmail(txtEmail.getText().toString());
            //aunque se devuelva en el main no se
            //utiliza ya que la lista solo muestra un
            //valor
            // data.putExtra("DESC",
            // txtDescripcion.getText().toString());
            //  data.putExtra("FECHA",
            //        txtFecha.getText().toString());
            data.putExtra("TAREA",t);

            setResult(RESULT_OK,data);
        }
        if(v.getId()==btnCancelar.getId()){
            setResult(RESULT_CANCELED);

        }
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);
        btnCancelar = (Button)
                findViewById(R.id.btn_cancelar);
        btnOk = (Button)
                findViewById(R.id.btn_Ok);
        btnOk.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        txtNombre = (EditText)
                findViewById(R.id.txt_nombre);
        txtTelefono = (EditText)
                findViewById(R.id.txt_telefono);
        txtEmail = (EditText)
                findViewById(R.id.txt_email);
    }
    }
