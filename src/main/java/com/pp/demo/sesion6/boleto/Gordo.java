
package com.pp.demo.sesion6.boleto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Gordo extends Boleto {

    // Gordo: 5 números entre 1 y 54 y 1 complementario entre 0 y 9

    private int complementario;

    public Gordo(int identificador, LocalDate f) {
        super(identificador, f, 5, 54, 9);
    }

    public Gordo(int identificador, LocalDate f, int complementario) {
        super(identificador, f, 5, 54, 9);
        this.complementario = complementario;
    }

    public int aciertoComplementarios(Boleto b) {
        if (b instanceof Gordo) {
            Gordo otro = (Gordo) b;
            if (this.complementario == otro.complementario) {
                numAciertosComplementario = 1;
                return 1;
            } else
                return 0;
        }
        return 0;
    }

    public boolean rellenarNumerosAleatorios() {
        Random r = new Random(new Date().getTime());
        while (this.numeros.size() != cantidadNumeros) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

            this.numeros.add(r.nextInt(maxNumero) + 1);
        }
        this.complementario = r.nextInt(maxComplementario);
        return true;
    }

    public int getComplementario() {
        return complementario;
    }

    public void setComplementario(int complementario) {
        this.complementario = complementario;
    }

    @Override
    public String toString() {
        return "Gordo [identificador=" + identificador + ", complementario=" + complementario + ", numeros=" + numeros
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}