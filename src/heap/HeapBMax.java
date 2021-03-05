package heap;

import java.util.Scanner;

/**
 * @author 
 * Nome: Thayane Batista RA159049 
 * Instituição: Universidade Católica Dom Bosco
 * DIsciplina: Estrutura de Dados II
 * Professor: Me. Marcos Alves
 * Ano: 2019
 */


public class HeapBMax {

    /**
     * Constituição do código para implementação de uma Arvore Heap de Prioridade
     * Max-Heap, onde os maiores valores tem maior prioridade
     * assim, estaão no mais alto lugar de sua isolada arvore
     */
    
    
    /**
     * codigos auxiliares utulizados como base para o entendimento da materia e de sua implementação:
     * o do proprio professor
     * blogs como:  github, stackoverflow, dev media, geeksforgeeks
     *  
     */
    public static void main(String[] args) {
        /**
         * Utilizarei um menu simples, que pedira as informações pela barra de execução
         * Obs.:  Tentei utilizar o arquivo LE.java mas não obtive sucesso.
         * Acredito que seja pela minha falta de experiência com a linguagem java
         */
        
        int op = -1; // variavel utilizada para switch/case
        int temp; //viariavel temporaria 
        
        Scanner y = new Scanner(System.in);
        Heap h = new Heap();
                
        
        while (op != 0) {
            
            //EXIBE O MENU GERAL
            System.out.println("*-----------MENU----------*");
            System.out.println("| 1- Insere               |");
            System.out.println("| 2- Remove               |");
            System.out.println("| 3- Exibe vetor          |");
            System.out.println("| 4- Mostra Heap escrita  |");
            System.out.println("| 5- Mostrar arvore       |");
            System.out.println("| 0- Sair                 |");
            System.out.println("*-------------------------*");
            op = y.nextInt();

            
            switch (op) {
                case 1:
                    System.out.println("Valor para inserir: ");
                    // leitura do y
                    temp = y.nextInt();
                    h.insere(temp);
                break;

                case 2:
                    System.out.println("Remoção concluida.");
                    // Remove a primeira chave
                    h.remove(h);
                break;
                case 3:
                    System.out.println("Exibindo: ");
                    // Exibindo a Arvore
                    h.exibirHeap();
                break;
                case 4: 
                    System.out.println("Mostra Heap escrita:");
                    h.printHeapEscrita();
                    break;
                case 5:
                    System.out.println("Mostrando Heap em Arvore:\n\n");
                    h.printHeapArvore();
                    break;
                case 0:
                    System.out.println("*-------------*");
                    System.out.println("| FINALIZANDO |");
                    System.out.println("*-------------*");
                break;

                default:
                    System.out.println("| OPÇAO INVÁLIDA |");
                break;
            }
        }
    }
    
}
