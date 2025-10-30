
package com.pp.demo.sesion5.onlae;


import com.pp.demo.sesion5.boleto.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeSet;


public class Onlae {
    private HashMap<String, Usuario> usuarios;
    private TreeSet<Sorteo> sorteos; // Debe implementar Comparable en Sorteo

    public Onlae() {
        usuarios = new HashMap<>();
        sorteos = new TreeSet<>();
    }

    public void crearDatosEjemplo() {
        // Crear 5 usuarios de ejemplo
        usuarios.put("111A", new UsuarioRegistrado("111A", "600111111", "Ana", 144.5F));
        usuarios.put("222B", new UsuarioVIP("222B", "600222222", "Luis", "1234-5678-9012-3456"));
        usuarios.put("333C", new UsuarioRegistrado("333C", "600333333", "Marta", 500));
        usuarios.put("444D", new UsuarioVIP("444D", "600444444", "Pedro", "2345-6789-0123-4567"));
        usuarios.put("555E", new UsuarioRegistrado("555E", "600555555", "Lucía", 2000));

        // Crear 5 sorteos de ejemplo
        Sorteo s1 = new Sorteo(1, LocalDate.of(2025, 9, 22), 0);
        Sorteo s2 = new Sorteo(2, LocalDate.of(2025, 9, 23), 1);
        Sorteo s3 = new Sorteo(3, LocalDate.of(2025, 9, 24), 2);
        Sorteo s4 = new Sorteo(4, LocalDate.of(2025, 9, 25), 0);
        Sorteo s5 = new Sorteo(5, LocalDate.of(2025, 9, 26), 0);
        sorteos.add(s1);
        sorteos.add(s2);
        sorteos.add(s3);
        sorteos.add(s4);
        sorteos.add(s5);

        // Asignar algunos boletos de ejemplo
        // Comprar 5 boletos por cada sorteo con usuarios distintos. Deben ser del mismo
        // tipo para el mismo sorteo. Usar el método jugarSorteo de Onlae para
        // centralizar la lógica.
        jugarSorteo("111A", s1.getFecha(), 0); // Primitiva
        jugarSorteo("222B", s1.getFecha(), 0);
        jugarSorteo("333C", s1.getFecha(), 0);
        jugarSorteo("444D", s1.getFecha(), 0);
        jugarSorteo("555E", s1.getFecha(), 0);

        jugarSorteo("111A", s2.getFecha(), 1); // Gordo
        jugarSorteo("222B", s2.getFecha(), 1);
        jugarSorteo("333C", s2.getFecha(), 1);
        jugarSorteo("444D", s2.getFecha(), 1);
        jugarSorteo("555E", s2.getFecha(), 1);

        jugarSorteo("111A", s3.getFecha(), 2); // Euromillon
        jugarSorteo("222B", s3.getFecha(), 2);
        jugarSorteo("333C", s3.getFecha(), 2);
        jugarSorteo("444D", s3.getFecha(), 2);
        jugarSorteo("555E", s3.getFecha(), 2);

        jugarSorteo("111A", s4.getFecha(), 0); // Primitiva
        jugarSorteo("222B", s4.getFecha(), 0);
        jugarSorteo("333C", s4.getFecha(), 0);
        jugarSorteo("444D", s4.getFecha(), 0);
        jugarSorteo("555E", s4.getFecha(), 0);

        jugarSorteo("111A", s5.getFecha(), 0); // Primitiva
        jugarSorteo("222B", s5.getFecha(), 0);
        jugarSorteo("333C", s5.getFecha(), 0);
        jugarSorteo("444D", s5.getFecha(), 0);
        jugarSorteo("555E", s5.getFecha(), 0);
    }

    // TODO
    public Usuario buscarUsuario(String dni) {
        if ( usuarios.containsKey(dni)){
            return usuarios.get(dni);

        }
        return null;
    }

    // TODO
    public Sorteo buscarSorteo(LocalDate fecha) {
        for ( Sorteo s : sorteos){
            if (s.getFecha()== fecha){
                return s;
            }
        }
        return null;
    }

    // TODO
    // Tipo 0 es usuarioVIP 1 es usuarioRegistrado
    public boolean registrarUsuario(String dni, String tel, String nombre, String derivada, int tipo) {
        Usuario usuario = null;

        if ( tipo == 0){
            usuario = new UsuarioVIP(dni,tel,nombre,derivada);
            usuarios.put(dni, usuario);
            return true;
        } else if ( tipo == 1){
            usuario = new UsuarioRegistrado(dni,tel,nombre, Float.parseFloat(derivada));
            usuarios.put(dni, usuario);
            return true;
        }
       return false;
    }

    // TODO
    public boolean crearSorteo(int identificador, LocalDate fecha, int tipo) {

        if (buscarSorteo(fecha) == null){
            Sorteo s = new Sorteo(identificador,fecha,tipo);
            sorteos.add(s);
            return true;
        }
        return false;
    }

    // metodo para comprar un boleto
    // PARTICIPAR SORTEO
    // TODO
    public boolean jugarSorteo(String dni, LocalDate fechaSorteo, int tipoBoleto) {


        Usuario u = buscarUsuario(dni);
        Sorteo s = buscarSorteo(fechaSorteo);

        if (u != null  && s !=null) {
            s.comprarBoleto(tipoBoleto, u);
            return true;

        }


        return false;

    }

    //TODO
    public boolean sortearSorteo(LocalDate fecha) {
        Sorteo s = buscarSorteo(fecha);
        if (s != null) {
            return s.sortear();
        }
        return false;
    }

    //TODO
    public int contarRecaudacionPrimitiva(){
        int total = 0;
        for (Sorteo s : sorteos) {
            if (s.getTipo() == 0) {
                total += s.getRecaudacion();
            }
        }
        return (int) total;
    }

    public int contarBoletosTodosUsuarios(){
        int total = 0;
        for (Usuario u : usuarios.values()) {
            total += u.getBoletosJugados().size();
        }
        return total;
    }


    //TODO
    public double mediaBoletosUsuario(){
        if (usuarios.isEmpty()){
            return 0;
        }

        double totalBoletos = contarBoletosTodosUsuarios();
        return totalBoletos / usuarios.size();
    }


    public boolean sortearSorteoCombinacion(LocalDate fecha, Boleto ganador) {
        Sorteo s = buscarSorteo(fecha);
        if (s == null)
            return false;
        return s.sortear(ganador);
    }


    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public TreeSet<Sorteo> getSorteos() {
        return sorteos;
    }

    public void setSorteos(TreeSet<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }

}
