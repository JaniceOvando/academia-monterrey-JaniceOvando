// MonoVolador IS-A Enemigo IS-A Personaje
public class MonoVolador extends Enemigo {

    public MonoVolador(String nombre) {
        super(nombre, 40, 8); // 40 de vida, 8 de daño
    }

    // Aqui SI implementamos atacar(), porque MonoVolador no es abstracta.
    @Override
    public void atacar(Personaje objetivo) {
        mostrarAtaque(nombre, objetivo.getNombre(), dano);
        objetivo.recibirDano(dano);
    }
}
