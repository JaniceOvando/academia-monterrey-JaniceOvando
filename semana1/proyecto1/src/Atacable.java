// Esto es una INTERFAZ de Java (no tiene nada que ver con ventanas ni botones).
// Es solo una lista de metodos que toda clase que la "implemente" esta OBLIGADA a tener.
public interface Atacable {

    // Método abstracto: no tiene cuerpo aquí, cada clase decide cómo atacar.
    void atacar(Personaje objetivo);

    // Método "default": SÍ tiene cuerpo, y las clases lo heredan ya hecho, sin escribirlo.
    default void mostrarAtaque(String nombreAtacante, String nombreDefensor, int dano) {
        System.out.println(nombreAtacante + " ataca a " + nombreDefensor + " y causa " + dano + " de dano.");
    }

    // Método "static": pertenece a la interfaz misma, no a un objeto.
    // Se llama asi: Atacable.obtenerDanoBase()
    static int obtenerDanoBase() {
        return 10;
    }
}