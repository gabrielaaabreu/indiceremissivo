class ListaDuplamenteEncadeada {
    class Nodo {

        public int elemento;
        public Nodo proximo;
        public Nodo anterior;

        public Nodo(int elemento) {
            this.elemento = elemento;
            this.proximo = null;
            this.anterior = null;
        }
    }

    private Nodo inicio;
    private Nodo fim;
    private int nElementos;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.nElementos = 0;
    }

    public boolean estaVazia() {
        return this.nElementos == 0;
    }

    public void imprime() {
        Nodo cursor = this.inicio;
        for(int i=0;i<this.nElementos;i++) {
            System.out.print(cursor.elemento + " ");
            cursor = cursor.proximo;
        }
        System.out.println();
    }


    public void insereFinal(int elemento) {

        Nodo novo = new Nodo(elemento);

        if(this.estaVazia()) {
            this.inicio = novo;
        } else {
            this.fim.proximo = novo;
            novo.anterior = this.fim;
        }

        this.fim = novo;

        this.nElementos++;
    }


    public boolean contem(int elemento) {

        Nodo cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {
            if(cursor.elemento == elemento) {
                return true;
            }
            cursor = cursor.proximo;
        }

        return false;
    }

}
