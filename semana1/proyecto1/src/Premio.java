// Otra clase abstracta, separada de Personaje, solo para las recompensas del juego.
public abstract class Premio {

    protected String nombre;
    protected String descripcion;

    public Premio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
