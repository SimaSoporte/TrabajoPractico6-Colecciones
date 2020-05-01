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
public class TP6DirectorioTelefonico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Directorio directorio = new Directorio();
        
        Cliente juan = new Cliente(12345678, "Juan", "Saez", "San Luis", "Pringles s/n");
        Cliente pedro = new Cliente(456, "Pedro", "Perez", "San Luis", "Lafinur 123");
        Cliente jose = new Cliente(789, "Jose", "Lopez", "Cordoba", "San Martin s/n");
        Cliente maria = new Cliente(111, "Maria", "Lopez", "Cordoba", "San Martin s/n");
        Cliente eduardo = new Cliente(87654321, "Eduardo", "Martin", "Cordoba", "San Martin s/n");
        
        directorio.agregarCliente(1234, juan);
        directorio.agregarCliente(456, jose);
        directorio.agregarCliente(789, juan);
        directorio.agregarCliente(5544, maria);
        directorio.agregarCliente(5544, eduardo);

        directorio.listarClientes();
        
        directorio.buscarCliente(1234);
        
        directorio.buscarTelefono("Lopez");
        
        directorio.buscarClientes("San Luis");
        
        directorio.borrarCliente(1234);
        
        directorio.listarClientes();
    }
    
}
