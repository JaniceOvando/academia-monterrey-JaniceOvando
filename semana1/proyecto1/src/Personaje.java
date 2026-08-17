//Uso mi clase abstracta: Donde no se puede hacer "new Personaje()" directamente.
//Sirve solo como base para que otras clases hereden de ella (Dorothy y Enemigo).

public abstract class Personaje implements Atacable {

    protected String nombre;
    protected int vida;
    protected int vidaMaxima;

    public Personaje(String nombre, int vidaMaxima) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
    }

//Uso mi metodo "FINAL": este metodo ya no puede modificarse o sobreescribirse en ninguna clase hija.
//Todos los personajes reciben dano excatamente de la misma forma.

    public final void recibirDano(int dano) {
        vida = vida - dano;
        if (vida < 0) {
            vida = 0;
        }
        System.out.println(nombre + " queda con " + vida + "/" + vidaMaxima + " de vida.");
    }

    // Tambien "final": curarse funciona igual para todos.
    public final void curar(int cantidad) {
        vida = vida + cantidad;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }
        System.out.println(nombre + " descansa y recupera vida: " + vida + "/" + vidaMaxima);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    }
