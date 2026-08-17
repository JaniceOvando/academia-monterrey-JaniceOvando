// Companero IS-A Premio
public class Companero extends Premio {

    private int bonusDano; // cuanto daño extra aporta en batalla

    public Companero(String nombre, String descripcion, int bonusDano) {
        super(nombre, descripcion);
        this.bonusDano = bonusDano;
    }

    public void ayudarEnBatalla(Personaje objetivo) {
        System.out.println(nombre + " ayuda en la batalla causando " + bonusDano + " de dano extra.");
        objetivo.recibirDano(bonusDano);
    }
}
