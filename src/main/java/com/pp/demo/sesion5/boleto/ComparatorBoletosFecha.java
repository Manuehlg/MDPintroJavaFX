package com.pp.demo.sesion5.boleto;

import java.util.Comparator;

public class ComparatorBoletosFecha implements Comparator<Boleto> {
    @Override
    public int compare(Boleto b1, Boleto b2) {
        return b1.getFecha().compareTo(b2.getFecha());
    }
}