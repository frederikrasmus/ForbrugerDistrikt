import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Frederik
 * @28.September
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Forbruger frede     =   new Forbruger("Frede",1,999);
        Distrikt  tagensvej =   new Distrikt("Tagensvej",(double) 3);

        Scanner scan = new Scanner(System.in);

        // Tilføjer første forbruger
        // tagensvej.addForbruger(frede);

        // tagensvej.fordelingPigeNavne();

        // aflaesning værdi
        // frede.aflaesMaaler(20);
        // frede.aflaesMaaler(30);

        // Check Frederik pris
        // System.out.println("Fredes forbrug er: "+frede.beregnForbrug()+"m3(varme)");
        // System.out.println("Fredes betaling er: "+tagensvej.afregnForbruger(frede.getMaalerNr())+" kr.");
        // System.out.println(vej.Forbruger();

        /*
        int forb = 612;
        float pris = tagensvej.afregnForbruger(forb);

        if (pris >= 0)
            System.out.println("Betalingen for måler: "+forb+"'s forbrug: "+pris);
        else
            System.out.println("Måleren "+forb+" fandtes ikke.");
        */

        System.out.println("Dette program kan generere forbrugere");

        System.out.println("Indtast antal forbrugere du ønsker at generere ");
        // generer x antal brugere
        int y = scan.nextInt();
        if (y > 200) {
            System.out.println("Distrikt kan maksimalt være 200 brugere stort");
            System.out.println("Prøv igen");
            y = scan.nextInt();
        }
        if (y > 200) {
            System.out.println("Distrikt kan maksimalt være 200 brugere stort");
            System.out.println("Lukker program");
            System.exit(0);
        }
        else
            System.out.println("Genererer " + y + " antal forbrugere om:");
        //Thread.sleep(1000);
        for (int j = 3; j >= 1; j--) {
            System.out.println(j);
            //Thread.sleep(1000);
        }

        tagensvej.genererForbruger(y);
        int nr = 1;
        for (int i = 0; i < tagensvej.getAntalForbrugere(); i++)
        {
            Forbruger forbruger = tagensvej.getForbruger(i);
            System.out.println(nr + ". " + "Forbruger: " + forbruger.getNavn() + " med måler nr: " + forbruger.getMaalerNr());
            PersonPersistens.writePerson(forbruger);
            nr++;
        }

        System.out.println("Antal piger " + tagensvej.fordelingPigeNavne());
        System.out.println("Antal drenge " + tagensvej.fordelingDrengeNavne());


        System.out.println("Skriv et navn, husk stort forbogstav");
        Scanner scan2 = new Scanner(System.in);
        String x = scan2.nextLine();
        tagensvej.antalGangeForekommer(x);

        if(tagensvej.antalGangeForekommer(x) > 1)
            System.out.println("Programmet har skrevet " + x + " " + tagensvej.antalGangeForekommer(x) + " gange");
        else if (tagensvej.antalGangeForekommer(x) == 1)
            System.out.println("Programmet har skrevet " + x + " " + tagensvej.antalGangeForekommer(x) + " gang");
        else
            System.out.println("Navnet " + x + " blev ikke fundet");

        for (int k = 2; k >= 1; k--) {
            //Thread.sleep(1000);
        }
        System.out.println("Ønsker du dig listen i alfabetisk rækkefølge skriv da 'Ja', eller skriv 'Nej'");
        Scanner scan3 = new Scanner(System.in);
        String j = scan3.nextLine();
        ArrayList<String> sorteret = tagensvej.alfabetisk();

        if(j.equals("Ja")) {
            for (String navn : sorteret) {
                Thread.sleep(10);
                System.out.println(navn);
            }
        }
        else
        if (j.equals("ja")) {
            for (String navn : sorteret) {
                Thread.sleep(10);
                System.out.println(navn);
            }
        }

    System.out.println("Ønsker du dig at læse person-filen? Skriv 'Ja' eller 'Nej");
        String choice = scan3.nextLine();
        if (choice.equals("Ja")) {
            PersonPersistens.readPerson();
        } else if (choice.equals("Nej")) {
            System.out.println("Byebye");
            System.exit(0);
        }
    }
}

