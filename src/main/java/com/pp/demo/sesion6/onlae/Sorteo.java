package com.pp.demo.sesion6.onlae;


import com.pp.demo.sesion6.boleto.Boleto;
import com.pp.demo.sesion6.boleto.Euromillon;
import com.pp.demo.sesion6.boleto.Gordo;
import com.pp.demo.sesion6.boleto.Primitiva;

import java.time.LocalDate;
import java.util.HashSet;



//TODO Implementar comparable para sorteo. 
public class Sorteo implements Comparable<Sorteo> {

	protected int id;
	protected LocalDate fecha;
	protected float recaudacion;
	protected boolean sorteado;
	protected HashSet<Boleto> boletos; // Importante: HashCode y Equals en Boleto
	protected Boleto combinacionGanadora;

	protected int tipo; 		// 0 Primitiva 1 Gordo 2 Euromillon

	public Sorteo(int id, LocalDate fecha, int tipo) {
		this.id = id;
		this.fecha = fecha;
		boletos = new HashSet<Boleto>();
		sorteado = false;
		this.recaudacion = 0.0f;
		this.combinacionGanadora = null;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(float recaudacion) {
		this.recaudacion = recaudacion;
	}

	public HashSet<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(HashSet<Boleto> boletos) {
		this.boletos = boletos;
	}

	public boolean addBoleto(Boleto b) {
		return this.boletos.add(b);
	}

	public Boleto getCombinacionGanadora() {
		return combinacionGanadora;
	}

	public void setCombinacionGanadora(Boleto combinacionGanadora) {
		this.combinacionGanadora = combinacionGanadora;
	}

	public boolean isSorteado() {
		return sorteado;
	}

	public void setSorteado(boolean sorteado) {
		this.sorteado = sorteado;
	}


	//TODO 
	// Tipo 0: Primitiva, Tipo 1: Gordo, Tipo 2: Euromillon
	// Precio: Primitiva 1.5, Gordo 2.5, Euromillon 3.5
	public boolean comprarBoleto(int tipo, Usuario u) {
		Boleto b = null;
		float precio = 0.0f;
//		El sorteo tiene un tipo y recibe un boleto de un tipo
//		Sino coincide, no se puede jugar

//		Dependiendo del tipo de boleto
//		Creo objeto del tipo indicado y anoto precio
//
//			Primitiva. Creo objeto y anoto precio
//
//			Gordo. Creo objeto y anoto precio
//
//			Euromillon. Creo objeto y anoto precio
//
//			Sino tipo no valido
//
		if (this.tipo==1 && this.tipo == tipo){
			b = new Primitiva(boletos.size()+1, LocalDate.now());
			precio += 1.5f;
		} else if (this.tipo==2 && this.tipo == tipo){
			b = new Euromillon(boletos.size()+1, LocalDate.now());
			precio += 3.5f;
		} else if (this.tipo==0 && this.tipo == tipo){
			b = new Gordo(boletos.size()+1, LocalDate.now());
			precio += 2.5f;
		}

//		Si el usuario ha podido comprar el boleto
//
//		Relleno de número el boleto
//
//		Lo añado a la lista
//
//		Incremento recaudación

		if (b != null) {
			if (u.comprarBoleto(b)) {

				b.rellenarNumerosAleatorios();
				this.boletos.add(b);
				this.recaudacion += precio;

				return true;
			}
		}
		return false;
	}

	public boolean sortear() {
		if (this.sorteado)
			return false;
		if (this.boletos.size() == 0)
			return false;		
		if (tipo==0) {
			this.combinacionGanadora = new Primitiva(0, LocalDate.now());
		} else if (tipo==1) {
			this.combinacionGanadora = new Gordo(0, LocalDate.now());
		} else if (tipo==2) {
			this.combinacionGanadora = new Euromillon(0, LocalDate.now());
		} else {
			return false;
		}
		this.combinacionGanadora.rellenarNumerosAleatorios();
		return sortear(combinacionGanadora);
	}

	public boolean sortear(Boleto b) {
		if (this.sorteado)
			return false;
		if (this.boletos.size() == 0)
			return false;
		this.combinacionGanadora = b;
		// Comprobar aciertos de todos los boletos
		for (Boleto b2 : this.boletos) {
			b2.aciertos(combinacionGanadora);
			b2.aciertoComplementarios(combinacionGanadora);
		}
		this.sorteado = true;
		return true;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Sorteo o) {
		return this.fecha.compareTo(o.fecha);
	}


	@Override
	public String toString() {
		return "Sorteo{" +
				"id=" + id +
				", fecha=" + fecha +
				", recaudacion=" + recaudacion +
				", sorteado=" + sorteado +
				", boletos=" + boletos +
				", combinacionGanadora=" + combinacionGanadora +
				", tipo=" + tipo +
				'}';
	}
}
