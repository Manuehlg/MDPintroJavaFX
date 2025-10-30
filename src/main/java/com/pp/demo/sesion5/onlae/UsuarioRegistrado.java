
package com.pp.demo.sesion5.onlae;


import com.pp.demo.sesion5.boleto.*;


public class UsuarioRegistrado extends Usuario {
    private float bolsa;

    public UsuarioRegistrado(String dni, String telefono, String nombre, float bolsa) {
        super(dni, telefono, nombre);
        this.bolsa = bolsa;
    }

    public float getBolsa() {
        return bolsa;
    }

    //TODO
	// Precio: Primitiva 1.5, Gordo 2.5, Euromillon 3.5
    @Override
    public boolean comprarBoleto(Boleto b) {
        float costoBoleto = 0;

//        Dependiendo del tipo de Boleto anoto el precio del boleto
        if (b instanceof Primitiva){
            costoBoleto = 1.5f;
        } else if (b instanceof Gordo){
            costoBoleto = 2.5f;
        } else if (b instanceof Euromillon){
            costoBoleto = 3.5f;
        }

//        Dependiendo del tipo de Boleto anoto el precio del boleto
//
//        Si tengo suficiente dinero en la bolsa
//
//        Añado el boleto a los boletos jugados del jugador
//
//        Incremento el dinero gastado del usuario
//
//        Decremento la bolsa y devuelvo verdaderoº

        if (costoBoleto <= bolsa){
            this.getBoletosJugados().add(b);
            this.dineroTotalGastado += costoBoleto;
            this.bolsa -= costoBoleto;
            return true;
        }


        
        return false;
    }
}
