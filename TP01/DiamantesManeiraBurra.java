public class DiamantesManeiraBurra {
    
    public static void main (String[] args)
    {
        int n = 0;
        n=MyIO.readInt();
        for(int i = 0 ; i < n ; i++)
        {
            int esquerda = 0;
            int direita = 0;
            int diamante=0;
            String Frase;
            Frase = MyIO.readLine();
            for(int j = 0; j < Frase.length() ; j++)
            {
                if(Frase.charAt(j) == '>') direita++;
                if(Frase.charAt(j) == '<') esquerda++;
            }
            if (direita > esquerda) diamante = esquerda;
            else diamante = direita;
            MyIO.println(diamante);
        }
    }
}
