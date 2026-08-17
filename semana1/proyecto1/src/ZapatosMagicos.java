// final: es un objeto unico, no tiene sentido que alguien herede de el.
public final class ZapatosMagicos extends Premio {

    private boolean activado;

    public ZapatosMagicos() {
        super("Zapatos Magicos", "Guardan un poder capaz de romper el hechizo del mago.");
        this.activado = false;
    }

    public void activarPoder() {
        activado = true;
        System.out.println("Los Zapatos Magicos brillan con un poder ancestral.");
    }
}
