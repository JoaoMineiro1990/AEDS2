import java.io.RandomAccessFile;

public class Arquivo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile novo = new RandomAccessFile("minhasaida.txt", "rw");
        int rept = MyIO.readInt();

        for (int i = 0; i < rept; i++) {
            double valor = MyIO.readDouble();
            novo.writeDouble(valor);
        }
        novo.close();

        novo = new RandomAccessFile("minhasaida.txt", "r");
        
        for (int i = (rept-1); i >= 0; i--) {
            
            novo.seek(i*8);
            double leitura = novo.readDouble();
            if(leitura%1 == 0 || leitura%2 == 0 || leitura%3 == 0)
            {
                MyIO.println((int)leitura);
            }
            else MyIO.println(leitura);
        }

        novo.close();
    }
}