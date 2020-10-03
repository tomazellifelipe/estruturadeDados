public class ListaEncadeadaDupla {
    private Node lista;

    public ListaEncadeadaDupla() {
        this.lista = null;
    }

    public boolean vazia() {
        return lista == null;
    }

    public void inserePrimeiro(int info) {
        Node newnode = new Node(info);
        if (!vazia()) {
            lista.getAnterior().setProximo(newnode);
            newnode.setProximo(lista);
        }
        lista = newnode;
    }

    public void insereDepois(Node node, int info) {
        if(vazia()) {
            inserePrimeiro(info);
        }
        else {
            Node newnode = new Node(info);
            newnode.setProximo(node.getProximo());
            node.setProximo(newnode);
        }
    }

    public void insereUltimo(int info) {
        Node aux = lista;
        if(vazia()) {
            inserePrimeiro(info);
        }
        else {
            Node newnode = new Node(info);
            while (aux.getProximo() != lista) {
                aux = aux.getProximo();
            }
            aux.setProximo(newnode);
            newnode.setProximo(lista);
        }
    }

    public void insereOrdenado(int info) {
        Node aux = lista;
        if (vazia() || (aux.getProximo() == lista && aux.getInformacao() > info)) {
            inserePrimeiro(info);
        }
        else {
            while (aux.getProximo() != lista) {
                if (aux.getInformacao() < info) {
                    aux = aux.getProximo();
                }
                else if (aux == lista) {
                    inserePrimeiro(info);
                    return;
                }
                else {
                    insereDepois(aux.getAnterior(), info);
                    return;
                }
            }
            if (aux.getInformacao() < info) {
                insereUltimo(info);
            }
            else {
                insereDepois(aux.getAnterior(), info);
            }
        }
    }

    public Node removePrimeiro() {
        Node aux = lista;
        if (lista.getProximo() == lista) {
            lista = null;
        }
        else {
            lista = aux.getProximo();
            aux.getAnterior().setProximo(lista);
        }
        return aux;
    }

    public Node removeUltimo() {
        Node aux = lista;
        if (aux.getProximo() == lista) {
            lista = null;
        }
        else {
            aux.getAnterior().getAnterior().setProximo(lista);
        }
        return aux;
    }

    public Node remove(Node node) {
        if (lista.getProximo() == lista) {
            lista = null;
        }
        else if (node == lista) {
            removePrimeiro();
        }
        else if (node.getProximo() == lista) {
            removeUltimo();
        }
        else {
            Node aux = lista;
            while (aux.getProximo() != node) {
                aux = aux.getProximo();
            }
            aux.setProximo(node.getProximo());
        }
        return node;
    }

    public Node getNode(int info) {
        Node aux = lista;
        if(aux.getProximo() == lista && aux.getInformacao() == info) {
            return aux;
        }
        while (aux.getProximo() != lista) {
            if (aux.getInformacao() == info) {
                return aux;
            }
            aux = aux.getProximo();
        }
        if (aux.getInformacao() == info) {
            return aux;
        }
        else {
            return null;
        }
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Lista vazia");
        }
        else {
            Node aux = lista;
            while(aux.getProximo() != lista) {
                System.out.println("Elemento " + aux.getInformacao());
                aux = aux.getProximo();
            }
            System.out.println("Elemento " + aux.getInformacao());
        }
    }

    public Node getLista() {
        return lista;
    }
}
