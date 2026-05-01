public enum Inventario {
    COCA_COLA(1000),
    SPRITE(1000),
    FANTA(1000),
    SNICKERS(800),
    SUPER8(600);

    private final int precio;
    Inventario(int precio){
        this.precio=precio;
    }

    public int getPrecio() {
        return precio;
    }
}
