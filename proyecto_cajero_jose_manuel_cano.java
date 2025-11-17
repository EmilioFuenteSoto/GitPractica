
import java.util.Scanner;

public class proyecto_cajero_jose_manuel_cano {

    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int opcion = 0;

        /*Bucle que va ejecutando todo el menú de la cajera. */

        while (opcion != 4) {
            System.out.println("");
            System.out.println("Bienvenido al cajero automatico");
            System.out.println("1.Consultar saldo");
            System.out.println("2.Depositar dinero");
            System.out.println("3.Retirar Dinero");
            System.out.println("4.Salir");
            System.out.println("");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    consultar_saldo();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Introduce cuanto dinero quieres ingresar");
                    double ingresar_dinero = Double.parseDouble(sc.nextLine());
                    double ingreso = depositar_dinero(ingresar_dinero);
                    System.out.println("");
                    System.out.println("Has ingresado en el cajero: "+ingresar_dinero+"€");
                    System.out.println("");
                    //System.out.println("El saldo actual es: "+saldo);
                    break;
                case 3:
                System.out.println("");
                    System.out.println("Introduce cuanto dinero quieres retirar");
                    double retirada_de_dinero = Double.parseDouble(sc.nextLine());
                    double retirada = retirar_dinero(retirada_de_dinero);
                    //System.out.println("El saldo actual es: "+saldo);
                    break;

                case 4:
                    System.out.println("Has elegido salir del cajero muchas gracias por su participacion");
                    System.out.println("");
                    System.out.println("Estadisticas de uso");
                    System.out.println();
                    System.out.println("Numero total de ingresos " + numero_de_ingreso);
                    System.out.println("Importe total ingresado " + importe_ingresado+" €");
                    System.out.println("Numero total de retiradas " + numero_de_retirada);
                    System.out.println("Importe total retirado " + importe_total_retirado+" €");
                    System.out.println("Saldo final de la cuenta " + saldo + " €");
                    break;

                default:
                    System.out.println("Elige una opción valida");
            }
        }

    }

    //*Aquí declaro las variables locales */
    static double saldo = 0;
    static int numero_de_ingreso = 0;
    static int numero_de_retirada = 0;
    static double importe_ingresado = 0;
    static double importe_total_retirado = 0;

    /*Función que consulta el saldo disponible simplemente mostrando el valor de la variable saldo */
    public static void consultar_saldo() {
        System.out.println("");
        System.out.println("El saldo actual es: " + saldo +"€");

    }


    //*Función para hacer que el usuario pueda ingresar dinero en el saldo */
    /* Si el numero que introduce es negativo se le volvera a pedir el numero.
     * Lo que hace es coger el numero de dinero que quiere ingresar y lo sumamos al saldo.
     * luego sumo uno al contador para que en las estadisticas aparezca que ha hecho un ingreso.
     * y despúes para las estadisiticas simplemente mediante un acumulador vamos sumando todo lo que el usuario ingresa.
     */

    public static double depositar_dinero(double numero) {

        if (numero > 0) {
            saldo = saldo + numero;
            numero_de_ingreso++;
            importe_ingresado += numero;
        } else {
            System.out.println("Debes introducir un numero positivo");
        }

        return saldo;
    }

    /*
     * Función para retirar dinero no dejamos retirar si vemos que el saldo se queda a 0 o si quiere sacar mas dinero de lo que tiene disponible en el saldo.
     * controlamos que el numero que quiere retirar sea positivo si estas 3 condiciones se cumplen al saldo se le resta el numero que el introduce.
     * sumamos el numero al acumulador para que en las estadisiticas veamos el importe de lo que ha retirado.
     * y por ultimo le sumamos uno al contador que va sumando cuantas veces se retira dinero.
     */

    public static double retirar_dinero(double numero) {

        if (numero <= 0) {

            System.out.println("Tienes que introducir un numero positivo");

        } else if (numero > saldo) {
            System.out.println("El dinero que quieres rerirar no se puede sacar ya que es mas dinero de lo que hay disponible en el saldo");

        } else if(numero == saldo){
            System.out.println("No puedes quedar tu saldo a 0");
            System.out.println("Saldo actual disponible: " + saldo +"€");

        }else {
            saldo = saldo - numero;
            importe_total_retirado += numero;
            numero_de_retirada++;

        }

        return saldo;

    }

}
