
/**
 * En klasse for forbruger. Vi kan bruge forbruger i klassen Distrikt.
 * @Frederik
 * @17.September 2024
 */
public class Forbruger
{
    private String  navn;
    private int     maalerNr;
    private int     nyAflaesning;
    private int     forrigeAflaesning;
    private int     maalerMax;

    public Forbruger()
    {

    }

    public Forbruger(String n, int mNr, int mMax)
    {
        navn = n;
        // Navn på forbruger
        maalerNr = mNr;
        // Målernummer identificerer et forbruger-object
        maalerMax = mMax;
        // Maksimal mulig værdi på måler. Starter forfra.
    }

    public int getMaalerNr()
    {
        return maalerNr;
    }

    public void setNavn(String setNavn)
    {
        navn = setNavn;
    }

    public String getNavn()
    {
        return navn;
    }

    public void aflaesMaaler(int aflaesning)
    {
        forrigeAflaesning = nyAflaesning;
        nyAflaesning = aflaesning;

    }

    public int beregnForbrug()
    {
        if(nyAflaesning == forrigeAflaesning)
            return 0;
        if(nyAflaesning > forrigeAflaesning)
            return nyAflaesning - forrigeAflaesning;
        if(nyAflaesning < forrigeAflaesning)
            return nyAflaesning + maalerMax - forrigeAflaesning;

        return -1;
    }
}
