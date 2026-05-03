import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Probando el ordenamiento de monedas (de menor a mayor)
        ArrayList<Moneda> listaMonedas = new ArrayList<>();
        listaMonedas.add(new Moneda500());
        listaMonedas.add(new Moneda100());
        listaMonedas.add(new Moneda1000());
        listaMonedas.add(new Moneda100());

        System.out.println("Monedas antes de ordenar:");
        for (Moneda m : listaMonedas) {
            System.out.println(m.toString());
        }

        //requisito de la tarea, "Para ordernar en el main, deben usar el sort disponible en ArrayList"
        Collections.sort(listaMonedas);

        System.out.println("Monedas ordenadas:");
        for (Moneda m : listaMonedas) {
            System.out.println(m.toString());
        }

        System.out.println("\n");

        //prueba del funcionamiento del Expendedor y Comprador
        Expendedor exp = new Expendedor(3); // 3 unidades por producto para probar

        //prueba compra normal
        System.out.println("Caso 1: Compra normal (Fanta con 1000)");
        Comprador c1 = new Comprador(new Moneda1000(), Catalogo.FANTA, exp);
        System.out.println("consumio: " + c1.queConsumiste() + " | vuelto: " + c1.cuantoVuelto());

        //prueba compra con el error de pago insuficiente
        System.out.println("\nCaso 2: Pago insuficiente");
        Comprador c2 = new Comprador(new Moneda500(), Catalogo.COCACOLA, exp);
        System.out.println("consumio: " + c2.queConsumiste() + " | vuelto: " + c2.cuantoVuelto());

        //prueba compra con el error de pago incorrecto
        System.out.println("\nCaso 3: Moneda nula");
        Comprador c3 = new Comprador(null, Catalogo.SPRITE, exp);
        System.out.println("consumio: " + c3.queConsumiste() + " | vuelto: " + c3.cuantoVuelto());

        //prueba compra con el error de no hay producto
        System.out.println("\nCaso 4: Falta de stock");
        for (int i = 0; i < 4; i++) {
            Comprador c4 = new Comprador(new Moneda1000(), Catalogo.SPRITE, exp);
            System.out.println("Intento " + (i + 1) + " -> consumio: " + c4.queConsumiste() + " | vuelto: " + c4.cuantoVuelto());
        }
    }
}