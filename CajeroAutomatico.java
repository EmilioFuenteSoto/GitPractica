import java.util.Scanner;
import java.util.Random;

public class CajeroAutomatico {
    public static Scanner sc = new Scanner(System.in);
    public static float saldo = 0;
    public static int saldoInicial = 0;
    public static int nIngresos = 0;
    public static int nRetiradas = 0;
    public static int importeTotalR = 0;
    public static int importeTotalI = 0;
    public static void main(String[] args) throws Exception {

        
        MostrarMenuPrincipal();
    }
    public static void MostrarMenuPrincipal(){
        System.out.println("*________________________*");
        System.out.println("|                        |");
        System.out.println("| Bienvenido a BordeBank |");
        System.out.println("|                        |");
        System.out.println("|        ¬      ¬        |");
        System.out.println("|          ____          |");
        System.out.println("|________________________|");
        System.out.println("|                        |");
        System.out.println("|   1. Consultar Saldo   |");
        System.out.println("|   2. Depositar Dinero  |");
        System.out.println("|   3. Retirar Dinero    |");
        System.out.println("|   4. Salir             |");
        System.out.println("|________________________|\n");
        boolean encendido = true;
        while(encendido){
            System.out.print("Elige una opción de una vez: ");
        String opcion = "";
        int opcionSwitch = 0;

        opcion = sc.nextLine();
            try {
            opcionSwitch = Integer.parseInt(opcion.trim());
        } catch (NumberFormatException e) {
            System.out.println("Mira, encima de esas letras tienes números... Úsalos.");
            continue;
        }
        
            
            switch(opcionSwitch){
            case 1:
            ConsultarSaldo();
                break;
            case 2:
            DepositarDinero();
                break;
            case 3:
            RetirarDinero();
                break;
            case 4:
                Salir();
                encendido = false;
            break;
                default:
                System.out.println("Tío, una opción de las cuatro que hay");
                break;
        }

            
        }
        

        
          
    }

   
}
