//METODO IS-A Enemegio IS-A Personaje

public class Monovolador extends Enemigo{
    public Monovolador(String nombre){
        super(nombre, 40, 8); //aqui merengues es mi 40 de vida y 8 de dano
    }

    //por aqui, si implementamos atacar(), porque Don MONOVOLADOR es abstracta
    @Override
    public void atacar(Personaje objetivo){
        mostrarAtaque(nombre, objetivo.getNombre(), dano);
        objetivo.recibirDano(dano);
    }
}
