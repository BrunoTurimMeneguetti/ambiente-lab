/*
**TAD de Lista** baseado em **array estático**, onde cada **elemento** da lista é uma 
estrutura (`ELEMENTO`) que possui uma **chave** (e pode conter outros campos adicionais).

### Estruturas principais
- `TIPOCHAVE`: tipo da chave (aqui usamos `int`).
- `ELEMENTO`: representa um item da lista (contém pelo menos uma chave).
- `LISTA`: contém o array de elementos e o número atual de elementos (`nroElem`).

### Operações
- `inicializarLista` → inicia lista vazia.
- `exibirLista` → imprime os elementos da lista.
- `tamanhoLista` → retorna o número de elementos.
- `insereElementoFim` → insere no final.
- `insereElementoInicio` → insere no início.
- `insereElementoPosicao` → insere em posição específica.
- `removeElementoFim` → remove o último.
- `removeElementoInicio` → remove o primeiro.
- `buscaElemento` → busca por chave e retorna índice.
- `removeElementoChave` → remove elemento pela chave.
*/
#include <stdio.h>
#define MAX 50
// Definição do tipo da chave
typedef int TIPOCHAVE;

// Estrutura de um elemento da lista
typedef struct {
    TIPOCHAVE chave;
    // outros campos podem ser adicionados aqui (ex.: nome, idade...)
} ELEMENTO;

// Estrutura da lista (array de ELEMENTO + contador de elementos)
typedef struct {
    ELEMENTO A[MAX];
    int nroElem;
} LISTA;

//inicializa a lista:
void inicializarLista(LISTA *lista){
    lista->nroElem = 0;
}
//'exibirLista' -> imprime os elementos da lista.
void exibirLista(LISTA *lista){
    printf("LISTA:");
    for(int i=0; i<lista->nroElem;i++){
        printf("%d ",lista->A[i].chave);
    }
}
//retorna tamanhoLista
int tamanhoLista(LISTA *lista){
    return lista->nroElem;
}
//insere elemento no final da lista
int insereElementoFim(LISTA *lista, ELEMENTO elem){
    if(lista->nroElem>=MAX){
        return 0;
    }else{
        lista->A[lista->nroElem] = elem;
        lista->nroElem++;
        return 1;
    }
}
//inserir elemento no inicio da lista
int insereElementoInicio(LISTA *lista, ELEMENTO elem){
    if(lista->nroElem>=MAX){
        return 0;
    }else{
        for(int i=lista->nroElem;i>0;i--){
            lista->A[lista->nroElem] = lista->A[lista->nroElem-1];
        }
        lista->A[0] = elem;
        lista->nroElem++;
        return 1;


    }
}


int main(void){
    LISTA lista1;
    LISTA lista2;
    ELEMENTO e;
    e.chave = 1000;
    inicializarLista(&lista1);
    inicializarLista(&lista2);
    inicializarInicio(&lista1,e);
    inicializarFim(&lista1,e);
    exibirlista(&lista1);
    tamanhoLista(&lista1);
    int t = tamanhoLista(&lista1);
    printf("tamanho da lista e: %d",t);
}