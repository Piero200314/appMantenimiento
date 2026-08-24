package com.senati.appmantenimientoempleados;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder> {

    private List<Empleado> listaEmpleados;
    private OnEliminarClickListener listener;

    public interface OnEliminarClickListener {
        void onEliminarClick(int position);
    }

    public EmpleadoAdapter(List<Empleado> listaEmpleados, OnEliminarClickListener listener) {
        this.listaEmpleados = listaEmpleados;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_empleado, parent, false);
        return new EmpleadoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {
        Empleado emp = listaEmpleados.get(position);

        holder.txtNombreItem.setText(emp.getNombre());
        holder.txtDatosItem.setText("Cód: " + emp.getCodigo() + " - Cel: " + emp.getCelular() + " - DNI: " + emp.getDni());
        holder.txtSueldoItem.setText("S/. " + emp.getSueldo());

        holder.btnEliminar.setOnClickListener(v ->
                listener.onEliminarClick(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public static class EmpleadoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgEmpleado;
        TextView txtNombreItem, txtDatosItem, txtSueldoItem;
        ImageButton btnEliminar;

        public EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgEmpleado = itemView.findViewById(R.id.imgEmpleado);
            txtNombreItem = itemView.findViewById(R.id.txtNombreItem);
            txtDatosItem = itemView.findViewById(R.id.txtDatosItem);
            txtSueldoItem = itemView.findViewById(R.id.txtSueldoItem);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}