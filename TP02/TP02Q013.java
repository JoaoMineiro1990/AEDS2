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

	public static Jogador ler(String linha) {
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
    
public class TP02Q013 
{
    static int comp = 0;
    static int mov = 0; 
    public static final Jogador sentinela = new Jogador("-1","-1","-1","-1","zzzzzzzz","-1","-1","-1");


    public static void mergesort(int esq, int dir, Jogador[] jogadores)
    {
        comp++;
        if (esq < dir)
        {
            int meio = (esq + dir) / 2;
            mergesort(esq, meio, jogadores);
            mergesort(meio + 1, dir, jogadores);
            intercalar(esq, meio, dir,jogadores);
        }
    }

    public static void intercalar(int esq,int meio,int dir,Jogador[] jogadores) 
    {
    int n1, n2, i, j, k;

    n1 = meio - esq + 1;
    n2 = dir - meio;

    Jogador[] a1 = new Jogador[n1];
    Jogador[] a2 = new Jogador[n2];

    for (i = 0; i < n1; i++) 
    {
        mov++;
        a1[i] = jogadores[esq + i];
    }

    for (j = 0; j < n2; j++) 
    {
        mov++;
        a2[j] = jogadores[meio + j + 1];
    }

    for (i = j = 0, k = esq; (k <= dir) && (i < n1 && j < n2); k++)
    {
        comp+=3;
        if(a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) < 0)
        {
            mov++;
            jogadores[k]=a1[i++];
        }
        else if(a1[i].getUniversidade().compareTo(a2[j].getUniversidade()) == 0)
        {
            comp++;
            if(a1[i].getNome().compareTo(a2[j].getNome()) < 0)
            {
                mov++;
                jogadores[k]=a1[i++];
            }
            else
            {
                mov++;
               jogadores[k]=a2[j++];
            }
        }
        else 
        {
            mov++;
            jogadores[k]=a2[j++];
        }
    }

    while (i < n1)
    {
        mov++;
        jogadores[k++] = a1[i++];
    }

    while (j < n2) 
    {
        mov++;
        jogadores[k++] = a2[j++];
    }
  }


    public static void main (String [] args) throws IOException
    {
        // criando log do arquivo
        String nomeDoArquivo = "816594_mergesort.txt";
        RandomAccessFile arq = new RandomAccessFile(nomeDoArquivo, "rw");

        // inciando tempo
        long inicio = System.currentTimeMillis();

        // inicio codigo
        //String Arquivo = "tmp/players.csv";
        String Arquivo = "/tmp/players.csv";
        Jogador[] jogadores = new Jogador[463];
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

        mergesort(0, i-1, jogadores);

        // exibindo os resultados
        for(int l = 0; l < i ; l++)
        {
            System.out.println(jogadores[l].Imprimir());
        }     

        scanner.close();

        // finalizando o log
        arq.writeChars("816594 \t");
        long fim = System.currentTimeMillis();
        long resultado = fim - inicio;
        resultado /= 1000;
        arq.writeChars(resultado + " seguntos \t");
        arq.writeChars(comp + " comparacoes \t");
        arq.close();
    }
}
