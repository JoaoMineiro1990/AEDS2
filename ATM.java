public class ATM {
    private int conta;

    public ATM(){
        this.conta=0;
    }

    public void Sacar(int valor){
        if(this.conta>valor){
            this.conta=this.conta-valor;
            MyIO.println("vc sacou "+valor+ " resta na conta "+this.conta);
        }
        else{MyIO.println("VOCE NAO TEM SALDO SEU POBRE");
    }     
    }

    public void depositar(int valor){
        if(valor<0){Sacar(valor);}
        else{
            this.conta+=valor;
            MyIO.println("Voce depositou "+valor+" seu saldo total eh "+ this.conta);}
    }   

    public int getSaldo(){
        return this.conta;
    }

    public static void main(String[] args){
        ATM banco=new ATM();
        int escolha;
        int dinheiros;
        do{
            MyIO.println("0 - sair");
            MyIO.println("1 - depositar");
            MyIO.println("2 - sacar");
            MyIO.println("3 - Ver saldo");



            escolha=MyIO.readInt();
                switch(escolha){
                    case 0:
                        MyIO.println("Ate mais...");
                        break;
                    case 1:
                        MyIO.println("digite o valor a ser depositado");
                        dinheiros=MyIO.readInt();
                        banco.depositar(dinheiros);
                        break;
                    case 2:
                        MyIO.println("digite o valor a ser sacado");
                        dinheiros=MyIO.readInt();
                        banco.Sacar(dinheiros);
                        break;
                    case 3:
                        MyIO.println("seu saldo eh: "+banco.getSaldo());
                        break;
                    default:
                        MyIO.println("Escolha invalidade tente novamente");                                              
                } 

        }while(escolha!=0);
    }
}
