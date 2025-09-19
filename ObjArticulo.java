public class ObjArticulo {
    private int Id;
    private String Nombre;
    private String Categoria;
    private String Existencia;
    private double Precio;
    private int Estado; // 0: activo, 1: inactivo

    public ObjArticulo(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getExistencia() {
        return Existencia;
    }

    public void setExistencia(String existencia) {
        Existencia = existencia;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    
}
