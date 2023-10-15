public class Pessoa {
    private String nome;
    private int idade;
    private String cargo;

    public Pessoa(){
        this.nome="";
        this.idade=0;
        this.cargo="";
    }

    public void setIdade(int valor){
        if(valor<0){MyIO.println("ERRO idade invalida");}
        else{this.idade=valor;}
    }

    public void setNome(String frase){
        if(frase.length()<3){MyIO.println("ERRO nome invalido");}
        else{this.nome=frase;}
    }
    
    public void setCargo(String trabalho){
        this.cargo=trabalho;
    }

    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }
    public String getCargo(){
        return cargo;
    }

    public void imprimir(){
        MyIO.println("O nome eh "+this.nome+" de idade "+this.idade+" no cargo "+this.cargo);
    }
    public static void main (String[] args){
        Pessoa fulano= new Pessoa();
        
        MyIO.println("qual seu nome moco");
        fulano.setNome(MyIO.readLine());
        MyIO.println("qual sua idade moco");
        fulano.setIdade(MyIO.readInt());
        MyIO.println("qual seu trabalho");
        fulano.setCargo(MyIO.readLine());

        fulano.imprimir();

    }
}
