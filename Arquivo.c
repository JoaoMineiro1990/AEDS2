#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>

int main() {
    int entradas;

    scanf("%d", &entradas);

    FILE *arquivo = fopen("valores.txt", "w");

    for (int i = 0; i < entradas; i++) {
        float valor;
        scanf("%f", &valor);
        fprintf(arquivo, "%f\n", valor);
    }

    fclose(arquivo);

    arquivo = fopen("valores.txt", "r");

    float *valores = malloc(entradas * sizeof(float));

    for (int i = 0; i < entradas; i++) 
    {
        fscanf(arquivo, "%f", &valores[i]);
    }
    fclose(arquivo);

    for (int i = entradas - 1; i >= 0; i--) 
    {
        int valor2=valores[i]*10000;
        if(valores[i]-(int)valores[i]==0)
        {
            printf("%d\n",(int)valores[i]);
        }
        else if(valor2%1000 == 0)
        {
            printf("%.1f\n",valores[i]);
        }
        else if(valor2%100 == 0)
        {
            printf("%.2f\n",valores[i]);
        }
        else
        {
           printf("%.3f\n",valores[i]); 
        }
    }

    free(valores);

    return 0;
}
