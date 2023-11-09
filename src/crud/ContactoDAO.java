
package crud;

import crud.clases.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactoDAO {

    private static final String ARCHIVO_CONTACTOS = "distelec.txt";

    public ArrayList<Persona> cargarContactos() {
        ArrayList<Persona> contactos = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CONTACTOS));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(","); //Crea un String a partir de cada vez que encuentre una coma
                if (datos.length == 4) {
                    Persona contacto = new Persona(datos[0], datos[1], datos[2], datos[3]);
                    contactos.add(contacto);  //lo guarda en la lista
                }
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al cargar los contactos: " + e.getMessage());
        }

        return contactos;
    }

    public void guardarContactos(ArrayList<Persona> contactos) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CONTACTOS));

            for (Persona contacto : contactos) {
                String linea = contacto.getCodigo() + "," + contacto.getProvincia() + "," + contacto.getLugar() + "," + contacto.getDistrito();
                bw.write(linea); // escribir lo que tiene linea 
                bw.newLine();  // poner un enter (una nueva linea)
            }

            bw.close();  // guarda el archivo 
        } catch (IOException e) {
            System.err.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    public void listaContactos(ArrayList<Persona> contactos) {
        System.out.println("\n--- Lista de Contactos ---");

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos para mostrar.");
        } else {
            for (Persona contacto : contactos) {
                System.out.println("Código: " + contacto.getCodigo());
                System.out.println("Provincia: " + contacto.getProvincia());
                System.out.println("Lugar: " + contacto.getLugar());
                System.out.println("Distrito: " + contacto.getDistrito());
                System.out.println("------------------------");
            }
        }
    }

    public void agregarContacto(Scanner scanner, ArrayList<Persona> contactos) {
        System.out.println("\n--- Agregar Contacto ---");
        System.out.println("Código: ");
        String Codigo = scanner.nextLine();
        System.out.print("Provincia: ");
        String Provincia = scanner.nextLine();
        System.out.println("Lugar: ");
        String Lugar = scanner.nextLine();
        System.out.println("Distrito: ");
        String Distrito = scanner.nextLine();

        Persona nuevoContacto = new Persona(Codigo, Provincia, Lugar, Distrito);
        contactos.add(nuevoContacto);
        guardarContactos(contactos);
        System.out.println("Contacto agregado con éxito.");
    }

    public Persona buscarContactoPorId(String codigos, ArrayList<Persona> contactos) { //CAMBIAR
        for (Persona contacto : contactos) {
            if (contacto.getCodigo().equals(codigos)) {
                System.out.println("Encontrado");
                System.out.println("Código: " + contacto.getCodigo());
                System.out.println("Provincia: " + contacto.getProvincia());
                System.out.println("Lugar: " + contacto.getLugar());
                System.out.println("Distrito: " + contacto.getDistrito());
                System.out.println("------------------------");
                return contacto; // Devuelve el contacto si se encuentra
            }
        }
      
        return null; // Devuelve null si el contacto no se encuentra
    }

    public void actualizarContacto(Scanner scanner, ArrayList<Persona> contactos) {
        System.out.println("\n--- Actualizar Contacto ---");
        System.out.println("Ingresar nuevo Codigo");
        String Codigo = scanner.nextLine();
        Persona contactoActualizado = buscarContactoPorId(Codigo, contactos);

        if (contactoActualizado != null) {
            System.out.println("Código: ");
            String Codigos = scanner.nextLine();
            System.out.print("Provincia: ");
            String Provincia = scanner.nextLine();
            System.out.println("Lugar: ");
            String Lugar = scanner.nextLine();
            System.out.println("Distrito: ");
            String Distrito = scanner.nextLine();

            contactoActualizado.setCodigo(Codigos);
            contactoActualizado.setProvincia(Provincia);
            contactoActualizado.setLugar(Lugar);
            contactoActualizado.setDistrito(Distrito);

            System.out.println("Votante actualizado con éxito.");
        } else {
            System.out.println("Codigo no encontrado. No se pudo actualizar el contacto.");
        }
    }

    public void eliminarContacto(Scanner scanner, ArrayList<Persona> contactos) {
        System.out.println("\n--- Eliminar Contacto ---");
        System.out.println("Ingresar código");
        String Codigo = scanner.nextLine();
        Persona contactoActualizado = buscarContactoPorId(Codigo, contactos);
        if (contactoActualizado != null) {
            contactos.remove(Codigo);

            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("ID no encontrado. No se pudo eliminar el contacto.");
        }
        guardarContactos(contactos);

    }
}
