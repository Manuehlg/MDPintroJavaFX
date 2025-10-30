
package com.pp.demo.sesion5.boleto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Euromillon extends Boleto {

    // Euromillon: 5 números entre 1 y 49 y 2 complementarios entre 0 y 9

    private int complementario1, complementario2;

    public Euromillon(int identificador, LocalDate f) {
        super(identificador, f, 5, 49, 9);
    }

    public Euromillon(int identificador, LocalDate f, int c1, int c2) {
        super(identificador, f);
        this.complementario1 = c1;
        this.complementario2 = c2;
    }

    public int aciertoComplementarios(Boleto b) {
        if (b instanceof Euromillon) {
            Euromillon otro = (Euromillon) b;
            int aciertos = 0;
            if (this.complementario1 == otro.complementario1)
                aciertos++;
            if (this.complementario2 == otro.complementario2)
                aciertos++;
            if (this.complementario1 == otro.complementario2)
                aciertos++;
            if (this.complementario2 == otro.complementario1)
                aciertos++;
            numAciertosComplementario = aciertos;
            return aciertos;
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
        this.complementario1 = r.nextInt(maxComplementario);
        this.complementario2 = r.nextInt(maxComplementario);
        return true;
    }

    public int getComplementario1() {
        return complementario1;
    }

    public void setComplementario1(int complementario1) {
        this.complementario1 = complementario1;
    }

    public int getComplementario2() {
        return complementario2;
    }

    public void setComplementario2(int complementario2) {
        this.complementario2 = complementario2;
    }

    @Override
    public String toString() {
        return "Euromillon [identificador=" + identificador + ", complementario1=" + complementario1
                + ", complementario2=" + complementario2 + ", numeros=" + numeros
                + "]";
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
