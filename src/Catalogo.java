public enum Catalogo {
    COCACOLA(1000),
    SPRITE(800),
    FANTA(700),
    SNICKERS(1500),
    SUPER8(500);

    private final int precio;

    Catalogo(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}