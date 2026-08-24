package com.senati.appmantenimientoempleados;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder> {

    private List<Empleado> listaEmpleados;

    public EmpleadoAdapter(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
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
        holder.txtDatosItem.setText("Cel: " + emp.getCelular() + " - DNI: " + emp.getDni());
        holder.txtSueldoItem.setText("S/. " + emp.getSueldo());
    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public static class EmpleadoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgEmpleado;
        TextView txtNombreItem, txtDatosItem,