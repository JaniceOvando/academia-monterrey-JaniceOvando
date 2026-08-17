public abstract class Nivel {

    protected int numero;
    protected String nombre;

    public Nivel(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public abstract void ejecutar(Dorotea dorotea);

    protected void mostrarEncabezado() {
        System.out.println("");
        System.out.println("---- NIVEL " + numero + ": " + nombre + " ----");
    }
}
