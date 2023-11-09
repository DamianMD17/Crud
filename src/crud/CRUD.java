/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

/**
 *
 * @author Fallas
 */
import crud.clases.Persona;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

    private static final String ARCHIVO_CONTACTOS = "PADRON_COMPLETO.txt";

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ContactoDAO contactoDAO = new ContactoDAO();
        ArrayList<Persona> contactos = contactoDAO.cargarContactos();

        while (true) {
            System.out.println("\n--- Gestión de Contactos ---");
            System.out.println("1. Lista de contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Actualizar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Buscar");
             System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de nextInt

            switch (opcion) {
                case 1:
                    contactoDAO.listaContactos(contactos);
                    break;
                case 2:
                    contactoDAO.agregarContacto(scanner, contactos);
                    break;
                case 3:
                    contactoDAO.actualizarContacto(scanner, contactos);
                    break;
                case 4:
                    contactoDAO.eliminarContacto(scanner, contactos);
                    break;
                case 5:
                    
                    String Codigos ="";
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Ingrese un codigo: ");
                    Codigos = entrada.nextLine();
                    Persona encontrado= contactoDAO.buscarContactoPorId(Codigos, contactos);
                    if(encontrado == null){
                        System.out.println("No existe");
                    }
                    else{
                       
                    }
                    break;
                case 6:
                    contactoDAO.guardarContactos(contactos);
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

   
}

