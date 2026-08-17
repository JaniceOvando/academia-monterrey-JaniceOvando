//extends Personaje es igual a enemigo IS-A Personaje (osea un enemigo ES UN Personaje pues

public abstract  class Enemigo extends Personaje {
    protected  int dano;

//static: aqui, doña variable es UNA SOLA y la comparten TODOS los enemigos malos, malvados del jueguito
    protected static int totalDerrotados = 0;

    public Enemigo(String nombre, int vidaMaxima, int dano){
        super(nombre, vidaMaxima);
        this.dano = dano;
    }

    public final void derrotar(){
        totalDerrotados = totalDerrotados + 1;
        System.out.println(nombre + " ha sido derrotado.");
    }

    public static int getTotalDerrotados(){
        return totalDerrotados;
    }
}
