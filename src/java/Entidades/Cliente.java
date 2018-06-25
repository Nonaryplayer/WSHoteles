/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Duoc
 */
public class Cliente {
    private String rut,nombre,direccion;
    private int numero;
    public String getNombre;
    public String getDireccion;
    public int getNumero;
    public String getRut;

    public Cliente() {
    }

    public Cliente(String rut, String nombre, String direccion, int numero) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    private Habitacion habitacion;
    
}
