import java.util.List;

class PalavraChave {
    String chave;
    ListaDuplamenteEncadeada listaLinhas;

    public PalavraChave(String chave, ListaDuplamenteEncadeada listaLinhas){
        this.chave = chave;
        this.listaLinhas = listaLinhas;
    }
    public int posicaoHash(){  //retorna índice da posição daquela chave na tabela hash
        char primeiraLetra = chave.charAt(0);
        return (int) primeiraLetra - 97;
    }
}
