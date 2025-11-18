import java.util.Scanner;

public class App {
    final static Scanner sc = new Scanner(System.in);
    static double saldo = 0;
    static int numIngresos = 0;
    static double totalIngresado = 0;
    static int numRetirados = 0;
    static double totalRetirado = 0;
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            System.out.println(ANSI_YELLOW +"---------------------------------");
            System.out.println(ANSI_YELLOW +"|" + ANSI_RED +"       Cajero Automático      "+ ANSI_YELLOW +" |");
            System.out.println("|                               |");
            System.out.println("---------------------------------");
            System.out.println(ANSI_YELLOW +"|" + ANSI_PURPLE +"       1. Consultar Saldo     "+ ANSI_YELLOW +" |");
            System.out.println(ANSI_YELLOW +"|" + ANSI_BLUE +"       2. Depositar Dinero    "+ ANSI_YELLOW +" |");
            System.out.println(ANSI_YELLOW +"|" + ANSI_GREEN +"       3. Retirar Dinero      "+ ANSI_YELLOW +" |");
            System.out.println(ANSI_YELLOW +"|" + ANSI_CYAN +"       4. Salir               "+ ANSI_YELLOW +" |");
            System.out.println("---------------------------------"+ ANSI_WHITE);
            System.out.println("Elija una opción :");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> ConsultarSaldo();
                case 2 -> DepositarDinero();
                case 3 -> RetirarDinero();
                case 4 -> Salir();
                default -> System.out.println("Opción no valida");
            }

        } while (opcion != 4);

    }

    public static void ConsultarSaldo() {
        System.out.println("Tú saldo es de " + saldo + " $ ");
    }

    public static void DepositarDinero() {
        double ingresar = 0;
        do {
            System.out.print("Dime la cantidad que quieres ingresar: ");
            ingresar = sc.nextDouble();

            if (ingresar <= 0) {
                System.out.println("La cantidad debe ser mayor que 0.");
            } else {
                saldo += ingresar;
                numIngresos++;
                totalIngresado += ingresar;
                System.out.println("La operacion de ingresar " + ingresar + "$ se a ejecutado correctamente.");
            }
        } while (ingresar <= 0);
    }

    public static void RetirarDinero() {
        System.out.print("Ingrese la cantidad que desea retirar: ");
        double retirar = sc.nextDouble();

        if (retirar <= 0) {
            System.out.println(" No puedes retirar una cantidad menor o igual a 0.");
        } else if (retirar > saldo) {
            System.out.println(" No tienes suficiente saldo para retirar " + retirar + "$");
        } else {
            saldo -= retirar;
            numRetirados++;
            totalRetirado += retirar;
            System.out.println("Has retirado " + retirar + "$  correctamente.");
        }
    }

    public static void Salir() {
        System.out.println("Gracias por usar el Cajero Automático. ¡Hasta luego!");
        System.out.println( ANSI_BLUE + "----------------ESTADÍSTICAS DE USO-----------------" + ANSI_WHITE);
        System.out.println(ANSI_RED +"Número de ingresos: " + numIngresos );
        System.out.println("Importe total ingresado: " + totalIngresado + "$");
        System.out.println(ANSI_GREEN + "Número de retiros: " + numRetirados);
        System.out.println("Importe total retirado: " + totalRetirado + "$");
        System.out.println(ANSI_PURPLE + "Saldo final: " + saldo + "$");
        System.out.println( ANSI_BLUE + "----------------------------------------------------" + ANSI_WHITE);

    }
}