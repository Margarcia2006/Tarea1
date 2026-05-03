public abstract class Moneda implements Comparable<Moneda> {

    public Moneda() {
    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();

    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }

    @Override
    public String toString() {
        return "Moneda de " + this.getValor() + " - Serie: " + super.toString();
    }
}