package com.pp.demo.sesion6.boleto;

import java.util.Comparator;

public class ComparatorBoletosAciertos implements Comparator<Boleto> {

    @Override
    public int compare(Boleto b1, Boleto b2) {

        if (b2.getNumAciertos() > b1.getNumAciertos()) {return 1;}
        else if (b2.getNumAciertos() < b1.getNumAciertos()){return -1;}
        else return b1.getNumAciertosComplementario() - b2.getNumAciertosComplementario();
    }
}
