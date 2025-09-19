import java.util.Queue;
import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);
    public void Menuturnos() {
        Queue<ObjCliente> turno = new java.util.LinkedList<>();
        Metodos m = new Metodos();
        int opt = 0;
        boolean bandera = true;
        while (bandera) {
            System.out.println("-----Menu Turnos-----");
            System.out.println("1. Agregar Turno");
            System.out.println("2. Ver Turnos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opt = m.Validarentero(sc);
            sc.nextLine();
            boolean rango = m.Validarrango(opt);
            if (!rango) {
                System.out.println("Por favor ingrese una opcion valida");
                continue;
            }
            switch (opt) {
                case 1:
                    System.out.println("Agregar Turno seleccionado.");
                    turno.offer(m.Tomarturno());
                    break;
                case 2:
                    System.out.println("Ver Turnos seleccionado.");
                    m.Mostrarturno(turno);
                    break;
                case 3:
                    System.out.println("Saliendo del menú de turnos.");
                    bandera = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            
        }
    }

    public int Validarentero(Scanner sc){
        int num = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese numeros enteros.");
            sc.next();
        }
        num = sc.nextInt();
        return num;
    }

    public int Validarcedula(Scanner sc){
        int num = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese su cédula en números enteros: ");
            sc.next();
        }
        num = sc.nextInt();
        return num;
    }

public String Validarstring(Scanner sc){
    String texto = "";
    do {
        texto = sc.nextLine().trim();
        if (texto.isEmpty()) {
            System.out.println("Por favor ingrese un texto válido (no puede estar vacío).");
        } else if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Por favor ingrese solo letras y espacios.");
            texto = ""; // Reinicia para que vuelva a pedir
        }
    } while (texto.isEmpty());
    return texto;
}

    public boolean Validarrango(int num){
        if (num < 1 || num > 3) {
            return false;
        }
        return true;
    }

    public ObjCliente Tomarturno(){
        Metodos m = new Metodos();
        ObjCliente cliente = new ObjCliente();
        System.out.print("Ingrese su cédula: ");
        cliente.setCedula(m.Validarcedula(sc));
        System.out.print("Ingrese su nombre: ");
        cliente.setNombre(m.Validarstring(sc));
        return cliente;
    }

    public void Mostrarturno(Queue<ObjCliente> cola){
        int contador = 1;
        if (cola.isEmpty()) {
            System.out.println("No hay turnos en la cola.");
            return;
        }
        System.out.println("Turnos en la cola:");
        for (ObjCliente cliente : cola) {
            System.out.println("Posición " + (contador++) + ":");
            System.out.println("Cédula: " + cliente.getCedula());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("-------------------");
        }
    }
}
