import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        
        System.out.println("Willkommen in meinem Eisladen.");

        Eis eis1 = new Eis("Schockolade", 7.20);
        Eis eis2 = new Eis("Erdbeere", 11.40);

        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie ihr guthaben ein: ");
        double guthaben = sc.nextDouble();

        System.out.println("Sie haben: " + guthaben + " CHF als guthaben");
        System.out.println("Wir bieten an: " + eis1.getSorte() + " für " + eis1.getPreisEis() + " und " + eis2.getSorte()+ " für " + eis2.getPreisEis());
        System.out.println("Geben sie x ein für Schockoldade oder y ein für Erdbeere:");

        String auswahlKunde = sc.next();

        switch (auswahlKunde) {

            case "x":

                    if (guthaben >= eis1.getPreisEis()){
                        System.out.println("Sie haben sich für Schocklade entschieden. Guten Apettit.");
                        System.out.println("Wechselgeld: " + (guthaben - eis1.getPreisEis()) + " CHF");
                    } else {
                        System.out.println("Guthaben zuklein");
                    } 
                    
                    break;

            case "y":

                if (guthaben >= eis2.getPreisEis()){
                        System.out.println("Sie haben sich für Schocklade entschieden. Guten Apettit.");
                        System.out.println("Wechselgeld: " + (guthaben - eis2.getPreisEis()) + " CHF");
                    } else {
                        System.out.println("Guthaben zuklein");
                    }
                    
                    break;

            default:

                    System.out.println("Ungültige Eingabe");
                    break;
        }
    }
}
