public class AlgebraBoleana {

    public static String Algebra(int posicao, String funcoes) {
        String retorno = "";
        int i = 0;
        int contador = 0;
        int contador2 = 0;

        while (i < funcoes.length()) 
        {
            if (i < posicao) {
                retorno += funcoes.charAt(i);
                i++;
            }

            else if (funcoes.charAt(i) == '!') {
                if (funcoes.charAt(i + 1) == '1') {
                    retorno += "0)";
                    i++;
                } else {
                    retorno += "1)";
                    i++;
                }

            } else if (funcoes.charAt(i) == '^') {
                for (; i != ')'; i++) {
                    if (funcoes.charAt(i) == '1') {
                        contador++;
                    }
                    if (funcoes.charAt(i) == '0' || funcoes.charAt(i) == '1') {
                        contador2++;
                    }
                }

                if (contador == contador2) {
                    retorno += '1';
                    i++;
                } else {
                    retorno += '0';
                    i++;
                }
            } else if (funcoes.charAt(i) == '.') {
                for (; i != ')'; i++) {
                    if (funcoes.charAt(i) == '1') {
                        contador++;
                    }
                    if (funcoes.charAt(i) == '0' || funcoes.charAt(i) == '1') {
                        contador2++;
                    }
                }

                if (contador == contador2) {
                    retorno += '0';
                    i++;
                } else {
                    retorno += '1';
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
        MyIO.println(func);
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
            MyIO.println(func);
        }
        MyIO.println(func);
    }
}
