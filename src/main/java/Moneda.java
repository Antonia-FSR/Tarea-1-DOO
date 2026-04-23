public abstract class Moneda implements Comparable<Moneda> {
    public Moneda(){


    }
    public abstract int getValor();
    public String toString() {
        return "Moneda (Serie: " + this.hashCode() + ") Valor: $" + this.getValor();
    }
    public int compareTo(Moneda otraMoneda) {
        // Compara los valores de menor a mayor
        return Integer.compare(this.getValor(), otraMoneda.getValor());
    }
}
