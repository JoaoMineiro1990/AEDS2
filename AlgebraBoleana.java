public class AlgebraBoleana {

    public static String Algebra(int posicao, String funcoes) {
        String retorno ="";
        for(int i = 0; i < funcoes.length() ; i++)
        {
            if (i < posicao || i > posicao)
            {
                retorno += funcoes.charAt(i); 
            }
            else if (i == posicao)
            {
                if(funcoes.charAt(i) == '!')
                {
                    if (funcoes.charAt(i+2) == '0') retorno += '1';
                    else retorno += '0';
                    i += 3;
                }
                else if( funcoes.charAt(i) == '.')
                {
                    int contador = 0;
                    int valor=0;
                    while (funcoes.charAt(i + contador) != ')')
                    {
                        contador++ ;
                        if(funcoes.charAt(i + contador) == '1')valor ++;
                    }
                    if (valor > 0) retorno += '1';
                    else retorno += '0';
                    i = i + contador;
                }
                else if( funcoes.charAt(i) == '^')
                {
                    int contador = 0;
                    int valor=0;
                    while (funcoes.charAt(i + contador) != ')')
                    {
                        contador++ ;
                        if(funcoes.charAt(i + contador) == '0')valor ++;
                    }
                    if (valor > 0) retorno += '0';
                    else retorno += '1';
                    i = i + contador;
                }
            }

        }
        return retorno;
    }
    public static void main(String[] args) throws Exception {
        String leitura = "";
        String func = "";
        int contador = 0;

        leitura = MyIO.readLine();
        char A = leitura.charAt(2);
        char B = leitura.charAt(4);
        char C = leitura.charAt(6);

        for (int i = 0; i < leitura.length(); i++) {
            if (leitura.charAt(i) == 'a' && leitura.charAt(i + 1) == 'n')
                func += '^';
            if (leitura.charAt(i) == 'o' && leitura.charAt(i + 1) == 'r')
                func += '.';
            if (leitura.charAt(i) == 'n' && leitura.charAt(i + 1) == 'o')
                func += '!';
            if (leitura.charAt(i) == 'A')
                func += A;
            if (leitura.charAt(i) == 'B')
                func += B;
            if (leitura.charAt(i) == 'C')
                func += C;
            if (leitura.charAt(i) == '(')
                func += leitura.charAt(i);
            if (leitura.charAt(i) == ')')
                func += leitura.charAt(i);
        }
    
        for (int i = 0; i < func.length(); i++) {
            if (func.charAt(i) == '.' || func.charAt(i) == '^' || func.charAt(i) == '!')
                contador++;
        }

        int[] posicoes = new int[contador];
        int contador2 = 0;

        for (int i = 0; i < func.length(); i++) {
            if (func.charAt(i) == '.' || func.charAt(i) == '^' || func.charAt(i) == '!') {
                posicoes[contador2] = i;
                contador2++;
            }
        }
        
        for (int i = contador - 1; i >= 0; i--) {
            func = Algebra(posicoes[i], func);
        }
        MyIO.println(func);
    }
}


