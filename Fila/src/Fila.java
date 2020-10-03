public class Fila {
    // o indice do primeiro elemento
    private int primeiro;
    // o indice do ultimo elemento
    private int ultimo;
    // armazenamento de dados
    private int[] dados;

    public Fila(int n) {
        this.primeiro = 0;
        this.ultimo = -1;
        inicializa(n);
    }

    private void inicializa(int n) {
        this.dados = new int[n];
    }

    private boolean cheia() {
        if(ultimo - primeiro == dados.length - 1) return true;
        else return false;
    }

    private boolean vazia() {
        if (ultimo == -1 || primeiro == dados.length) return true;
        else return false;
    }

    public void insere(int elemento) {
        if (!cheia()) {
            ultimo = ultimo + 1;
            dados[ultimo] = elemento;
        }
        else System.out.println("Fila cheia");
    }

    public void remove() {
        if(!vazia()) {
            primeiro = primeiro + 1;
        }
        else System.out.println("Fila vazia");
    }
    public void imprime() {
        for(int i = primeiro; i <= ultimo; i++) {
            System.out.println(dados[i]);
        }
    }

    public Integer getDados() {
        if(!vazia()) return dados[primeiro];
        else return null;
    }
}
