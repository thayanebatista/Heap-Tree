package heap;

import java.util.Arrays;

/**
 *
 * @author ra159049
 */
public class Heap {

    private int elem[];
    private int n;

    //get e set de cada variavel
    public int[] getElem() {
        return elem;
    }

    public void setElem(int[] elem) {
        this.elem = elem;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    //construtor do heap criando um vetor de 100 posições por definição
    public Heap() {
        this.elem = new int[100];
        this.n = 0;

    }

    /**
     * funcao com intuito de trocar os valores de lugar quando necessario
     * subindo o valor de maior prioridade
     */
    private void subir(int i) {
        int p = i / 2; // a operaçao piso fica implicita 

        if (i > 1 && this.elem[i] > this.elem[p]) {
            int temp;

            temp = this.elem[i];
            this.elem[i] = this.elem[p];
            this.elem[p] = temp;
            subir(p);
        }
    }

    public void insere(int ch) {
        if (this.n < this.elem.length) {
            this.n = this.n + 1;
            this.elem[this.n] = ch;
            subir(this.n);
        }
    }

    /**
     * funcao sempre removera a raiz da arore logo em seguida chamando a funcao
     * descer que garantira a ordem da arvore
     *
     */
    public int remove(Heap h) {
        int ch;
        if (this.n == 0) {
            System.out.println("vazio!!!");
            ch = -1;
        } else {
            ch = this.elem[1];
            this.elem[1] = this.elem[this.n];
            this.n = this.n - 1;
            descer(1);//apos remoção da raiz da arvore se chama a funcao descer para reorganizar de maneira heap
        }
        return ch;
    }

    /**
     *
     * funcao descer sempre verificara a ordem dos elementos e fara as
     * alteraçoes, quando necessarias
     */
    private void descer(int i) {
        int f = 2 * i;

        if (f <= this.n) {
            if (f + 1 <= this.n && this.elem[f] < this.elem[f + 1]) {
                f = f + 1;
            }
            if (this.elem[i] < this.elem[f]) {
                int temp = this.elem[i];
                this.elem[i] = this.elem[f];
                this.elem[f] = temp;
                descer(f);
            }
        }
    }

    /**
     * funcao que exibira o vetor de moto heap sendo (2*i+1) o filho da esquerda
     * e (2*i+2) o filho da direita
     */
    public void exibirHeap() {
        if (this.n == 0) {
            System.out.println("vazio!!!"); ///mostra uma mensagem caso o vetor do heap esteja vazio
        } else {
            for (int i = 1; i <= this.n; i++) {
                System.out.print("|" + this.elem[i]);
            }
            System.out.print("|\n");
        }

    }

    public void Constroiheap(int i) {
        int f = 2 * i;

        if (f < this.n) {
            Constroiheap(f);
            if (f + 1 < this.n) {
                Constroiheap(f + 1);
            }
        }
        descer(i);
    }

    private int pai(int pos) {
        return pos / 2;
    }

    private int filhoEsquerda(int pos) {
        return (2 * pos);
    }

    private int filhoDireita(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * funcao que imprime de maneira descritiva a arcvore heap 
     * dizendo quem é o nó pai e quem são os nós filhos
     */
    public void printHeapEscrita() {
        for (int i = 1; i <= this.n / 2; i++) {
            System.out.print(" PAI: " + this.elem[i] + " || FILHO DA ESQUERDA: " + this.elem[2 * i]
                    + " || FILHO DA DIREITA: " + this.elem[2 * i + 1]);
            System.out.println();
        }
    }

    /**
     * essa funcao é a funcao que vai mostrar a arvore heap em formato de arvore
     * assim como estudamos
     * uma estrutura em triangulo quase completa ou completa
     * 
     */
    public void printHeapArvore() {
        StringBuilder sb = new StringBuilder();
        //int a[] = new int[] {84 ,81 ,41 ,79 ,17 ,38 ,33 ,15 }; vetor para teste
        /**
         * neste vetor para teste a funcao funciona perfeitamente
         * porem quando linkamos ao heap e seu n
         * ele nao esta considerando a segunda chave no vetor como um filho da esquerda da raiz
         * assim, a arvore nao sai identada como eu queria
         * até entao nao consegui achar o erro, onde alterar para que ele use a chave 2 como filho da raiz
         * 
         */
        int max = 0;
        for (int i = 1; i <= this.n; i++) {
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) < this.n; j++) { // se j menor que e elevado a i e j + 2 elevado ao i for menor que o n

                if (j > max) {
                    max = j; //incrementasse o j na variavel max
                }
            }

        }

        for (int i = 1; i <= this.n; i++) {
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) <= this.n; j++) {

                for (int k = 0; (k < max / ((int) Math.pow(2, i))); k++) {
                    sb.append("  ");
                }
                sb.append(this.elem[j + (int) Math.pow(2, i) - 1] + "  ");

            }
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }
}
