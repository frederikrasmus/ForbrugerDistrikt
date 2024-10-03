import java.util.*;
/**
 * @author Frederik
 * @version 27. September 2024
 */
public class Distrikt
{
    private String navn;
    private double prisPrM3;
    private ArrayList<Forbruger>    forbrugere      = new ArrayList<>();
    private ArrayList<String>       nyForbruger     = new ArrayList<>();
    private ArrayList<String>       pigeNavn        = new ArrayList<>();
    private ArrayList<String>       drengeNavn      = new ArrayList<>();
    private ArrayList<String>       efternavne      = new ArrayList<>();
    private ArrayList<Character>       alfabet      = new ArrayList<>();
    private ArrayList<String>       sorteret        = new ArrayList<>();
    private int antalForbrugere                     = 0;

    public Distrikt()
    {

    }

    public Distrikt(String etNavn, double enPris)
    {
        navn = etNavn;
        // navn på distrikt
        prisPrM3 = enPris;
        // Prisen pr kubikmeter(m3) varme

    }

    public void genererForbruger(int antal)
    {
        Random random = new Random();
        // Hashset,
        HashSet<Integer> findesMaalerNr = new HashSet<>();

        String navn;

        drengeNavn.add("Peter");
        drengeNavn.add("Michael");
        drengeNavn.add("Lars");
        drengeNavn.add("Jens");
        drengeNavn.add("Thomas");
        drengeNavn.add("Henrik");
        drengeNavn.add("Søren");
        drengeNavn.add("Christian");
        drengeNavn.add("Martin");
        drengeNavn.add("Jan");

        pigeNavn.add("Anne");
        pigeNavn.add("Mette");
        pigeNavn.add("Kirsten");
        pigeNavn.add("Hanne");
        pigeNavn.add("Anna");
        pigeNavn.add("Helle");
        pigeNavn.add("Maria");
        pigeNavn.add("Susanne");
        pigeNavn.add("Lene");
        pigeNavn.add("Marianne");

        efternavne.add("Nielsen");
        efternavne.add("Jensen");
        efternavne.add("Hansen");
        efternavne.add("Andersen");
        efternavne.add("Pedersen");
        efternavne.add("Christensen");
        efternavne.add("Larsen");
        efternavne.add("Sørensen");
        efternavne.add("Rasmussen");
        efternavne.add("Jørgensen");

        for(int j = 0; j < antal; j++) {
            if(random.nextBoolean())
                navn = drengeNavn.get(random.nextInt(drengeNavn.size()));
            else{
                navn = pigeNavn.get(random.nextInt(pigeNavn.size()));
            }
            String efternavn = efternavne.get(random.nextInt(efternavne.size()));

            String fuldtNavn = navn + " " + efternavn;

            int randomMaalerNr;
            do {
                randomMaalerNr = random.nextInt(antal);
            } while (!findesMaalerNr.add(randomMaalerNr));
            Forbruger nyForbruger = new Forbruger (fuldtNavn, randomMaalerNr, antal);
            addForbruger(nyForbruger);
            antalForbrugere++;
        }
    }

    public void addForbruger(Forbruger enForbruger )
    {
        if (forbrugere.size() < 200)
        {
            forbrugere.add(enForbruger);
        }
    }

    public int afregnForbruger(int maalerNummer)
    {
        for (int i = 0; i < forbrugere.size(); i++)
        {
            if (forbrugere.get(i).getMaalerNr() == maalerNummer)
            {
                return (int) (forbrugere.get(i).beregnForbrug() * prisPrM3);
            }
        }
        return -1;
    }

    public Forbruger getForbruger(int i)
    {
        if (i >= 0 && i < antalForbrugere) {
            return forbrugere.get(i);
        }
        return null;
    }

    public int getAntalForbrugere()
    {
        return antalForbrugere;
    }

    public int fordelingPigeNavne()
    {
        int antalPigenavne = 0;

        pigeNavn.add("Anne");
        pigeNavn.add("Mette");
        pigeNavn.add("Kirsten");
        pigeNavn.add("Hanne");
        pigeNavn.add("Anna");
        pigeNavn.add("Helle");
        pigeNavn.add("Maria");
        pigeNavn.add("Susanne");
        pigeNavn.add("Lene");
        pigeNavn.add("Marianne");

        for (int k = 0; k < forbrugere.size(); k++) {
            String forbrugerNavn = forbrugere.get(k).getNavn();
            for (String pigeNavne : pigeNavn) {
                if (forbrugerNavn.contains(pigeNavne)) {
                    antalPigenavne++;
                    break;
                }
            }
        }
        return antalPigenavne;
    }

    public int fordelingDrengeNavne()
    {

        return forbrugere.size() - fordelingPigeNavne();
    }

    public int antalGangeForekommer (String n)
    {
        int antalGange = 0;

        for (Forbruger forbruger : forbrugere)
            if (forbruger.getNavn().contains(n)) {
                antalGange++;
            }
        return antalGange;
    }


    public ArrayList<String> alfabetisk()
    {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alfabet.add(ch);
        }
        drengeNavn.add("Peter");
        drengeNavn.add("Michael");
        drengeNavn.add("Lars");
        drengeNavn.add("Jens");
        drengeNavn.add("Thomas");
        drengeNavn.add("Henrik");
        drengeNavn.add("Søren");
        drengeNavn.add("Christian");
        drengeNavn.add("Martin");
        drengeNavn.add("Jan");

        pigeNavn.add("Anne");
        pigeNavn.add("Mette");
        pigeNavn.add("Kirsten");
        pigeNavn.add("Hanne");
        pigeNavn.add("Anna");
        pigeNavn.add("Helle");
        pigeNavn.add("Maria");
        pigeNavn.add("Susanne");
        pigeNavn.add("Lene");
        pigeNavn.add("Marianne");

        efternavne.add("Nielsen");
        efternavne.add("Jensen");
        efternavne.add("Hansen");
        efternavne.add("Andersen");
        efternavne.add("Pedersen");
        efternavne.add("Christensen");
        efternavne.add("Larsen");
        efternavne.add("Sørensen");
        efternavne.add("Rasmussen");
        efternavne.add("Jørgensen");


        for (Forbruger forbruger : forbrugere) {
            sorteret.add(forbruger.getNavn());
        }

        for(int l = 0; l < forbrugere.size() - 1; l++) {
            for (int n = l + 1; n < forbrugere.size(); n++) {
                if (sorteret.get(l).compareTo(sorteret.get(n)) > 0) {
                    // sorter navne hvis de er i forkert rækkefølge
                    String temp = sorteret.get(l);
                    sorteret.set(l, sorteret.get(n));
                    sorteret.set(n, temp);
                }
            }
        }


        return sorteret;
    }

}



