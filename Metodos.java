import java.util.Queue;
import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);
    Queue<ObjCliente> catendido = new java.util.LinkedList<>();

    public void Menuturnos() {
        Queue<ObjCliente> turno = new java.util.LinkedList<>();
        Metodos m = new Metodos();
        int opt = 0;
        boolean bandera = true;
        while (bandera) {
            System.out.println("-----Menu Turnos-----");
            System.out.println("1. Agregar Turno");
            System.out.println("2. Ver Turnos");
            System.out.println("3. Atender Cliente");
            System.out.println("4. Salir");
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
                    System.out.println("Atender Cliente seleccionado.");
                    if (!turno.isEmpty()) {
                        m.Menuatencioncliente(turno);
                    } else {
                        System.out.println("No hay clientes en espera.");
                    }
                    break;
                case 4:
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
        if (num < 1 || num > 4) {
            return false;
        }
        return true;
    }

    public boolean Validarrangoarticulo(int num){
        if (num < 1 || num > 5) {
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

    public Queue<ObjCliente> Atendercliente(Queue<ObjCliente> cola){
        if (cola.isEmpty()) {
            System.out.println("No hay clientes en la cola para atender.");
            return cola;
        }
        System.out.println("el siguiente cliente en la cola es: " + cola.peek().getNombre());
        System.out.println("con cédula: " + cola.peek().getCedula());
        catendido.offer(cola.remove());
        return cola;
    }

    public void Menuatencioncliente(Queue<ObjCliente> turno){
        Queue<ObjArticulo> articulos = new java.util.LinkedList<>();
        Metodos m = new Metodos();
        int opt = 0;
        boolean bandera = true;
        turno =m.Atendercliente(turno);
        while (bandera) {
            System.out.println("-----Menu Atencion Cliente-----");
            System.out.println("1. Ingrese los articulos del cliente");
            System.out.println("2. remover ultimo articulo");
            System.out.println("3. valor total de la compra");
            System.out.println("4. salir sin comprar artuculos");
            System.out.println("5. salir y finalizar compra");
            System.out.print("Seleccione una opcion: ");
            opt = m.Validarentero(sc);
            sc.nextLine();
            boolean rango = m.Validarrangoarticulo(opt);
            if (!rango) {
                System.out.println("Por favor ingrese una opcion valida");
                continue;
            }
            switch (opt) {
                case 1:
                    System.out.println("Ingrese los articulos del cliente seleccionado.");
                    articulos.offer(m.Creararticulo());
                    break;
                case 2:
                    System.out.println("Articulo removido.");
                    m.Removerultimoarticulo(articulos);
                    break;
                case 3:
                    System.out.println("Articulos en la bolsa y valor total.");
                    m.Mostrararticulos(articulos);
                    break;
                case 4:
                    System.out.println("Salir sin comprar articulos.");
                    m.Vaciararticulos(articulos);
                    bandera = false;
                    break;
                case 5:
                    System.out.println("Saliendo del menú de turnos.");
                    m.Comprafinalizada(articulos);
                    bandera = false;
                    break;
                default:
                    System.out.println("saliendo del menú de articulos." );
            }
        }
    }

    public ObjArticulo Creararticulo(){
        Metodos m = new Metodos();
        ObjArticulo articulo = new ObjArticulo();
        System.out.println("ingrese el ID del articulo: ");
        articulo.setId(m.Validarentero(sc));
        System.out.print("Ingrese el nombre del articulo: ");
        articulo.setNombre(m.Validarstring(sc));
        System.out.print("Ingrese la categoria del articulo: ");
        articulo.setCategoria(m.Validarstring(sc));
        System.out.print("Ingrese la existencia del articulo: ");
        articulo.setExistencia(m.Validarstring(sc));
        System.out.print("Ingrese el precio del articulo: ");
        articulo.setPrecio(m.Validarentero(sc));
        articulo.setEstado(0);  
        return articulo;
    }

    public void Removerultimoarticulo(Queue<ObjArticulo> articulos){
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos para remover.");
            return;
        }
        ObjArticulo ultimoArticulo = null;
        for (ObjArticulo articulo : articulos) {
            ultimoArticulo = articulo;
        }
        if (ultimoArticulo != null) {
            articulos.remove(ultimoArticulo);
            System.out.println("Artículo removido: " + ultimoArticulo.getNombre());
        }
    }

    public double calcularValorTotal(Queue<ObjArticulo> articulos) {
        double total = 0.0;
        for (ObjArticulo articulo : articulos) {
            total += articulo.getPrecio();
        }
        return total;
    }

    public void Mostrararticulos(Queue<ObjArticulo> articulos){
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos en la bolsa.");
            return;
        }
        System.out.println("Artículos en la bolsa:");
        for (ObjArticulo articulo : articulos) {
            System.out.println("ID: " + articulo.getId());
            System.out.println("Nombre: " + articulo.getNombre());
            System.out.println("Categoría: " + articulo.getCategoria());
            System.out.println("Existencia: " + articulo.getExistencia());
            System.out.println("Precio: " + articulo.getPrecio());
            System.out.println("-------------------");
        }
        System.out.println("Valor total de la compra: " + calcularValorTotal(articulos));
    }

    public void Vaciararticulos(Queue<ObjArticulo> articulos){
        articulos.clear();
        System.out.println("La bolsa de artículos ha sido vaciada.");
    }

    public void Comprafinalizada(Queue<ObjArticulo> articulos){
        articulos.clear();
        System.out.println("Compra finalizada. Gracias por su compra.");
    }
}
