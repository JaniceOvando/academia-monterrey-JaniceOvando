public interface Atacable {

    void atacar(Personaje objetivo);

    default void mostrarAtaque(String nombreAtacante, String nombreDefensor, int dano) {
        System.out.println(nombreAtacante + " ataca a" + nombreDefensor + " y causa" + dano + " de dano.");
    }

    // Este metodo STATIC:le pertenece a la interfaz misma, no aun objeto.
    static int obtenerDanoBase() {
        return 10;
    }

}
