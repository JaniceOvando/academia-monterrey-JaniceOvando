public class Main {
    public static void main(String[] args) {

        Dorotea dorotea = new Dorotea("Dorotea");
        Juego juego = Juego.getInstance();

        // Nivel 1: mono volador -> recompensa: zapatos magicos
        juego.agregarNivel(new NivelCombate(
                1, "El Mono Volador",
                new MonoVolador("Mono Volador"),
                new ZapatosMagicos()
        ));

        // Nivel 2: bruja -> recompensa: companero Soldado de Plomo
        juego.agregarNivel(new NivelCombate(
                2, "La Bruja de Plata",
                new Bruja("Bruja de Plata"),
                new Companero("Soldado de Plomo", "Un soldado de hojalata con un hacha filosa.", 8)
        ));

        // Nivel 3: mono volador mejorado -> recompensa: companero Leon Cobarde
        juego.agregarNivel(new NivelCombate(
                3, "El Mono Volador Mejorado",
                new MonoVoladorMejorado("Mono Volador Mejorado"),
                new Companero("Leon Cobarde", "Un leon que busca valentia.", 10)
        ));

        // Nivel 4: bruja mejorada -> recompensa: companero Hombre de Paja
        juego.agregarNivel(new NivelCombate(
                4, "La Bruja Esmeralda",
                new BrujaMejorada("Bruja Esmeralda"),
                new Companero("Hombre de Paja", "Busca un cerebro, pero siempre tiene ideas.", 12)
        ));

        // Nivel 5: liberar la Ciudad Esmeralda (sin combate)
        juego.agregarNivel(new NivelFinal(5, "La Ciudad Esmeralda"));

        juego.iniciar(dorotea);
    }
}
