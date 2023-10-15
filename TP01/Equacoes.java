public class Equacoes {

    public static void main (String[] args)
    {
        
        int n;
        n=MyIO.readInt();
        String frase;
        frase=MyIO.readLine();
        for(int j = 0 ; j < n ; j++)
        {
            int i=0;
            int contador=0;
            while (i<frase.length())
            {
                if(frase.charAt(i)=='(') contador++;
                else if(frase.charAt(i)==')' && contador > 0)
                    {
                        if (contador > 0)contador--;
                        else contador++;
                    }
                if (contador == 0) MyIO.println("correct");
                else MyIO.println("incorrect");
            }  
        }
}
}
