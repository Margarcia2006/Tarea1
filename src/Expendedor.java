public class Expendedor {

    //creamos los depositos para cada producto y un deposito para el vuelto
    private Deposito<Bebida> depCoca;
    private Deposito<Bebida> depSprite;
    private Deposito<Bebida> depFanta;
    private Deposito<Dulce> depSnickers;
    private Deposito<Dulce> depSuper8;
    private Deposito<Moneda> depMonedasVuelto;

    //el constructor inicializa los depositos
    public Expendedor(int cantidad) {
        depCoca = new Deposito<>();
        depSprite = new Deposito<>();
        depFanta = new Deposito<>();
        depSnickers = new Deposito<>();
        depSuper8 = new Deposito<>();
        depMonedasVuelto = new Deposito<>();

        //usando "cantidad", se le asigna un número de serie que sea único a cada deposito y se rellena la cantidad de productos especificada
        for (int i = 0; i < cantidad; i++) {
            depCoca.add(new CocaCola(100 + i));
            depSprite.add(new Sprite(200 + i));
            depFanta.add(new Fanta(300 + i));
            depSnickers.add(new Snickers(400 + i));
            depSuper8.add(new Super8(500 + i));
        }
    }

    //aquí creamos el metodo que simula las compras, usando un if para ver cuando hay que usar cada exception que creamos como clases
    public Producto comprarProducto(Moneda m, Catalogo tipo) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        //caso de pago incorrecto
        if (m == null) {
            throw new PagoIncorrectoException("Error: Se intentó pagar con una moneda nula.");
        }

        int precioProducto = tipo.getPrecio();

        //caso de pago insuficiente
        if (m.getValor() < precioProducto) {
            depMonedasVuelto.add(m);
            throw new PagoInsuficienteException("Error: El pago es insuficiente para comprar " + tipo.name());
        }

        //usamos el catalogo para sacar el producto correspondiente
        Producto p = null;
        switch (tipo) {
            case COCACOLA:
                p = depCoca.get();
                break;
            case SPRITE:
                p = depSprite.get();
                break;
            case FANTA:
                p = depFanta.get();
                break;
            case SNICKERS:
                p = depSnickers.get();
                break;
            case SUPER8:
                p = depSuper8.get();
                break;
        }


        //caso de que no quede el producto que estamos pidiendo
        if (p == null) {
            depMonedasVuelto.add(m);
            throw new NoHayProductoException("Error: No queda stock de " + tipo.name());
        }


        //aqui calculamos el vuelto
        int vuelto = m.getValor() - precioProducto;


        //generamos el vuelto en monedas de 100
        while (vuelto > 0) {
            depMonedasVuelto.add(new Moneda100());
            vuelto -= 100;
        }



        return p;
    }

    //se entrega el vuelto
    public Moneda getVuelto() {
        return depMonedasVuelto.get();
    }
}