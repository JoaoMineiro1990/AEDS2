public class Selecao {
	
	public void Swap (int a, int b)
	{
		int aux = a;
		a = b;
		b = aux;
	}
	
	public static void main (String[] args)
	{
		for(int i = 0 ; i < ( n - 1 ) ; i++)//sendo n o tamanho do array;
						    //para uma selecao parcial substituir o valor de k no (n-1);
		{
			int menorposicao = i ; 
			for ( int j = i +1 ; j < n ; j ++)
			{
				if(array[menor] > array[j]) menorposicao = j;
			}
			swap(menor , i);
		}

	}
}
