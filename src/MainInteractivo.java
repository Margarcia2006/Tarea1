import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {
        //se usa Scanner para capturar lo que el usuario escriba en la consola, haciendolo interactivo
        Scanner s = new Scanner(System.in);

        //aqui creamos la maquina con  de cada producto
        Expendedor exp = new Expendedor(5);

        System.out.println();

        while (true) {

            //aca definimos las posibles acciones como números para que sean mas faciles de registrar
            System.out.println("\n¿Que quieres hacer?");
            System.out.println("1 - comprar algo");
            System.out.println("2 - Apagar maquina");
            System.out.print("= ");

            //usamos nextInt para registrar la accion que se desea ejecutar
            int eleccion = s.nextInt();

            //si se ingresó 2, se ejecuta la accion de apagar la maquina
            if (eleccion == 2) {
                System.out.println("La maquina se apagará en 3...2...1.");
                System.out.println("Maquina apagada");
                break;
            }

            //se seleccionna la moneda
            System.out.println("\nSelecciona la moneda con la que deseas pagar:");
            System.out.println("1 - moneda de 100 $");
            System.out.println("2 - moneda 500 $");
            System.out.println("3 - moneda 1000 $");
            System.out.println("4 - otro pago no identificado");
            System.out.print("= ");
            int tipoMoneda = s.nextInt();

            Moneda m = null;
            if (tipoMoneda == 1) m = new Moneda100();
            else if (tipoMoneda == 2) m = new Moneda500();
            else if (tipoMoneda == 3) m = new Moneda1000();

            //se selecciona el producto usando el Catalogo
            System.out.println("\n¿Que buscas?");
            System.out.println("1 - Coca ($1000) ");
            System.out.println("2 - Sprite ($800) ");
            System.out.println("3 - Fanta ($700) ");

            System.out.println("4 - Snickers ($1500)");
            System.out.println("5 - Super8 ($500)");

            System.out.print("= ");
            int productoIn = s.nextInt();

            Catalogo seleccionado = null;
            switch (productoIn) {
                case 1: seleccionado = Catalogo.COCACOLA; break;
                case 2: seleccionado = Catalogo.SPRITE; break;
                case 3: seleccionado = Catalogo.FANTA; break;
                case 4: seleccionado = Catalogo.SNICKERS; break;
                case 5: seleccionado = Catalogo.SUPER8; break;
                default:
                    System.out.println("Opcion invalida.");
                    continue;
            }

            //se procesa la compra
            System.out.println("\nProcesando...");
            Comprador cliente = new Comprador(m, seleccionado, exp);

            // Resultados
            if (cliente.queConsumiste() != null) {
                System.out.println("Disfruta tu " + cliente.queConsumiste());
            }
            System.out.println("Vuelto recibido: " + cliente.cuantoVuelto());
        }

        s.close();
    }
}