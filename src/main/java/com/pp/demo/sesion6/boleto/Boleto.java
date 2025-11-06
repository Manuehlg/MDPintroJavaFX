package com.pp.demo.sesion6.boleto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Boleto implements Comparable<Boleto> {
    protected int identificador; // Identificador del boleto
    protected double premio; // Premio asociado al boleto
    protected LocalDate fecha; // Fecha del boleto
    protected List<Integer> numeros; // Números jugados en el boleto
    protected boolean jugado; // Determina si el boleto ya ha sido jugado

    protected int cantidadNumeros; // Se fijan en el constructor CD
    protected int maxNumero; // Se fijan en el constructor CD
    protected int maxComplementario; // Se fijan en el constructor CD

    protected int numAciertos; // Se fijan al comparar con el boleto ganador
    protected int numAciertosComplementario; // Se fijan al comparar con el boleto ganador

    public int aciertos(Boleto b) {
        List<Integer> copia = new ArrayList<>(numeros);
        copia.retainAll(b.getNumeros());
        numAciertos = copia.size();
        return numAciertos;
    }

    public abstract int aciertoComplementarios(Boleto b);

    public abstract boolean rellenarNumerosAleatorios();

    public Boleto(int identificador, LocalDate f, int cant, int maxN, int maxC) {
        this.identificador = identificador;
        fecha = f;
        jugado = false;
        this.numeros = new ArrayList<>();
        this.cantidadNumeros = cant;
        this.maxNumero = maxN;
        this.maxComplementario = maxC;
    }

    public Boleto(int identificador, LocalDate f) {
        this.identificador = identificador;
        fecha = f;
        jugado = false;
        this.numeros = new ArrayList<>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public String toString() {
        return "Boleto [identificador=" + identificador + ", Fecha=" + fecha + "]";
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public int getCantidadNumeros() {
        return cantidadNumeros;
    }

    public void setCantidadNumeros(int cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
    }

    public int getMaxNumero() {
        return maxNumero;
    }

    public void setMaxNumero(int maxNumero) {
        this.maxNumero = maxNumero;
    }

    public int getMaxComplementario() {
        return maxComplementario;
    }

    public void setMaxComplementario(int maxComplementario) {
        this.maxComplementario = maxComplementario;
    }

    public int getNumAciertos() {
        return numAciertos;
    }

    public void setNumAciertos(int numAciertos) {
        this.numAciertos = numAciertos;
    }

    public int getNumAciertosComplementario() {
        return numAciertosComplementario;
    }

    public void setNumAciertosComplementario(int numAciertosComplementario) {
        this.numAciertosComplementario = numAciertosComplementario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + identificador;
        // result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        // result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Boleto other = (Boleto) obj;
        if (this.hashCode() != other.hashCode())
            return false;
        if (identificador != other.identificador)
            return false;
        /*
         * if (fecha == null) {
         * if (other.fecha != null)
         * return false;
         * } else if (!fecha.equals(other.fecha))
         * return false;
         * 
         * if (numeros == null) {
         * if (other.numeros != null)
         * return false;
         * } else if (!numeros.equals(other.numeros))
         * return false;
         */
        return true;
    }

    @Override
    public int compareTo(Boleto o) {
        return this.identificador - o.identificador;
    }
}