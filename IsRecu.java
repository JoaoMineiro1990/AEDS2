public class IsRecu {
    public static boolean vogais (int posicao ,String frase)
    {
        
        if(posicao == frase.length())
        {
            return true;
        }
        else
        {
            if (!(frase.charAt(posicao)=='A'||frase.charAt(posicao)=='a'||frase.charAt(posicao)=='O'||frase.charAt(posicao)=='o'||frase.charAt(posicao)=='i'||frase.charAt(posicao)=='I'||frase.charAt(posicao)=='E'||frase.charAt(posicao)=='e'||frase.charAt(posicao)=='u'||frase.charAt(posicao)=='U'))
            {
                return false;
            }
            return vogais(posicao+1,frase);
        }
    }
    public static boolean consoantes (int posicao , String frase)
    { 
        if(posicao == frase.length())
        {
            return true;
        }
        if((frase.charAt(posicao) >= 65 && frase.charAt(posicao) <= 90) || (frase.charAt(posicao) >= 97 && frase.charAt(posicao) <= 122))
            {
                if ((frase.charAt(posicao)=='A'||frase.charAt(posicao)=='a'||frase.charAt(posicao)=='O'||frase.charAt(posicao)=='o'||frase.charAt(posicao)=='i'||frase.charAt(posicao)=='I'||frase.charAt(posicao)=='E'||frase.charAt(posicao)=='e'||frase.charAt(posicao)=='u'||frase.charAt(posicao)=='U'))
                {
                    return false;
                }
                return consoantes(posicao+1, frase);
            }
        return false;
    }

    public static boolean inteiro (int posicao , String frase){
        if(frase.length()==posicao)
        {
            return true;
        }
        if(frase.charAt(posicao)>=48&&frase.charAt(posicao)<=57)
        {
            return inteiro(posicao+1,frase);
        }
        return false;
    }
    
    public static boolean real (int posicao , int contador , int contador2 , String frase)
    {
        if( posicao == frase.length())
        {
            return true;
        }
        
        if(contador <= 1 || contador2 <= 1)
        {
            if(frase.charAt(posicao) == '-' )
            { 
                contador2++;                   
            }
        else if(frase.charAt(posicao) == ',' ||frase.charAt(posicao) == '.')
            {
                contador++;
            }
        else if( frase.charAt(posicao) < 48 || frase.charAt(posicao) > 57)
            {
                return false;
            }
        else if(contador >= 2 || contador2 >= 2) return false;   
        }
        if(contador2 >= 2 || contador >= 2)return false;
        return real(posicao+1 , contador , contador2 , frase);
    }     
    

    public static void main (String[] args)
    {
        boolean veri=true;
        boolean test;
        String frase;
        
        while(veri)
        {
            frase=MyIO.readLine();
            if(frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M')veri=false;
            if(veri)
            {
                int contador = 0;
                int contador2 = 0;
                String nova="";
                test=vogais(0,frase);
                if(test) nova+="SIM";
                else nova+="NAO";
                test=consoantes(0,frase);
                if(test) nova+=" SIM";
                else nova+=" NAO";
                test=inteiro(0,frase);
                if(test) nova+=" SIM";
                else nova+=" NAO";
                test=real(0 , contador , contador2 , frase);
                if(test) nova+=" SIM";
                else nova+=" NAO";
                MyIO.println(nova);
            }
        }
    }
}


