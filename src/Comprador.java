public class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        this.vuelto = 0;

        Bebida b = exp.comprarBebida(m, cualBebida);

        if (b != null) {
            this.sonido = b.beber();
        } else {
            this.sonido = null;
        }

        Moneda monedaVuelto = exp.getVuelto();
        while (monedaVuelto != null) {
            this.vuelto += monedaVuelto.getValor();
            monedaVuelto = exp.getVuelto();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }
}