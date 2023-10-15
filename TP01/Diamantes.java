public class Diamantes {

    public static int contadordiamantes(int contador, String frase )
    {
        String vazia="";
        int i=0;
        int espaco=0;
        int j=0;
        if(frase.length() <= 1)
        {
            return contador;
        }
        while(frase.charAt(i) != '>')
        {
            i++;
            if (i == frase.length()) return contador; 
        }
        while(frase.charAt(i) != '<')
        {
            espaco++;
            i--;
            if (i < 0) return contador;
        }
        while(j<i)
        {
            vazia+=frase.charAt(j);
            j++;
        }
        i += espaco+1;
        while(i<frase.length())
        {
            vazia+=frase.charAt(i);
            i++;
        }
        contador++;
        return contadordiamantes(contador,vazia);
    }

    public static void main (String[] args)
    {
        int n = 0;
        n=MyIO.readInt();
        for(int i = 0 ; i < n ; i++)
        {
            int diamante=0;
            String Frase;
            Frase = MyIO.readLine();
            diamante = contadordiamantes(diamante, Frase );
            MyIO.println(diamante);
        }
       
    }
}