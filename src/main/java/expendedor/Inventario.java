package expendedor;

public enum Inventario {
    COCA_COLA(1000, 1),
    SPRITE(1000, 2),
    FANTA(1000, 3),
    SNICKERS(800, 4),
    SUPER8(600, 5);

    private final int precio;
    private final int seleccion;

    Inventario(int precio, int seleccion){

        this.precio=precio;
        this.seleccion=seleccion;
    }

    public int getPrecio() {
        return precio;
    }
    public int getSeleccion() {return seleccion;}
}
