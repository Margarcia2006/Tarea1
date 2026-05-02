public class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "fanta";
    }
}