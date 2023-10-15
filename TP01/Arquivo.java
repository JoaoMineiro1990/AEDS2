import java.io.RandomAccessFile;

public class Arquivo {
    public static void main(String[] args) throws Exception {
        //criando o arquivo e as variaveis de entrada
        RandomAccessFile novo = new RandomAccessFile("minhasaida.txt", "rw");
        int rept = MyIO.readInt();

        //preenchendo o vetor com os inputs do usuario
        for (int i = 0; i < rept; i++) 
        {
            
            double valor = MyIO.readDouble();
            novo.writeDouble(valor);

        }
        novo.close();
        //reabrindo o arquivo
        novo = new RandomAccessFile("minhasaida.txt", "r");
        
        //lendo os valores do fim pro comeco do arquivo
        for (int i = (rept-1); i >= 0; i--) {
            
            novo.seek(i*8);
            double leitura = novo.readDouble();
            //verificando se eh um int ou um double
            if(leitura%1 == 0 || leitura%2 == 0 || leitura%3 == 0)
            {
                MyIO.println((int)leitura);
            }
            else MyIO.println(leitura);

        }

        novo.close();
    }
}