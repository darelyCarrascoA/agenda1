package itsco.edu.agenda1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtNombre;
    private TextView txtTelefono;
    private TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        txtNombre = (TextView)
                findViewById(R.id.txt_nombre);
        txtTelefono = (TextView)
                findViewById(R.id.txt_telefono);
        txtEmail = (TextView)
                findViewById(R.id.txt_email);
        txtNombre.setOnClickListener(this);
        txtTelefono.setOnClickListener(this);
        txtEmail.setOnClickListener(this);


        Intent data = getIntent();
        txtNombre.setText(data.getStringExtra("NOMBRE"));
        txtTelefono.setText(data.getStringExtra("TELEFONO"));
        txtEmail.setText(data.getStringExtra("EMAIL"));
    }

    @Override
    public void onClick(View v) {
        Intent myIntent;

        if (v.getId() == txtTelefono.getId()) {
            //invocar activities del sistema con un action.
            myIntent = new Intent(Intent.ACTION_DIAL);
            this.startActivity(myIntent);
        } else if (v.getId() == txtEmail.getId()) {
            //Permite invocar activities por su clase
            myIntent = new
                    Intent(Intent.ACTION_DIAL);
            this.startActivity(myIntent);

        } else if (v.getId() == txtNombre.getId()) {
            //Permite invocar activities por su clase
            myIntent = new
                    Intent(Intent.ACTION_DIAL);
            this.startActivity(myIntent);
        }
    }
}
