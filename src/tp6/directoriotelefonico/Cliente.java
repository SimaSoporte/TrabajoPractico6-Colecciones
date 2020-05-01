/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.directoriotelefonico;

/**
 *
 * @author HP
 */
public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;

    public Cliente(int dni, String nombre, String apellido, String ciudad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public int getDni() { return dni; }
    public String getNombre() {  return nombre; }
    public String getApellido() { return apellido; }
    public String getCiudad() { return ciudad; }
    public String getDireccion() { return direccion; }

    @Override
    public boolean equals(Object o) {
        if ( o !=null && o instanceof Cliente) {
            Cliente cli = (Cliente)o;
            if ( this.dni == cli.dni ) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return dni;
    }
    
}
