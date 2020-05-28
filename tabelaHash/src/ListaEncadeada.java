public class ListaEncadeada {
    private Node lista;

    public ListaEncadeada()
    {
        lista = null;
    }

    private boolean vazia()
    {
        return lista == null;
    }

    public void inserePrimeiro(int info)
    {
        Node newnode = new Node(info);
        if (!vazia()) newnode.setProximo(lista);
        lista = newnode;
    }

    public void insereDepois(Node node, int info)
    {
        if(vazia()) inserePrimeiro(info);
        else
        {
            Node newnode = new Node(info);
            newnode.setProximo(node.getProximo());
            node.setProximo(newnode);
        }
    }

    public void insereUltimo(int info)
    {
        Node aux = lista;
        if(vazia()) inserePrimeiro(info);
        else
        {
            Node newnode = new Node(info);
            while (aux.getProximo() != null)
            {
                aux = aux.getProximo();
            }
            aux.setProximo(newnode);
        }
    }

    public void insereOrdenado(int info)
    {
        Node aux = lista;
        Integer temp = null;
        if(vazia()) inserePrimeiro(info);
        else
        {
            while (aux != null)
            {
                if (aux.getInformacao() < info)
                {
                    temp = aux.getInformacao();
                    aux = aux.getProximo();
                }
                else
                {
                    if (info < aux.getInformacao()) inserePrimeiro(info);
                    else if (info == aux.getInformacao()) return;
                    else insereDepois(getNode(temp), info);
                    return;
                }
            }
            insereUltimo(info);
        }
    }

    public void imprime()
    {
        if (lista == null) System.out.print("Lista vazia");
        else
        {
            Node aux = lista;
            while(aux != null)
            {
                System.out.print(aux.getInformacao() + " ");
                aux = aux.getProximo();
            }
        }
    }

    public Node removePrimeiro()
    {
        Node aux = lista;
        lista = aux.getProximo();
        return aux;
    }

    public Node removeUltimo()
    {
        Node aux = lista;
        Node ref = aux;
        while (aux.getProximo() != null)
        {
            ref = aux;
            aux = aux.getProximo();
        }
        ref.setProximo(null);
        return aux;
    }

    public Node remove(Node node)
    {
        Node aux = lista;
        while (aux.getProximo() != node)
        {
            aux = aux.getProximo();
        }
        aux.setProximo(node.getProximo());
        return aux;
    }

    public Node getNode(int info) {
        Node aux = lista;
        if (vazia()) return null;
        while (aux.getProximo() != null)
        {
            if (aux.getInformacao() == info) return aux;
            aux = aux.getProximo();
        }
        return null;
    }
}
