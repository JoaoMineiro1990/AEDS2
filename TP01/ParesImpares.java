public class ParesImpares
{
    public static int[] Ordenando ( int[] vetor)
    {
        int n = vetor.length;
        int paresIndex = 0;

        for (int i = 0; i < n; i++) 
        {
            if (vetor[i] % 2 == 0) 
            {
                int temp = vetor[i];
                vetor[i] = vetor[paresIndex];
                vetor[paresIndex] = temp;
                paresIndex++;
            }
        }
        for(int i = 0 ; i < paresIndex - 1 ; i++)
        {
            int temp = i;
            for(int j = i ; j < paresIndex ; j++)
            {
                if( vetor[j] < vetor[temp]) temp = j;
            }
            int temporario = vetor[i];
            vetor[i] = vetor[temp];
            vetor[temp] = temporario;
        }
        for(int i = paresIndex ; i < vetor.length - 1 ; i++)
        {
            int temp = i;
            for(int j = i + 1 ; j < vetor.length ; j++)
            {
                if( vetor[j] > vetor[temp]) temp = j;
            }
            int temporario = vetor[i];
            vetor[i] = vetor[temp];
            vetor[temp] = temporario;
        }
        return vetor;
    }
    public static void main (String[] args)
    {
        int n;
        n = MyIO.readInt();
        int[] array;
        array = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            array[i] = MyIO.readInt();
        }
        Ordenando(array);
        for(int i = 0 ; i < n ; i++)
        {
            MyIO.println(array[i]);
        }
    }
}