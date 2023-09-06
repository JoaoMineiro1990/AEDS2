import java.util.Scanner;
public class Warmup
{  
    public static void main (String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        int n1;
        int n2;
        
        while(entrada.hasNext())
        {
            n1 = entrada.nextInt();
            n2 = entrada.nextInt();
            String eita="";

            for (int i = 0 ; i <= (n2-n1) ; i++)
            {
                eita+=n1+i;
            }
            for(int i=0; i<eita.length(); i++)
            {
                MyIO.print(eita.charAt(i));
            }
            for(int i=eita.length()-1; i>=0; i--)
            {
                MyIO.print(eita.charAt(i));
            }
            MyIO.print("\n");
        }
    entrada.close();
    } 
}