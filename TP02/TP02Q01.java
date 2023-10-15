import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

class TP02Q01 
    {
        public static void main(String[] args) throws IOException
        {
            String nomeDoArquivo = "816594_Classe.txt";
            RandomAccessFile arq = new RandomAccessFile(nomeDoArquivo, "rw");

            // inciando tempo
            long inicio = System.currentTimeMillis();
            
            String Arquivo = "tmp/players.csv";
            Jogador[] jogadores = new Jogador[3992];
            Scanner scanner = new Scanner(System.in);
            
            try
            {
                BufferedReader leitura = new BufferedReader(new FileReader(Arquivo));
                String linha;
                int i=0;
                leitura.readLine();
                while ( (linha = leitura.readLine()) != null && i < jogadores.length)
                {
                    String enviar="";
                    int j=0;
                    while (j < linha.length())
                    {
                        if (linha.charAt(j) == ',' && j == linha.length()-1)
                        {
                            enviar+= ",!,";
                            j++;
                        }
                        else if(linha.charAt(j) == ',' && linha.charAt(j+1) == ',')
                        {
                            enviar+= ",!";
                            j++;
                        }
                        else
                        {
                        enviar+=linha.charAt(j);
                        j++;
                        }
                    }
                    Jogador jogador = Jogador.ler(enviar);
                    jogadores[i] = jogador;
                    i++;
                }
                leitura.close();
            } catch (Exception e) 
            {
                e.printStackTrace();	
            }
            
            while (!scanner.hasNext("FIM"))
            {
                int posicao = scanner.nextInt();
                System.out.println(jogadores[posicao].Imprimir());
            }
            scanner.close();

            // fehcando o log
            arq.writeChars("816594 \t");
            long fim = System.currentTimeMillis();
            long resultado = fim - inicio;
            resultado /= 1000;
            arq.writeChars(resultado + " seguntos \t");
            arq.close();
        }
        
    }

