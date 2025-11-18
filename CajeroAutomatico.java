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

    public static void ConsultarSaldo(){
        if(saldo < 1000)
        {
            System.out.println("Tu saldo es de: " + saldo + "$" + "\nvaya pobre...");
        }
        else{
            System.out.println("Tu saldo es de: " + saldo + "$" + "\n... No está mal");
        }
        sc.nextLine();
        MostrarMenuPrincipal();
        
    }
    public static void DepositarDinero(){
        System.out.println("La mejor parte, ¿Cuánto dinero me vas a dar?");
        while (true) {
        
        String entrada = sc.nextLine();

        float dineroDepositar;

        try {
            dineroDepositar = Float.parseFloat(entrada.trim());
        } catch (NumberFormatException e) {
            System.out.println("Mira, encima de esas letras tienes números... Úsalos.");
            continue;
        }


        if (dineroDepositar <= 0) {
            System.out.println("Si claro, te doy " + dineroDepositar + " euros... pero tu eres tonto?\nDime algo válido, hombre.");
            continue;
        }


        if (dineroDepositar <= 100) {
            System.out.println("... Para eso no me des nada, en fin");
        } else if (dineroDepositar > 110) {
            Random random = new Random();
            int frase = random.nextInt(3) + 1;
            switch (frase) {
                case 1:
                    System.out.println("Perfecto, hoy como caliente");
                    break;
                case 2:
                    System.out.println("¿Pero tú de dónde has sacado ese dinero?");
                    break;
                case 3:
                    System.out.println("Eso eso, tú déjame ese dinerito a mí que ya yo te lo gestiono");
                    break;
            }
        }

        System.out.println("Bueno, el caso: has depositado " + dineroDepositar);
        sc.nextLine();
        saldo += dineroDepositar;
        importeTotalI += dineroDepositar;
        nIngresos++;

        MostrarMenuPrincipal();

        break;
    }

        

    }

    public static void RetirarDinero(){
        System.out.println("Dime cuanto dinero me vas a quitar: ");
        while(true){
            String entrada = sc.nextLine();

            float dineroRetirar;

        try {
            dineroRetirar = Float.parseFloat(entrada.trim());
        } catch (NumberFormatException e) {
            System.out.println("Mira, encima de esas letras tienes números... Úsalos.");
            continue;
        }


        if (dineroRetirar < 0) {
            System.out.println("A ver, por mi bien, pero no puedes llevarte " + dineroRetirar + " euros...\nDime algo válido, hombre.");
            continue;
        }
        else if(dineroRetirar == 0)
        {
            System.out.println("Lo tomaré como un 'Soy pobre, sácame de aquí'");
            sc.nextLine();
            MostrarMenuPrincipal();
        }




        if(dineroRetirar <=saldo){
             if (dineroRetirar <= 100) {
            System.out.println("... Bueno, tampoco es tanto");
            } else if (dineroRetirar > 100) {
            Random random = new Random();
            int frase = random.nextInt(3) + 1;
            switch (frase) {
                case 1:
                    System.out.println("Ahí te pudras");
                    break;
                case 2:
                    System.out.println("A ti te tengo que dar todo ese dinero?");
                    break;
                case 3:
                    System.out.println("adios a los " + dineroRetirar + " euros... Los echaré de menos");
                    break;
            }
        }
            System.out.println("En fin... \nToma tu sucio dinero");
            saldo -= dineroRetirar;
            nRetiradas++;
            importeTotalR += dineroRetirar;
        }else{
            System.out.println("Y de donde piensas sacar ese dinero? jajajaja\nVenga intenta decirme un dinero que si que tengas");
            continue;
        }  
        sc.nextLine();
        MostrarMenuPrincipal();
        }
        
        
    }
    public static void Salir(){
        


        System.out.println("*___________ESTADÍSTICAS___________*");
        System.out.println("                               ");
        System.out.println("    Número de ingresos       " + nIngresos);
        System.out.println("    Importe Total Ingresado  " + importeTotalI);
        System.out.println("    Número Total Retiradas   " + nRetiradas);
        System.out.println("    Importe Total Retirado   " + importeTotalR);
        System.out.println("    Saldo Final              " + saldo);
        System.out.println("*__________________________________*\n");
        
        if(saldo>1000){
            System.out.println("Hasta nunca pringao");
        }
        else{
            System.out.println("Oye te vas a ir dejándome así?");
        }
        
    }
}
