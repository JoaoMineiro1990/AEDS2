#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

double contComp=0;
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

void imprimir(Jogador obj) 
{
printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", obj.id, obj.nome,
obj.altura, obj.peso, obj.anoNascimento, obj.universidade,obj.cidadeNascimento, obj.estadoNascimento);  
}

void carregarDados(Jogador p[]) 
{
  FILE *arq = fopen("players.csv","r");
  char texto[1000];
  int virgula[7];
  int z=0;

  fscanf(arq,"%[^\n]",texto);
  int c = fgetc(arq);
  while (c != '\n');
  while(fscanf(arq,"%[^\n]",texto)!=EOF)
  {
    int c = fgetc(arq);
    while (c != '\n');

    // acha as vírgulas
    int n = 0;
    for (int i = 0; i < strlen(texto); i++) 
    {
      if (texto[i] == ',')
      {
        virgula[n] = i;
        n++;
      }
    }

    // separa o id
    char id[100];
    int cont=0;
    for (int i = 0; i < virgula[0]; i++) 
    {
      id[i] = texto[i];
      cont++;
    }
    id[cont]='\0';
    int identificador = atoi(id);
    p[z].id = identificador;

    // separa o nome
    char nome[100];
    cont = 0;
    for (int i = (virgula[0] + 1); i < virgula[1]; i++) 
    {
      nome[cont] = texto[i];
      cont++;
    }
    nome[cont] = '\0';
    strcpy(p[z].nome, nome);

    // separa a altura
    char altura[5];
    cont = 0;
    for (int i = (virgula[1] + 1); i < virgula[2]; i++) {
      altura[cont] = texto[i];
      cont++;
    }
    altura[cont] = '\0';
    int alt = atoi(altura);
    p[z].altura = alt;


    // separa o peso
    char peso[4];
    cont = 0;
    for (int i = (virgula[2] + 1); i < virgula[3]; i++) {
      peso[cont] = texto[i];
      cont++;
    }
    peso[cont] = '\0';
    int pesagem = atoi(peso);
    p[z].peso = pesagem;

    // separa a universidade
    char universidade[100];

    if (virgula[4] - virgula[3] == 1) strcpy(universidade, "nao informado");
    else 
    {
        cont = 0;
        for (int i = (virgula[3] + 1); i < virgula[4]; i++) 
            {
                universidade[cont] = texto[i];
                cont++;
            }
        universidade[cont] = '\0';
    }
    strcpy(p[z].universidade, universidade);

    // separa o ano
    char ano[5];
    cont = 0;
    for (int i = (virgula[4] + 1); i < virgula[5]; i++)
    {
      ano[cont] = texto[i];
      cont++;
    }
    ano[cont] = '\0';
    int nascimento = atoi(ano);
    p[z].anoNascimento = nascimento;

    // separa a cidade
    char cidade[100];
    if (virgula[6] - virgula[5] == 1)strcpy(cidade, "nao informado"); 
    else
    {
    cont = 0;
    for (int i = (virgula[5] + 1); i < virgula[6]; i++)
      {
        cidade[cont] = texto[i];
        cont++;
      }
      cidade[cont] = '\0';
    }  
    strcpy(p[z].cidadeNascimento, cidade);

    // separa o estado
    char estado[100];
    if ( strlen(texto) - virgula[6]==1)strcpy(estado, "nao informado"); 
    else
    {
    cont = 0;
        for (int i = (virgula[6] + 1); i < strlen(texto); i++) 
        {
            estado[cont] = texto[i];
            cont++;
        }
        estado[cont] = '\0';
    }
    strcpy(p[z].estadoNascimento, estado);

    z++;
}
fclose(arq);
}

Jogador clone(Jogador jg)
{
    Jogador obj;
    obj.id = jg.id;
    obj.altura = jg.altura;
    obj.peso = jg.peso;
    strcpy(obj.nome,jg.nome);
    obj.anoNascimento = jg.anoNascimento;
    strcpy(obj.universidade,jg.universidade);
    strcpy(obj.cidadeNascimento,jg.cidadeNascimento);
    strcpy(obj.estadoNascimento,jg.estadoNascimento); 

    return obj;
}

void mostrar(Jogador jg[],int tam)
{
  for (int n = 0; n < tam; n++)
    {
      imprimir(jg[n]);
    }
} 

Jogador achar(Jogador jg[], int numero)
{
  Jogador pessoas;
  for(int k=0;k<3922;k++)
  {
    if(numero==jg[k].id)
    {
      pessoas = clone(jg[k]);
      k=3922;
    }
  }
  return pessoas;
}

int main()
{
  // clock_t inicio,fim;
  // double tempo;
  // inicio = clock();
  Jogador jg [3923];
  carregarDados(jg);

  Jogador pessoas[1000];
  int numero;
  int p = 0;
  char str[5];
  scanf("%s",str);
  while(strcmp(str,"FIM")!=0)
  {
    numero = atoi(str);
    pessoas[p] = achar(jg,numero);
    imprimir(pessoas[p]);
    p++;
    scanf("%s",str);
  }
  // //registro de log 
  // double comparacoes = contComp;
  // fim = clock();
  // tempo = (double)(fim-inicio)/CLOCKS_PER_SEC;
  // FILE *arq = fopen("816594_binaria.txt","w");
  // fprintf(arq,"816594\t %.0lf comparacoes\t %.4lf segundos\t",comparacoes,tempo);
  // fclose(arq);
  return 0;
}