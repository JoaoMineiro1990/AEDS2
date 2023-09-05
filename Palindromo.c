#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool palindromo(char* frase)
{
	int verificador=0;	
	for(int i=0; i<strlen(frase)/2;i++)
	{
        if(*(frase+i) < 0 && *(frase+i) > 127 && i != ((strlen(frase)/2)-1))
		{
			verificador = 1;
			i = strlen(frase);
		}
		else
		{
			if(*(frase+i) != *(frase+(strlen(frase)-i-1)))
			{
				if(*(frase+i) >= 0 && *(frase+i) <= 127)
				{	
					verificador = 1;
					i=strlen(frase);
				}
			}
		}
	}
	if (verificador==1)return false;
	else return true;
}

int main(void){

	char* frase=(char*)malloc(10000*sizeof(char));
	scanf(" %[^\n]",frase);
	while(strcmp(frase,"FIM")!=0)
    {		
	if(palindromo(frase)==true)printf("SIM\n");
	else printf("NAO\n");
	scanf(" %[^\n]",frase);
    }

	free(frase);
	return 0;
}
