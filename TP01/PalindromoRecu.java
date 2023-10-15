import java.util.Scanner;

import java.util.Scanner;
public class PalindromoRecu {

    public static boolean Recupali(String frase)
    {

    }

    public static boolean Recu (int posicao, String frase)
    {
        if (posicao == frase.length()/2)
        {
            return true;
        }
        else
        {
            if(frase.charAt(posicao) != frase.charAt(frase.length()-posicao-1))
            {
                return false;
            }
        }
    }
    //Scanner entrada = new Scanner(System.in);
    //while(entrada.hasNext()
    public static void main (String[] args)
    {
        String frase ="";
        frase = MyIO.readLine();
        Recupali(frase);
    }
}