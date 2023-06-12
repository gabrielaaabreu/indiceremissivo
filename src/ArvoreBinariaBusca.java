class ArvoreBinariaBusca {
    class Nodo {

        public PalavraChave elemento;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(PalavraChave elemento) {
            this.elemento = elemento;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    public Nodo raiz;
    public int nElementos;

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public void imprimeEmOrdem() {
        this.emOrdem(this.raiz);
        //System.out.println();
    }

    public void emOrdem(Nodo nodo) {

        if (nodo == null)
            return;

        this.emOrdem(nodo.esquerdo);
        System.out.print(nodo.elemento.chave + " ");
        nodo.elemento.listaLinhas.imprime();
        this.emOrdem(nodo.direito);
    }

    public void insereABB(PalavraChave elemento) {
        this.insere(elemento, this.raiz);
    }

    public void insere(PalavraChave elemento, Nodo nodo) {

        Nodo novo = new Nodo(elemento);

        if (nodo == null) {
            this.raiz = novo;
            this.nElementos++;
            return;
        }

        if (elemento.chave.compareTo(nodo.elemento.chave) < 0) {
            if (nodo.esquerdo == null) {
                nodo.esquerdo = novo;
                this.nElementos++;
                return;
            } else {
                this.insere(elemento, nodo.esquerdo);
            }
        }

        if (elemento.chave.compareTo(nodo.elemento.chave) > 0) {
            if (nodo.direito == null) {
                nodo.direito = novo;
                this.nElementos++;
                //return;
            } else {
                this.insere(elemento, nodo.direito);
            }
        }
    }

    public boolean busca(PalavraChave elemento) {
        return this.busca(elemento, this.raiz);

    }

    public boolean busca(PalavraChave elemento, Nodo nodo) {

        if (nodo == null) {
            return false;
        }

        if (elemento.chave.compareTo(nodo.elemento.chave) < 0) {
            return this.busca(elemento, nodo.esquerdo);
        } else if (elemento.chave.compareTo(nodo.elemento.chave) > 0) {
            return this.busca(elemento, nodo.direito);
        } else {
            return true;
        }
    }

    public Nodo buscaPosicao(PalavraChave elemento) {
        return this.buscaPosicao(elemento, this.raiz);

    }

    public Nodo buscaPosicao(PalavraChave elemento, Nodo nodo) {

        if (nodo == null) {
            return null;
        }

        if (elemento.chave.compareTo(nodo.elemento.chave) < 0) {
            return this.buscaPosicao(elemento, nodo.esquerdo);
        } else if (elemento.chave.compareTo(nodo.elemento.chave) > 0) {
            return this.buscaPosicao(elemento, nodo.direito);
        } else {
            return nodo;
        }
    }
}
