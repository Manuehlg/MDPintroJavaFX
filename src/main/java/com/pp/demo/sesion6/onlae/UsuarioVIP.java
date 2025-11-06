
package com.pp.demo.sesion6.onlae;


import com.pp.demo.sesion6.boleto.Boleto;
import com.pp.demo.sesion6.boleto.Euromillon;
import com.pp.demo.sesion6.boleto.Gordo;
import com.pp.demo.sesion6.boleto.Primitiva;


public class UsuarioVIP extends Usuario {
    private String tarjetaCredito;

    public UsuarioVIP(String dni, String telefono, String nombre, String tarjetaCredito) {
        super(dni, telefono, nombre);
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }
	// Precio: Primitiva 1.5, Gordo 2.5, Euromillon 3.5
    @Override
    public boolean comprarBoleto(Boleto b) {
        
         // Actualizar dinero gastado
         // Precio: Primitiva 1.5, Gordo 2.5, Euromillon 3.5
         //Comprar el boleto
        boletosJugados.add(b); 
         // Actualizar dinero gastado (misma política que UsuarioVIP)   
        if (b.getClass().equals(Primitiva.class)) {
            dineroTotalGastado += 1.5F; 
        } else if (b.getClass().equals(Euromillon.class)) {
            dineroTotalGastado += 3.5; 
        } else  if (b.getClass().equals(Gordo.class)) {
            dineroTotalGastado += 2.5; 
        }
        
        return true;
    }
}
