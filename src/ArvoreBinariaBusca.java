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

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

            /*public void imprimeEmLargura() {

                Fila<Nodo> fila = new Fila<Nodo>();

                fila.enfileira(this.raiz);
                while (!fila.estaVazia()) {

                    Nodo cursor = fila.desenfileira();

                    System.out.print(cursor.elemento + " ");

                    if (cursor.esquerdo != null) {
                        fila.enfileira(cursor.esquerdo);
                    }

                    if (cursor.direito != null) {
                        fila.enfileira(cursor.direito);
                    }
                }

                System.out.println();

            }*/

    public void imprimePreOrdem() {
        this.preOrdem(this.raiz);
        System.out.println();
    }

    public void imprimePosOrdem() {
        this.posOrdem(this.raiz);
        System.out.println();
    }

    public void imprimeEmOrdem() {
        this.emOrdem(this.raiz);
        //System.out.println();
    }

    public void preOrdem(Nodo nodo) {

        if (nodo == null)
            return;

        System.out.print(nodo.elemento + " ");
        this.preOrdem(nodo.esquerdo);
        this.preOrdem(nodo.direito);
    }

    public void posOrdem(Nodo nodo) {

        if (nodo == null)
            return;

        this.posOrdem(nodo.esquerdo);
        this.posOrdem(nodo.direito);
        System.out.print(nodo.elemento + " ");
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

    private Nodo maiorElemento(Nodo nodo) {
        while (nodo.direito != null) {
            nodo = nodo.direito;
        }
        return nodo;
    }

    private Nodo menorElemento(Nodo nodo) {
        while (nodo.esquerdo != null) {
            nodo = nodo.esquerdo;
        }
        return nodo;
    }

    public boolean remove(PalavraChave elemento) {
        return this.remove(elemento, this.raiz) != null;
    }

    private Nodo remove(PalavraChave elemento, Nodo nodo) {

        if (nodo == null) {
            System.out.println("Valor não encontrado");
            return null;
        }

        if (elemento.chave.compareTo(nodo.elemento.chave) < 0) {
            nodo.esquerdo = this.remove(elemento, nodo.esquerdo);
        } else if (elemento.chave.compareTo(nodo.elemento.chave) > 0) {
            nodo.direito = this.remove(elemento, nodo.direito);
        } else {

            //	    	if(nodo.esquerdo == null && nodo.direito == null) {
            //	    		return null;
            //	    	}

            if (nodo.esquerdo == null) {
                this.nElementos--;
                return nodo.direito;
            } else if (nodo.direito == null) {
                this.nElementos--;
                return nodo.esquerdo;
            } else {
                Nodo substituto = this.menorElemento(nodo.direito);
                nodo.elemento = substituto.elemento;
                this.remove(substituto.elemento, nodo.direito);
            }
        }

        return nodo;
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

    private int altura(Nodo nodo) {

        if (nodo == null) {
            return -1;
        }

        int alturaEsquerda = this.altura(nodo.esquerdo) + 1;
        int alturaDireita = this.altura(nodo.direito) + 1;

        int altura = alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;

        return altura;

    }

    public int altura() {
        return this.altura(this.raiz);
    }
}