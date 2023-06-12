class HashColisaoExterior {

    public ArvoreBinariaBusca vetor[];
    public int nElementos;

    public HashColisaoExterior(int capacidade) {
        this.vetor = new ArvoreBinariaBusca[capacidade];
        for (int i = 0; i < vetor.length; i++) {
            this.vetor[i] = new ArvoreBinariaBusca();
        }
        this.nElementos = 0;
    }

    public void imprime() {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i].imprimeEmOrdem();
        }
    }

    private int funcaoHashDiv(PalavraChave elemento) {

        return elemento.posicaoHash();
    }

    public void insere(PalavraChave elemento) {
        int endereco = funcaoHashDiv(elemento);
        this.vetor[endereco].insereABB(elemento);
        this.nElementos++;
    }

    public boolean contem(PalavraChave elemento){
        int endereco = funcaoHashDiv(elemento);
        return this.vetor[endereco].busca(elemento);
    }

    public ArvoreBinariaBusca.Nodo posicao(PalavraChave elemento) { //retorna o nodo da árvore binária de busca onde está o elemento
        int endereco = funcaoHashDiv(elemento);
        return this.vetor[endereco].buscaPosicao(elemento);
    }
}
