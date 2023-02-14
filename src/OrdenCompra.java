import java.util.Date;

public class OrdenCompra {
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private  Producto[] productos;
    private int precioFinal;

    private static int ultimoId;
    private int indiceProductos;

    public OrdenCompra(){
        this.id = ++ultimoId;
        this.productos = new Producto[4];
    }

    public OrdenCompra(String descripcion){
        this();
        this.descripcion = descripcion;
    }

    public Integer getId() { return id; }

    public String getDescripcion(){ return descripcion; }

    public Date getFecha(){ return fecha; }

    public void setFecha(Date fecha){ this.fecha = fecha; }

    public Cliente getCliente(){ return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void addProductos(Producto productos){
        if(indiceProductos < this.productos.length)
        {
            this.productos[indiceProductos++] = productos;
        }
    }

    public int getPrecioFinal(Producto[] productos){
        int precioTotal = 0;
        for(Producto i: productos){
            precioTotal += i.getPrecio();
        }
        return precioTotal;
    }


    public void verOrdenDeCompra(){

    }


}
