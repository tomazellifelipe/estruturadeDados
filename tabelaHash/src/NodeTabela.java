public class NodeTabela {
    private ListaEncadeada lista;
    private int informarcao;

    public NodeTabela(int informarcao) {
        this.informarcao = informarcao;
        this.lista = new ListaEncadeada();
    }

    public void setLista(int informarcao) {
        lista.insereOrdenado(informarcao);
    }

    public int getInformarcao() {
        return informarcao;
    }

    public ListaEncadeada getLista() {
        return lista;
    }
}
