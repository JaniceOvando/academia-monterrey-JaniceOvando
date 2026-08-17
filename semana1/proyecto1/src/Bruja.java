public class Bruja extends Enemigo {
    public Bruja(String nombre) {
        super(nombre, 70, 12);
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " lanza un hechizo oscuro...");
        mostrarAtaque(nombre, objetivo.getNombre(), dano);
        objetivo.recibirDano(dano);
    }
}
