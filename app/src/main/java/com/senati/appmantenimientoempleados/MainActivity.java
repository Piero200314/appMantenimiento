package com.senati.appmantenimientoempleados;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txtCodigo, txtNombre, txtCelular, txtSueldo, txtDni;
    private MaterialButton btnGrabar;
    private RecyclerView recyclerEmpleados;

    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private EmpleadoAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos las vistas
        txtCodigo  = findViewById(R.id.txtCodigo);
        txtNombre  = findViewById(R.id.txtNombre);
        txtCelular = findViewById(R.id.txtCelular);
        txtSueldo  = findViewById(R.id.txtSueldo);
        txtDni     = findViewById(R.id.txtDni);
        btnGrabar  = findViewById(R.id.btnGrabar);
        recyclerEmpleados = findViewById(R.id.recyclerEmpleados);

        // Cargamos los 10 empleados de ejemplo
        cargarEmpleadosIniciales();

        // Configuramos el RecyclerView
        adaptador = new EmpleadoAdapter(listaEmpleados);
        recyclerEmpleados.setLayoutManager(new LinearLayoutManager(this));
        recyclerEmpleados.setAdapter(adaptador);

        // Botón Grabar
        btnGrabar.setOnClickListener(v -> {
            String codigo  = txtCodigo.getText().toString();
            String nombre  = txtNombre.getText().toString();
            String celular = txtCelular.getText().toString();
            String sueldoStr = txtSueldo.getText().toString();
            String dni     = txtDni.getText().toString();

            if (codigo.isEmpty() || nombre.isEmpty() || celular.isEmpty() || sueldoStr.isEmpty() || dni.isEmpty()) {
                Toast.makeText(MainActivity.this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            double sueldo = Double.parseDouble(sueldoStr);
            Empleado emp = new Empleado(codigo, nombre, celular, sueldo, dni);
            listaEmpleados.add(emp);
            adaptador.notifyItemInserted(listaEmpleados.size() - 1);

            // Limpiar campos
            txtCodigo.setText("");
            txtNombre.setText("");
            txtCelular.setText("");
            txtSueldo.setText("");
            txtDni.setText("");
            txtCodigo.requestFocus();

            Toast.makeText(MainActivity.this, "Empleado grabado", Toast.LENGTH_SHORT).show();
        });
    }

    private void cargarEmpleadosIniciales() {
        listaEmpleados.add(new Empleado("1", "Pepe Ramírez", "988888888", 1200.0, "42388551"));
        listaEmpleados.add(new Empleado("2", "María Torres", "945880000", 700.0, "55855582"));
        listaEmpleados.add(new Empleado("3", "Juan Quispe", "954888800", 950.0, "45522223"));
        listaEmpleados.add(new Empleado("4", "Ana Flores", "912345678", 1500.0, "70123456"));
        listaEmpleados.add(new Empleado("5", "Carlos Vega", "923456789", 1100.0, "71234567"));
        listaEmpleados.add(new Empleado("6", "Lucía Rojas", "934567890", 1350.0, "72345678"));
        listaEmpleados.add(new Empleado("7", "Miguel Soto", "945678901", 980.0, "73456789"));
        listaEmpleados.add(new Empleado("8", "Elena Paredes", "956789012", 1600.0, "74567890"));
        listaEmpleados.add(new Empleado("9", "Diego Cruz", "967890123", 1050.0, "75678901"));
        listaEmpleados.add(new Empleado("10", "Sofía Mendoza", "978901234", 1250.0, "76789012"));
    }
}