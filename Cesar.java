public class Cesar{

    public static String testandoCesar(String texto){//iniciando o cesar
        String nova = "";//criando a nova frase que vai guardar os caracteres novos
        for(int i = 0 ; i < texto.length(); i++)
        {
            char auxiliar = texto.charAt(i);
            if(auxiliar >= 0 && auxiliar <= 127)//ignorando codigos fora da tabela ASCII
            {
                auxiliar += 3;
                auxiliar = (char)auxiliar;//transformando em char pois no valor acima ele transofrma em int
                nova    +=  auxiliar;
            } 
             else
            {
                nova += texto.charAt(i);//adicionando o valor ignorado na string
            }              
        }
        return nova;
    }
    public static void main(String[] args){
        //Declaracao das variaveis
        String frase;
        boolean ver=true;
        //input do usuario
        
        while(ver){
            frase=MyIO.readLine();
            if(frase.length()==3&&frase.charAt(0)=='F'&&frase.charAt(1)=='I'&& frase.charAt(2)=='M'){ver=false;}
            if(ver){
                frase = testandoCesar(frase);
                MyIO.println(frase);
            }
        }}
}
