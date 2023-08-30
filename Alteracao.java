import java.util.Random;

public class Alteracao {

    public static String alterar(String frase,char a,char b) {
        String nova = "";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == a) {
                nova+=b;
            } else {
                nova+=frase.charAt(i);
            }
        }
        return nova;
    } 

    public static void main (String[] args)
    {
        boolean ver=true;
        String escrita;
        Random gerador = new Random();
        gerador.setSeed(4);
        
        while(ver){
            
            escrita=MyIO.readLine();
            if(escrita.length()==3&&escrita.charAt(0)=='F'&&escrita.charAt(1)=='I'&& escrita.charAt(2)=='M'){ver=false;}
            if(ver){
                char letra = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
                char trocar = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
                escrita=alterar(escrita,letra,trocar);
                MyIO.println(escrita);
            }
        }}
        
}