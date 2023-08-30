public class Is {
    public void vogais (String frase){
        for(int i=0;i<frase.length();i++){
            if (!(frase.charAt(i)=='A'||frase.charAt(i)=='a'||frase.charAt(i)=='O'||frase.charAt(i)=='o'||frase.charAt(i)=='i'||frase.charAt(i)=='I'||frase.charAt(i)=='E'||frase.charAt(i)=='e'||frase.charAt(i)=='u'||frase.charAt(i)=='U')){
                MyIO.println("NAO");
                i=frase.length();
            }
        }
        MyIO.println("SIM");

    }
    public boolean consoantes (String frase){
        boolean ver=true;
        for(int i=0;i<frase.length();i++)
        {
            if ((frase.charAt(i)=='A'||frase.charAt(i)=='a'||frase.charAt(i)=='O'||frase.charAt(i)=='o'||frase.charAt(i)=='i'||frase.charAt(i)=='I'||frase.charAt(i)=='E'||frase.charAt(i)=='e'||frase.charAt(i)=='u'||frase.charAt(i)=='U')){
                ver=false;
                i=frase.length();
            }
        }
        if(ver==true){MyIO.println(" SIM");}
        else{MyIO.println(" NAO");}
        
        return ver;
    }

    public boolean inteiro (String frase){
        boolean ver= true;
        for (int i=0; i<frase.length();i++)
        {
            if(frase.charAt(i)>=30&&frase.charAt(i)<=39){}
            else{ver=false; i=frase.length();}
        }
        if(ver==true){MyIO.println(" SIM");}
        else{MyIO.println(" NAO");}
        
        return ver;
    }
    
    public boolean real (String frase){
        
    }
}
