public class Pilha {
    // indice do elemento no topo da pilha
    private int topo;
    // armazenamento de dados
    private Integer[] dados;
    // quantidade maxima de elementos
    private int max;

    public Pilha(int max) {
        this.max = max;
        cria_pilha(this.max);
    }

    // retorna o elemento no topo da pilha
    private int topo() {
        return topo;
    }
    // retonar se a pilha está vazia
    public boolean vazia() {
        if (dados == null) return true;
        else return false;
    }
    // retorn se a pilha está cheia
    public boolean cheia() {
        if (dados[max-1] != null) return true;
        else return false;
    }
    // coloca o elemento na pilha
    public void empilha(int elemento)  {
        for (int i = 0; i < max; i++)
            if (dados[i] == null) {
                this.topo = elemento;
                dados[i] = topo;
                return;
        }
        for (int i = 1; i < dados.length; i++) {
            if (dados[i] == null) {
                dados[i] = elemento;
            }
        }
    }
    // retira o elemento da pilha
    public int desempilha(int index) {
        dados[index] = null;
        return topo();
    }
    // cria uma pilha capaz de armazenar ate n elementos
    public void cria_pilha(int n) {
        this.dados = new Integer[n];
    }
}
