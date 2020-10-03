public class Pilha {
    private ListaEncadeadaDupla pilha;

    public Pilha() {
        this.pilha = new ListaEncadeadaDupla();
    }

    public boolean vazia() {
        return pilha.vazia();
    }

    public void empilha(int dado) {
        pilha.insereUltimo(dado);
    }

    public Node desempilha() {
        Node inicio = pilha.getLista();
        Node aux = inicio;
        while (aux.getProximo() != inicio)
            aux = aux.getProximo();
        pilha.removeUltimo();
        return aux;
    }

    public Integer topo(){
        Node inicio = pilha.getLista();
        Node aux = inicio;
        if(vazia()) {
            return null;
        }
        else if (aux.getProximo() == inicio) {
            return aux.getInformacao();
        }
        while (aux.getProximo() != inicio) {
            aux = aux.getProximo();
        }
        return aux.getInformacao();
    }

    public void mostrar_pilha() {
        pilha.imprime();
    }
}
