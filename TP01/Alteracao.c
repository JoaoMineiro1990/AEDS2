#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

char *alterar(char *frase, char a, char b) 
{
    char *nova = malloc(strlen(frase) + 1);
    for (int i = 0; frase[i] != '\0'; i++) 
    {
        if (frase[i] == a)nova[i] = b;
        else nova[i] = frase[i];
    }
    nova[strlen(frase)] = '\0';
    return nova;
}

int main() 
{
    srand(4);
    char escrita[100];
    int ver = 1;
    while (ver == 1) 
    {   
        fgets(escrita, sizeof(escrita), stdin);
        if (escrita[0] == 'F' && escrita[1] == 'I' && escrita[2] == 'M') {
            ver = 0;
        }
        if (ver == 1) 
        {
            char letra = 'a' + (rand() % 26);
            char trocar = 'a' + (rand() % 26);
            char *novaFrase = alterar(escrita, letra, trocar);
            printf("%s", novaFrase);
            free(novaFrase);
        }
    }
    
    return 0;
}