package itsco.edu.agenda1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static final int NUEVA_TAREA = 10;

    private Button btnAgregar;
    private ListView lista;

    private ArrayList<Tarea> data;
    private ArrayAdapter<Tarea> adapter;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,NuevaActivity.class);
        startActivityForResult(i,NUEVA_TAREA);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView,
                            View view, int i, long l) {

        Tarea t = data.get(i);

        Intent intent = new Intent(this,
                DetalleActivity.class);

        intent.putExtra("NOMBRE",t.getNombre());
        intent.putExtra("TELEFONO",t.getTelefono());
        intent.putExtra("EMAIL",t.getEmail());

        startActivity(intent);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregar=(Button)findViewById(R.id.btn_agregar);
        btnAgregar.setOnClickListener(this);


        lista=(ListView)findViewById(R.id.lista_agenda);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, data );
        //agrego el adapter a la lista
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

    }


    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode,
                resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==NUEVA_TAREA){

                Tarea t=data.getParcelableExtra("TAREA");
                this.data.add(t);

                //Cuando un datasource se actualiza
                //el adapter debe notificar cambios
                //con el metodo notifyDataSetChanged
                adapter.notifyDataSetChanged();
            }
        }
    }
}
