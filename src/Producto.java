public class Producto {

    private String fabricante;
    private String nombre;
    private int precio;


    public Producto(String fabricante){ this.fabricante = fabricante;}

    public Producto(String fabricante, String nombre){
        this(fabricante);
        this.nombre = nombre;
    }

    public Producto(String fabricante, String nombre, int precio){
        this(fabricante,nombre);
        this.precio = precio;
    }

    public int getPrecio(){ return this.precio;}

    public String getFabricante(){ return this.fabricante;}

    public String getNombre(){ return this.nombre;}


}
