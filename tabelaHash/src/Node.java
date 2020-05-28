public class Node {
    private Integer informacao;
    private Node proximo;

    public Node(Integer info) {
        this.informacao = info;
        this.proximo = null;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Integer getInformacao() {
        return informacao;
    }

    public Node getProximo() {
        return proximo;
    }
}
