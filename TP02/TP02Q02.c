#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Jogador
{
    int id;
    char nome[100];
    int altura;
    int peso;
    char universidade[100];
    int anoNascimento;
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

void ler(Jogador J[])
{
    char Arquivo[] = "/tmp/players.csv";
    char frase1[400];

    FILE *leitura = fopen(Arquivo, "r");
    fscanf(leitura, "%[^\n]", frase1);

    int k = 0;
    while (fscanf(leitura, " %[^\n]", frase1) != EOF)
    {
        char *temp;

        temp = strtok(frase1, ",");
        if (temp) J[k].id = atoi(temp);

        temp = strtok(NULL, ",");
        if (temp) strncpy(J[k].nome, temp, sizeof(J[k].nome));
        else strncpy(J[k].nome, "nao informado", sizeof(J[k].nome));

        temp = strtok(NULL, ",");
        if (temp) J[k].altura = atoi(temp);
        else J[k].altura = 0;

        temp = strtok(NULL, ",");
        if (temp) J[k].peso = atoi(temp);
        else J[k].peso = 0;

        temp = strtok(NULL, ",");
        if (temp) strncpy(J[k].universidade, temp, sizeof(J[k].universidade));
        else strncpy(J[k].universidade, "nao informado", sizeof(J[k].universidade));

        temp = strtok(NULL, ",");
        if (temp) J[k].anoNascimento = atoi(temp);
        else J[k].anoNascimento = 0;

        temp = strtok(NULL, ",");
        if (temp) strncpy(J[k].cidadeNascimento, temp, sizeof(J[k].cidadeNascimento));
        else strncpy(J[k].cidadeNascimento, "nao informado", sizeof(J[k].cidadeNascimento));

        temp = strtok(NULL, ",");
        if (temp) strncpy(J[k].estadoNascimento, temp, sizeof(J[k].estadoNascimento));
        else strncpy(J[k].estadoNascimento, "nao informado", sizeof(J[k].estadoNascimento));

        k++;
    }
    fclose(leitura);
}

void imprimir(Jogador impr)
{
    // Jogador obj;
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", impr.id, impr.nome,
           impr.altura, impr.peso, impr.anoNascimento, impr.universidade,
           impr.cidadeNascimento, impr.estadoNascimento);
}

Jogador Clonar(Jogador vetor[], int id) 
{
  for (int i = 0; i < 3923; i++) 
  {
    if (id == vetor[i].id) 
    {
      return vetor[i];
    }
  }
}

int main(void)
{
    Jogador jogadores[3900];
    Jogador IMP[4001];
    char str[10];
    int i = 0;
    ler(jogadores);

    scanf("%s", str);

    while (strcmp(str, "FIM") != 0) 
    {
    int index = atoi(str);
    IMP[i] =  Clonar(jogadores, index);
    imprimir(IMP[i]);
    scanf("%s", str);
    i++;
    }
    return 0;
}