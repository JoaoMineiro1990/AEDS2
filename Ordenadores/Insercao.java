public class Insercao {
	
	public static void main (String[] args)
	{
		//insercao padrao
		//n = tamanho do array comecando em 0
		for(int i = 1 ; i < n ; i++)
		{
			int aux = array[i] ;
			int j = i - 1 ;
			//se for  insercao parcial
			//if( i < k) j = i - 1;
			//else j = k - 1;
			//sendo k o ponto que vc deseja
			while ( (j >= 0) && (array[j] > aux) )
				{
					array[ j + i ] = array [ j ];
					j--;
				}
			array[ j + 1 ] = aux;
		}
		
		
	}

}
