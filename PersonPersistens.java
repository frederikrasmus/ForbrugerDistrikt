import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersonPersistens
{
    public static void writePerson(Forbruger forbruger)
    {
        String personFile = "person.txt"; //navnet på output-filen

        try (FileWriter writer = new FileWriter(personFile, true))
        {
            String navn     = forbruger.getNavn();
            int maalerNr    = forbruger.getMaalerNr();

            writer.append(navn+",");
            writer.append(Integer.toString(maalerNr)+"\n");

                System.out.println("Person file written successfully.");

        }


        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void readPerson()
    {
        // Skilletegn mellem atributter er et komma
        String komma = ",";
        String line = "";
        String personFile = "person.txt";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(personFile)))
        {
            // Read each line from the file
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(komma);

                if (data.length >= 2) {
                    System.out.println("Forbruger " + (++count) + ": Navn: " + data[0] + ", maalerNr: " + data[1]);

                    } else {
                        System.out.println("Ingen valid data: " + line);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    //writer.append(p.getNavn()+","+p.getMail()+","+Integer.toString(p.getFoedselsdag().getDatoen())+","+p.getBil().getRegist
}
