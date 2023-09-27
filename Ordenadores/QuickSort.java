public class QuickSort {
	void Quick(int esq, int dir)
	{
		int i = esq;
		int j = dir;
		int pivo = array((esq+dir)/2);
		while ( i <= dir )
		{
			while ( array[i]< pivo ) i++;
			while ( array[j] > pivo) j--;
			if( i <= j )
			{
				Swap ( i , j );
				i++;
				j--;
			}
		}
		if(esq < j) Quick ( esq , j );
		if(i < dir) Quick ( i , dir );// para ordenacao parcial ( i < k && i < dir )
	}
}
