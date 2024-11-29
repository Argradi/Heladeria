package com.ariofrio.heladeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private Spinner spin;
private EditText chocolate,vainilla,fresa;
private Button btn;
    String cadena1;
    String cadena2;
    String cadena3;
    String cadena4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spin=findViewById(R.id.spinner);
        chocolate=findViewById(R.id.choc);
        vainilla=findViewById(R.id.vani);
        fresa=findViewById(R.id.fres);

        btn=findViewById(R.id.boton);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.elementos, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adaptador);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadena1=chocolate.getText().toString();
                cadena2=vainilla.getText().toString();
                cadena3=fresa.getText().toString();
                Intent intent = new Intent(MainActivity.this, Activity2.class);

                intent.putExtra("chocolate",cadena1);
                intent.putExtra("vainilla",cadena2);
                intent.putExtra("fresa",cadena3);
                intent.putExtra("eleccion",cadena4);
                startActivity(intent);
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cadena4=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}