package tallerweb.sangucheto.modelo;

public class Ingrediente {

    private String nombre;
    private Double precio;
    private TipoIngrediente tipo;

    /*
     * Este constructor lo agregu� yo, no es original del TP. Lo consult� con el profe antes de hacerlo. Me di� el Ok.
     * 
     */
    public Ingrediente(String nombre, Double precio, TipoIngrediente tipo) {
    	this.nombre = nombre;
    	this.precio = precio;
    	this.tipo = tipo;
    }
    
    public Ingrediente() {}
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public TipoIngrediente getTipo() {
        return tipo;
    }
    public void setTipo(TipoIngrediente tipo) {
        this.tipo = tipo;
    }
}
