public class mainArvoreAVL {
    public static void main(String[] args) {
        arvoreAVL avl = new arvoreAVL();
        avl.insereElemento(10);
        avl.insereElemento(5);
        avl.insereElemento(8);
        avl.insereElemento(12);
        avl.insereElemento(11);
        avl.remove(11);
        avl.buscar(12);
        avl.preOrdem(avl.getRaiz());
    }
}
