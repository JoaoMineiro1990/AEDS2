import java.util.Scanner;
public class Palindromo {
    //funcao palindromo que compara o ultimo termo e o primeiro termo de uma string
    public static boolean isPalindromo(String testando){
     
        boolean verifica=true;
       
        for(int i=0;i<((testando.length())/2);i++){
            if(testando.charAt(i)!=testando.charAt((testando.length())-i-1))
            {
                verifica=false;
                i=testando.length();
            }
        }

        return verifica;
    }

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        //Definindo variaveis
        String palin;
        boolean ver=true;
        //chamando as funcoes no loop
       
        while(ver){
            palin=sc.nextLine();
            if(palin.length()==3&&palin.charAt(0)=='F'&&palin.charAt(1)=='I'&& palin.charAt(2)=='M'){ver=false;}
            if(ver){
                if(isPalindromo(palin)){MyIO.println("SIM");}
                else{MyIO.println("NAO");}
            }
        }}
        
    }
