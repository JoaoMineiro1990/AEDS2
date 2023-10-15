public class Is {
    public static boolean vogais (String frase){
        boolean ver=true;
        for(int i=0;i<frase.length();i++){
            if (!(frase.charAt(i)=='A'||frase.charAt(i)=='a'||frase.charAt(i)=='O'||frase.charAt(i)=='o'||frase.charAt(i)=='i'||frase.charAt(i)=='I'||frase.charAt(i)=='E'||frase.charAt(i)=='e'||frase.charAt(i)=='u'||frase.charAt(i)=='U')){
                ver=false;
                i=frase.length();
            }
        }
        return ver;
    }
    public static boolean consoantes (String frase){
        boolean ver=true;
        
        for(int i=0;i<frase.length();i++)
        {
            if((frase.charAt(i) >= 65 && frase.charAt(i) <= 90) || (frase.charAt(i) >= 97 && frase.charAt(i) <= 122)){
                if ((frase.charAt(i)=='A'||frase.charAt(i)=='a'||frase.charAt(i)=='O'||frase.charAt(i)=='o'||frase.charAt(i)=='i'||frase.charAt(i)=='I'||frase.charAt(i)=='E'||frase.charAt(i)=='e'||frase.charAt(i)=='u'||frase.charAt(i)=='U')){
                ver=false;
                i=frase.length();
            }}
            else{i=frase.length();ver=false;}
        }
        return ver;
    }

    public static boolean inteiro (String frase){
        boolean ver= true;
        for (int i=0; i<frase.length();i++)
        {
            if(frase.charAt(i)>=48&&frase.charAt(i)<=57){}
            else{ver=false; i=frase.length();}
        }
        return ver;
    }
    
    public static boolean real (String frase){
        boolean ver= true;
        int contador = 0;
        int contador2 = 0;
        for(int i = 0; i < frase.length(); i++)
        {
            if(contador <= 1 || contador2 <= 1)
            {

                if(frase.charAt(i) == '-' )
                { 
                    contador2++;                   
                }
                else if(frase.charAt(i) == ',' ||frase.charAt(i) == '.')
                {
                    contador++;
                }
                else if( frase.charAt(i) < 48 || frase.charAt(i) > 57){
                    i = frase.length();
                    ver=false;
                }
            }
            else if(contador >= 2||contador2 >= 2) i = frase.length();        
        }
        if(contador2 >= 2 || contador >= 2)ver=false;
        return ver;      
    }

    public static void main (String[] args){
        boolean veri=true;
        boolean test;
        String frase;
        
        while(veri){
            frase=MyIO.readLine();
            if(frase.length() == 3 && frase.charAt(0) == 'F' && frase.charAt(1) == 'I' && frase.charAt(2) == 'M')veri=false;
            if(veri){
                String nova="";
                test=vogais(frase);
                if(test) nova+="SIM";
                else nova+="NAO";
                test=consoantes(frase);
                if(test) nova+=" SIM";
                else nova+=" NAO";
                test=inteiro(frase);
                if(test) nova+=" SIM";
                else nova+=" NAO";
                test=real(frase);
                if(test) nova+=" SIM";
                else nova+=" NAO";
                MyIO.println(nova);
            }
        }}
}


