
package com.pp.demo.sesion6.onlae;


import com.pp.demo.sesion6.boleto.Boleto;

import java.util.ArrayList;
import java.util.List;


public abstract class Usuario {
    protected String dni;
    protected String telefono;
    protected String nombre;
    protected double dineroTotalGastado;
    protected List<Boleto> boletosJugados;

    public abstract boolean comprarBoleto(Boleto b);

    public Usuario(String dni, String telefono, String nombre) {
        this.dni = dni;
        this.telefono = telefono;
        this.nombre = nombre;
        this.dineroTotalGastado = 0;
        this.boletosJugados = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDineroGastado() {
        return dineroTotalGastado;
    }

    public List<Boleto> getBoletosJugados() {
        return boletosJugados;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDineroTotalGastado() {
        return dineroTotalGastado;
    }

    public void setDineroTotalGastado(double dineroTotalGastado) {
        this.dineroTotalGastado = dineroTotalGastado;
    }

    public void setBoletosJugados(List<Boleto> boletosJugados) {
        this.boletosJugados = boletosJugados;
    }
}
