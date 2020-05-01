/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.directoriotelefonico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author HP
 */
public class Directorio {
    private TreeMap<Integer, Cliente> dir = new TreeMap<>();
    
    public void agregarCliente(Integer telefono, Cliente cliente) {
        if ( dir.putIfAbsent(telefono, cliente) == null ) {
            System.out.println("Cliente agregado." + cliente.getNombre()+ " " + cliente.getApellido() );
        } else {
            System.out.println("El cliente " + cliente.getApellido() + " " + cliente.getNombre() + " NO se pudo agregar. El Telefono " + telefono +" ya existe en el directorio !!!" );
        }
    }
    
    public Cliente buscarCliente(Integer telefono) {
        System.out.println("\nTELEFONO BUSCADO: " + telefono);
        if ( dir.get(telefono) != null )
            System.out.println("El telefono buscado " + telefono + " pertenece a: " + dir.get(telefono).getNombre() + " " + dir.get(telefono).getApellido());
        else
            System.out.println("Cliente NO encontrado. " + telefono);
        return dir.get(telefono);
    }
    
    public Set<Integer> buscarTelefono(String apellido) {
        HashSet<Integer> telefonos = new HashSet<>();
        System.out.println("\nAPELLIDO BUSCADO: " + apellido);
        Set s = dir.keySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Integer tel = (Integer)it.next();
            Cliente cli = dir.get(tel);
            if (cli.getApellido().equals(apellido)) {
                telefonos.add(tel);
                System.out.println(cli.getNombre() + " " + cli.getApellido() + " Telefono: " + tel);
            }
        }
        System.out.println("Registros econtrados: " + telefonos.size());
        return telefonos;
    }
    
    public List<Cliente> buscarClientes(String ciudad) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        System.out.println("\nCLIENTES DE LA CIUDAD DE: " + ciudad);
        Set s = dir.keySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Integer tel = (Integer)it.next();
            Cliente cli = dir.get(tel);
            if (cli.getCiudad().equalsIgnoreCase(ciudad)) {
                clientes.add(cli);
                System.out.println( cli.getApellido()+ " " + cli.getNombre()+ " - " + cli.getCiudad() + ", " + cli.getDireccion() + " - Telefono: " + tel);
            }
        }
        return clientes;
    }
    
    public void borrarCliente(Integer telefono) {
        System.out.println("\nTELEFNO A BORRAR: " + telefono);
        boolean econtrado = false;
        Set s = dir.keySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Integer tel = (Integer)it.next();
            if ( tel.equals(telefono))
                econtrado = true;
        }
        if ( econtrado) {
            dir.remove(telefono);
            System.out.println("Telefono borrado: " + telefono);
        }
        else
            System.out.println("Telefono NO borrado porque no se encontro.");
    }
    
    /**
     * Lista los clientes ordenados alfabeticamente. Para ordenarlos se itera
     * sobre la lista original y se genera un TreeMap donde la clave esta formada
     * por la concatenacion de apellido+nombre+ciudad+direccion+telefono. Al 
     * incluir el telefono se garantiza que las claves no estaran duplicadas.
     */
    public void listarClientes() {
        TreeMap<String, Integer> lista = new TreeMap<>();
        
        System.out.println("\nLISTADO DE CLIENTES");
        Set s = dir.keySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Integer tel = (Integer)it.next();
            Cliente cli = dir.get(tel);
            lista.put(cli.getApellido()+ " " + cli.getNombre()+ " - " + cli.getCiudad() + ", " + cli.getDireccion() + " - Telefono: " + tel, cli.getDni());
        }
        s = lista.keySet();
        it = s.iterator();
        while (it.hasNext()) {
            String k = (String)it.next();
            System.out.println(k);
        }
        System.out.println("Registros econtrados: " + s.size());
    }
}
