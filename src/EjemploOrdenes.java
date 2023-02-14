import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class EjemploOrdenes {

    public static Cliente ingresandoNombreApellido(){
        Scanner scNA = new Scanner(System.in);

        String nombreCliente, apellidoCliente;
        System.out.print("Nombre del cliente: ");
        nombreCliente = scNA.next();

        System.out.print("Apellido del cliente: ");
        apellidoCliente = scNA.next();
        return new Cliente(nombreCliente,apellidoCliente);
    }

    public static String ingresandoDetalles(boolean seguir){
        String answer = "";
        Scanner scDet = new Scanner(System.in);
        while(seguir) {
            System.out.println("¿Desea ingresar alguna descripcion o nota para su orden de compra? (s/n)");
            answer = scDet.next().toLowerCase();

            if (!answer.equals("s") && !answer.equals("n")) {
                System.out.println("Ingreso una respuesta incorrecta");
            }else seguir = false;
        }

        if(answer.equals("s"))
        {
            System.out.print("Ingrese la descripcion:");
            return scDet.next();
        }else return "Null";
    }

    public static Date ingresandoFecha(boolean seguir) {
        Scanner scDate = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = null;
        while (seguir) {
            System.out.println("Fecha de la compra (dd-mm-yyyy)");
            try {
                fecha = format.parse(scDate.next());
                seguir = false;
            } catch (ParseException e) {
                System.err.println("Ingreso un formato de fecha incorrecto");
            } catch (NullPointerException e) {
                System.err.println("No puede quedar vacío este campo, ingrese un dato");
            }
        }
        return fecha;
    }

    public static Producto ingresandoProductos(boolean seguir) {
        String precioString;
        int precioInt = 0;
        Scanner scf = new Scanner(System.in);
        Scanner scp = new Scanner(System.in);
        Scanner scprecio = new Scanner(System.in);

        System.out.print("Fabricante: ");
        String fabricante = scf.next();

        System.out.print("Nombre: ");
        String nombreProd = scp.next();

        while (seguir) {
            System.out.print("Precio: ");
            precioString = scprecio.next();
            try {
                precioInt = Integer.parseInt(precioString);
                seguir = false;
            } catch (Exception e) {
                System.err.println("No ingreso un entero " + e);
            }
        }
        return new Producto(fabricante, nombreProd, precioInt);
    }

    public static void main(String[] args) {

        OrdenCompra[] ordenCompra = new OrdenCompra[3];
        int cantProductos = 4;

        for (int i = 0; i < ordenCompra.length; i++) {
            ordenCompra[i] = new OrdenCompra();
            ordenCompra[i].setCliente(ingresandoNombreApellido());

            boolean seguir = true;

            ordenCompra[i].setDescripcion(ingresandoDetalles(seguir));

            ordenCompra[i].setFecha(ingresandoFecha(seguir));


            for (int j = 0; j < cantProductos; j++) {
                System.out.println((j+1) + "º producto: ");
                ordenCompra[i].addProductos(ingresandoProductos(seguir));
            }
            System.out.println("\n");

        }


    }
}
