public class Fila {
    private ListaEncadeadaDupla fila;

    public Fila() {
        this.fila = new ListaEncadeadaDupla();
    }

    public void insere(int dado) {
        fila.insereUltimo(dado);
    }

    public Node remove() {
        Node aux = fila.getLista();
        fila.removePrimeiro();
        return aux;
    }

    public void mostrar_fila() {
        fila.imprime();
    }
}
