import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class Jogador 
{
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {}

    public Jogador(String id, String nome, String altura, String peso, String universidade, String anoNascimento, String cidadeNascimento, String estadoNascimento) 
    {
        setId(id);
        setNome(nome);
        setAltura(altura);
        setPeso(peso);
        setUniversidade(universidade);
        setAnoNascimento(anoNascimento);
        setCidadeNascimento(cidadeNascimento);
        setEstadoNascimento(estadoNascimento);
    }
    // Sets
    public void setId(String id)
     {
        if (id.equals("!")) {
            this.id = 0;
        } else {
            this.id = Integer.parseInt(id);
        }
    }

    public void setNome(String nome) 
    {
        if (nome.equals("!")) 
        {
            this.nome = "nao informado";
        } 
        else 
        {
            this.nome = nome;
        }
    }

    public void setAltura(String altura) {
        if (altura.equals("!")) {
            this.altura = 0;
        } else {
            this.altura = Integer.parseInt(altura);
        }
    }

    public void setPeso(String peso) {
        if (peso.equals("!")) {
            this.peso = 0;
        } else {
            this.peso = Integer.parseInt(peso);
        }
    }

    public void setUniversidade(String universidade) {
        if (universidade.equals("!")) {
            this.universidade = "nao informado";
        } else 
        {
            this.universidade = universidade;
        }
    }

    public void setAnoNascimento(String anoNascimento) {
        if (anoNascimento.equals("!")) {
            this.anoNascimento = 0;
        } else {
            this.anoNascimento = Integer.parseInt(anoNascimento);
        }
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        if (cidadeNascimento.equals("!")) {
            this.cidadeNascimento = "nao informado";
        } else {
            this.cidadeNascimento = cidadeNascimento;
        }
    }

    public void setEstadoNascimento(String estadoNascimento) {
        if (estadoNascimento.equals("!")) {
            this.estadoNascimento = "nao informado";
        } else {
            this.estadoNascimento = estadoNascimento;
        }
    }

    // Gets
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public String getUniversidade() {
        return universidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }
	//Clone
    
	public Jogador clone() {
    
    Jogador cloneJogador = new Jogador();
    cloneJogador.altura=this.altura;
    cloneJogador.id=this.id;
    cloneJogador.anoNascimento = this.anoNascimento;
    cloneJogador.cidadeNascimento = this.cidadeNascimento;
    cloneJogador.nome = this.nome;
    cloneJogador.peso = this.peso;
    cloneJogador.universidade = this.universidade;
    cloneJogador.estadoNascimento = this.estadoNascimento;
    return cloneJogador;
	}

	// ler

	public static Jogador ler(String linha) 
    {
		String[] separado = linha.split(",");
		String id = separado[0];
		String nome = separado[1];
		String altura = separado[2];
    	String peso = separado[3];
    	String universidade = separado[4];
    	String anoNascimento = separado[5];
    	String cidadeNascimento = separado[6];
    	String estadoNascimento = separado[7];
		
		return new Jogador(id,nome,altura,peso,universidade,anoNascimento,cidadeNascimento,estadoNascimento);
	}
	//Imprimir
	public String Imprimir() 
	{
    return "[" + id + " ## " + nome + " ## " + altura + " ## " + peso + " ## " + anoNascimento + " ## " + universidade + " ## " + cidadeNascimento + " ## " + estadoNascimento + "]";
	}
}

public class TP02Q05 
{
    static int comp = 0;
    static int mov = 0; 

    public static void swap(int menor, int i, Jogador[] jogadores) 
    {
        Jogador temp = jogadores[menor];
        jogadores[menor] = jogadores[i];
        jogadores[i] = temp;
    }

    public static void selec (int tamanho, Jogador[] jogadores)
    {
        for (int i = 0; i < (tamanho - 1); i++) 
        {
            int menor = i;

            for (int j = (i + 1); j < tamanho; j++)
            {
                comp++;
               if ((jogadores[menor].getNome()).compareTo(jogadores[j].getNome()) > 0)
                {
                    menor = j;
                }
            }
            mov+=3;
            swap(menor, i, jogadores);
        }
    }       

    public static void main (String [] args) throws IOException
    {
        // criando log do arquivo
        String nomeDoArquivo = "816594_Selecao.txt";
        RandomAccessFile arq = new RandomAccessFile(nomeDoArquivo, "rw");

        // inciando tempo
        long inicio = System.currentTimeMillis();

        // inicio codigo
        //String Arquivo = "C:\\Users\\Pichau\\Desktop\\Aeds2\\AEDS2\\tmp\\players.csv";
        String Arquivo = "/tmp/players.csv";
        Jogador[] jogadores = new Jogador[500];
        Scanner scanner = new Scanner(System.in);

        int i=0;
        
        try
        {          
            int idjogador;

            while (!scanner.hasNext("FIM"))
            {
                idjogador=scanner.nextInt();
                // fechando e abrindo a leitura para resetar o buff
                BufferedReader leitura = new BufferedReader(new FileReader(Arquivo));
                String linha;     
                leitura.readLine();     
                
                // procurando no csv
                while ( (linha = leitura.readLine()) != null && i < jogadores.length)
                {
                    String enviar="";
                    String testando = "";
                    int j=0;

                    // lendo o id e salvando em uma string
                    while ( j < linha.length())
                    {
                        if( linha.charAt(j)!= ',')
                        {
                            testando+= linha.charAt(j);
                            j++;
                        }
                        else j = linha.length();
                    }
                    int ConvTest = Integer.parseInt(testando);

                    // cacando no csv o id que bate com o id salvo

                    if ( ConvTest == idjogador)
                    {   
                        j=0;
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
                    break;
                    }   
                }
                leitura.close();
            }  
        } catch (Exception e) 
        {
            e.printStackTrace();	
        }       

        //chamando a ordenacao

        selec( i , jogadores);

        // exibindo os resultados
        int id;
        String nomeJog;
        scanner.nextLine();
        nomeJog = scanner.nextLine();
        while(true)
        {
            nomeJog = scanner.nextLine();
            if(nomeJog.equals("FIM"))break;
            id = Integer.parseInt(nomeJog);
            jogadores[id].Imprimir();
        }
        
        scanner.close();

        // finalizando o log
        arq.writeChars("816594 \t");
        long fim = System.currentTimeMillis();
        long resultado = fim - inicio;
        resultado /= 1000;
        arq.writeChars(resultado + " seguntos \t");
        arq.writeChars(comp + " comparacoes \t");
        arq.writeChars(mov + " movimentacoes \t");
        arq.close();
    }
}
