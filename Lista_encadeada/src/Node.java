public class Node {
    private Integer informacao;
    private Node proximo;
    private Node anterior;

    public Node(Integer info) {
        this.informacao = info;
        this.proximo = this;
        this.anterior = this;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
        proximo.setAnterior(this);
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }

    public Integer getInformacao() {
        return informacao;
    }

    public Node getProximo() {
        return proximo;
    }

    public Node getAnterior() {
        return anterior;
    }
}
