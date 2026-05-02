public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;

    public Expendedor(int cantidad, int precio) {
        this.precio = precio;
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        monVu = new Deposito<Moneda>();

        for (int i = 0; i < cantidad; i++) {
            coca.add(new CocaCola(100 + i));
            sprite.add(new Sprite(200 + i));
        }
    }

    public Bebida comprarBebida(Moneda m, int j) {
        if (m == null) {
            return null;
        }

        if (m.getValor() >= precio) {
            Bebida b = null;

            switch(j) {
                case 1:
                    b = coca.get();
                    break;
                case 2:
                    b = sprite.get();
                    break;
            }

            if (b != null) {
                int vuelto = m.getValor() - precio;
                while (vuelto > 0) {
                    monVu.add(new Moneda100());
                    vuelto -= 100;
                }
                return b;
            } else {
                monVu.add(m);
                return null;
            }
        } else {
            monVu.add(m);
            return null;
        }
    }

    public Moneda getVuelto() {
        return monVu.get();
    }
}