#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void main ()
{
    char nome[200];
    char nome2[200];

    while(scanf("%s",nome) != EOF)
    {
        scanf("%s",nome2);
        int i=0;
        while( i<strlen(nome) || i<strlen(nome2))
        {
            if(i<strlen(nome)) print("%c",nome[i]);
            if(i<strlen(nome2)) print("%c",nome2[i]);
            i++;
        }
    }
}