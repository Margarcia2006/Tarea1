public class Comprador {

    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, Catalogo tipo, Expendedor exp) {
        this.vuelto = 0;

        //primero intentamos comprar
        try {
            Producto p = exp.comprarProducto(m, tipo);
            this.sonido = p.consumir();

        //si nos aparece un error, lo imprimimos
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            System.out.println(e.getMessage());
            this.sonido = null; // No hay producto que consumir

        //independiente si falló o no, se nos devuelve el vuelto moneda por moneda
        } finally {
            Moneda monedaVuelto = exp.getVuelto();
            while (monedaVuelto != null) {
                this.vuelto += monedaVuelto.getValor();
                monedaVuelto = exp.getVuelto();
            }
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queConsumiste() {
        return sonido;
    }
}