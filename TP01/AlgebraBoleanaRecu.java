public class AlgebraBoleanaRecu 
{
    
    public static char Algebra(String funcoes , int lugar , String retorno) 
    {
        
        if (lugar == funcoes.length()-1)
        {
            return funcoes.charAt(0);
        }
        while (funcoes.charAt(lugar)!=')')
        {
            lugar++;
        }
        while(funcoes.charAt(lugar)!='^' && funcoes.charAt(lugar)!='.' && funcoes.charAt(lugar)!='!')
        {
            lugar--;
        }
        for (int i=0; i < lugar ; i++)
        {
            retorno+=funcoes.charAt(i);
        }
        if(funcoes.charAt(lugar) == '!')
        {
            if (funcoes.charAt(lugar+2) == '0') retorno += '1';
            else retorno += '0';
            lugar+=4;
        }
        else if( funcoes.charAt(lugar) == '.')
        {
            int valor=0;
            int contador=0;
            while (funcoes.charAt(lugar + contador) != ')')
            {
                if(funcoes.charAt(lugar + contador) == '1')valor ++;
                contador++;
            }
            if (valor > 0) retorno += '1';
            else retorno += '0';
            lugar+=contador+1;
        }
        else if( funcoes.charAt(lugar) == '^')
        {
            int valor=0;
            int contador=0;
            while (funcoes.charAt(lugar + contador) != ')')
            {
                if(funcoes.charAt(lugar + contador) == '0')valor ++;
                contador++;
            }
            if (valor > 0 ) retorno += '0';
            else retorno += '1';
            lugar+=contador+1;
        }
        while(lugar<funcoes.length())
        {
            retorno+=funcoes.charAt(lugar);
            lugar++;
        }
        String vazia="";
        return Algebra(retorno, 0, vazia);
    }
     
    public static void main(String[] args) throws Exception {
        String leitura = "";
        leitura = MyIO.readLine();
        while( leitura.charAt(0) != '0')
        {
            // INICIANDO AS VARIAVEIS
            String func = "";
            char A = leitura.charAt(2);
            char B = leitura.charAt(4);
            char C = leitura.charAt(6);

            // CRIANDO UMA STRING QUE CONTENHA APENAS OS VALORES DE A,B,C E A EXPRESSOES
            for (int i = 0; i < leitura.length(); i++) 
            {
                if (leitura.charAt(i) == 'a' && leitura.charAt(i + 1) == 'n')func += '^';
                if (leitura.charAt(i) == 'o' && leitura.charAt(i + 1) == 'r')func += '.';
                if (leitura.charAt(i) == 'n' && leitura.charAt(i + 1) == 'o')func += '!';
                if (leitura.charAt(i) == 'A')func += A;
                if (leitura.charAt(i) == 'B')func += B;
                if (leitura.charAt(i) == 'C')func += C;
                if (leitura.charAt(i) == '(')func += leitura.charAt(i);
                if (leitura.charAt(i) == ')')func += leitura.charAt(i);
            }
            
            String retorno="";

            // CHAMADA DA FUNCAO ALGEBRA QUE VAI RESOLVER AS OPERACOES DA ULTIMA PARA A PRIMEIRA        
            MyIO.println(Algebra(func,0,retorno));

            //PREGUICA DE FAZER O WHILE DIREITO 
            leitura = MyIO.readLine();
        }
        
    }
}
