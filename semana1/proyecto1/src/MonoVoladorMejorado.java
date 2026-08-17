// "final class" = nadie puede heredar de esta clase, es la version definitiva del mono.
// Es una MEJORA del MonoVolador normal -> aqui se ve POLIMORFISMO:
// el mismo metodo atacar() se comporta distinto segun la clase real del objeto.
public final class MonoVoladorMejorado extends MonoVolador {

    public MonoVoladorMejorado(String nombre) {
        super(nombre);
        // Mejoramos las estadisticas heredadas del mono normal
        this.vida = 60;
        this.vidaMaxima = 60;
        this.dano = this.dano + 6; // mas dano que el mono del nivel 1
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " ataca en picada desde el aire...");
        super.atacar(objetivo); // reutiliza el ataque normal del mono, ya con las stats mejoradas
    }
}
