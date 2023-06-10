import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        TextResources archives = new TextResources();
        HashColisaoExterior tabelaHash = new HashColisaoExterior(26);

        //Inserir palavras-chave na tabela hash
        for(int i = 0; i < archives.keys.length; i++){
            String palavra = archives.keys[i];
            ListaDuplamenteEncadeada listaLinha = new ListaDuplamenteEncadeada();
            PalavraChave objetoPalavra = new PalavraChave(palavra, listaLinha);
            tabelaHash.insere(objetoPalavra);
        }

        //Comparar palavras no texto com palavras-chave guardadas na tabela hash
        for(int j = 0; j < archives.text.length; j++){         //caminha por cada linha do texto
            String frase = archives.text[j];                   //pega a frase da linha j
            String[] palavrasFrase = frase.split(" ");   // separa as palavras da linha j e coloca no array
            for (int k = 0; k < palavrasFrase.length; k++) {  //percorre o array de palavras de cada linha
                ListaDuplamenteEncadeada listaPalavraFrase = new ListaDuplamenteEncadeada();
                PalavraChave palavraFrase = new PalavraChave(palavrasFrase[k],listaPalavraFrase); // transforma a palavra em análise em objeto palavra-chave
                if (tabelaHash.contem(palavraFrase) && !tabelaHash.posicao(palavraFrase).elemento.listaLinhas.contem(j+1)) {
                    tabelaHash.posicao(palavraFrase).elemento.listaLinhas.insereFinal(j+1);
                }
            }
        }

        PrintStream console = System.out;
        //Cria um console fictício, apenas para pegar o que está sendo printado no tabelaHash.imprime()
        ByteArrayOutputStream writeConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(writeConsole));
        tabelaHash.imprime();
        //Volta ao console original
        System.setOut(console);

        //PERCORRER TODAS AS LINHAS (i) DO ARQUIVO DE TEXTO
        console.println("------- TEXTO -------");
        for(int i = 0; i < archives.text.length; i++) {
            console.println(archives.text[i]);
        }
        //PERCORRER TODAS AS PALAVRAS-CHAVE (i) DO ARQUIVO DE CHAVES
        console.println("------- PALAVRAS-CHAVE -------");
        for(int i = 0; i < archives.keys.length; i++) {
            console.println(archives.keys[i]);
        }
        //ESCREVER NO ARQUIVO indice.txt
        archives.writeIndex(writeConsole);

        console.println("------- ÍNDICE REMISSIVO -------");
        tabelaHash.imprime();
    }
}