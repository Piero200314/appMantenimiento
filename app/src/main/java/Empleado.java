package com.senati.materialdesing;

public class Empleado {
    private String codigo;
    private String nombre;
    private String celular;
    private double sueldo;
    private String dni;

    public Empleado(String codigo, String nombre, String celular, double sueldo, String dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.celular = celular;
        this.sueldo = sueldo;
        this.dni = dni;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCelular() { return celular; }
    public double getSueldo() { return sueldo; }
    public String getDni() { return dni; }
}