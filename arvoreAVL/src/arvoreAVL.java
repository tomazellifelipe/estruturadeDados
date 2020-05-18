public class arvoreAVL {
    private Node raiz;

    public arvoreAVL() {
        this.raiz = null;
    }
    private boolean vazia() {
        return this.raiz == null;
    }

    public void insereElemento(int info) {
        Node folha = new Node(info);
        if (vazia()) this.raiz = folha;

        else {
            arvoreAVL arvore = new arvoreAVL();
            if (info < this.raiz.getInfo()) {
                if (this.raiz.getEsquerda() != null) {
                    arvore.raiz = this.raiz.getEsquerda();
                    arvore.insereElemento(info);
                    arvore.verificaBalanceamento();
                    this.raiz.setEsquerda(arvore.raiz);
                }
                else this.raiz.setEsquerda(folha);
            }

            else if (info > this.raiz.getInfo()) {
                if (this.raiz.getDireita() != null) {
                    arvore.raiz = this.raiz.getDireita();
                    arvore.insereElemento(info);
                    arvore.verificaBalanceamento();
                    this.raiz.setDireita(arvore.raiz);
                }
                else this.raiz.setDireita(folha);
            }
        }
        this.verificaBalanceamento();
    }

    public Node removeMaior() {
        arvoreAVL arvore = new arvoreAVL();
        if (vazia()) System.out.println("Arvore vazia");
        else if (this.raiz.getDireita() == null)
        {
            Node removido = this.raiz;
            if (this.raiz.getEsquerda() == null) this.raiz = null;
            else this.raiz = this.raiz.getEsquerda();
            return removido;
        }

        else {
            arvore.raiz = this.raiz.getDireita();
            arvore.removeMaior();
            this.raiz.setDireita(arvore.raiz);
        }
        return null;
    }

    public Node removeMenor() {
        arvoreAVL arvore = new arvoreAVL();
        if (vazia()) System.out.println("Arvore vazia");
        else if (this.raiz.getEsquerda() == null)
        {
            Node removido = this.raiz;
            if (this.raiz.getDireita() == null) this.raiz = null;
            else this.raiz = this.raiz.getDireita();
            return removido;
        }

        else {
            arvore.raiz = this.raiz.getEsquerda();
            arvore.removeMenor();
            this.raiz.setEsquerda(arvore.raiz);
        }
        return null;
    }

    public Node remove(int info) {
        arvoreAVL arvore = new arvoreAVL();
        if (vazia()) System.out.println("Arvore vazia");
        else if (info == this.raiz.getInfo())
        {
            Node removido = this.raiz;
            if (this.raiz.getDireita() == null && this.raiz.getEsquerda() == null) this.raiz = null;
            else if (this.raiz.getEsquerda() == null) this.raiz = this.raiz.getDireita();
            else if (this.raiz.getDireita() == null) this.raiz = this.raiz.getEsquerda();
            else {
                arvoreAVL arvore2 = new arvoreAVL();
                arvore2.raiz = this.raiz.getEsquerda();
                while (arvore2.raiz.getDireita() != null)
                {
                    arvore2.raiz = arvore2.raiz.getDireita();
                }
                this.raiz.setInfo(arvore2.raiz.getInfo());
                arvore2.raiz = this.raiz.getEsquerda();
                arvore2.removeMaior();
                this.raiz.setEsquerda(arvore2.raiz);

            }
            return removido;
        }
        else if (info < this.raiz.getInfo())
        {
            arvore.raiz = this.raiz.getEsquerda();
            arvore.remove(info);
            this.raiz.setEsquerda(arvore.raiz);
        }
        else if (info > this.raiz.getInfo())
        {
            arvore.raiz = this.raiz.getDireita();
            arvore.remove(info);
            this.raiz.setDireita(arvore.raiz);
        }
        this.verificaBalanceamento();
        return null;
    }

    public Node buscar(int elemento)
    {
        Node atual = raiz;
        while (atual != null && atual.getInfo() != elemento)
        {
            if (atual.getInfo() > elemento) atual = atual.getEsquerda();
            else atual = atual.getDireita();
        }
        return null;
    }

    public int altura(Node no)
    {
        if (no == null) return -1;
        int esquerda = altura(no.getEsquerda());
        int direita = altura(no.getDireita());
        if (esquerda > direita) return 1 + esquerda;
        return 1 + direita;
    }

    public int balanceamento(Node no)
    {
        if (no == null) return 0;
        return altura(no.getEsquerda()) - altura(no.getDireita());
    }

    public void verificaBalanceamento()
    {
        arvoreAVL arvoreTemp = new arvoreAVL();
        if (vazia()) return;
        if (this.balanceamento(this.raiz) >= 2 || this.balanceamento(this.raiz) <= -2)
        {
            if (this.balanceamento(this.raiz) >= 2)
            {
                if (this.balanceamento(this.raiz) * this.balanceamento(this.raiz.getEsquerda()) < 0)
                {
                    arvoreTemp.raiz = this.raiz.getEsquerda();
                    this.raiz.setEsquerda(arvoreTemp.rotacaoEsquerda());

                }
                this.raiz = this.rotacaoDireita();
            }
            else
            {
                if (this.balanceamento(this.raiz) * this.balanceamento(this.raiz.getDireita()) < 0)
                {
                    arvoreTemp.raiz = this.raiz.getDireita();
                    this.raiz.setDireita(arvoreTemp.rotacaoDireita());
                }
                this.raiz = this.rotacaoEsquerda();
            }
        }
    }

    public Node rotacaoDireita()
    {
        Node novaRaiz = raiz.getEsquerda();
        Node temp = novaRaiz.getDireita();
        novaRaiz.setDireita(raiz);
        raiz.setEsquerda(temp);
        return novaRaiz;
    }

    public Node rotacaoEsquerda()
    {
        Node novaRaiz = raiz.getDireita();
        Node temp = novaRaiz.getEsquerda();
        novaRaiz.setEsquerda(raiz);
        raiz.setDireita(temp);
        return novaRaiz;
    }

    public void preOrdem(Node node)
    {
        if (node != null)
        {
            System.out.print(node.getInfo() + " ");
            preOrdem(node.getEsquerda());
            preOrdem(node.getDireita());
        }
    }

    public void emOrdem(Node node)
    {
        if (node != null)
        {
            emOrdem(node.getEsquerda());
            System.out.print(node.getInfo() + " ");
            emOrdem(node.getDireita());
        }
    }

    public void posOrdem(Node node)
    {
        if (node != null)
        {
            posOrdem(node.getEsquerda());
            posOrdem(node.getDireita());
            System.out.print(node.getInfo() + " ");
        }
    }

    public Node getRaiz()
    {
        return raiz;
    }
}
