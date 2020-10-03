public class Merge {
    static int[] lista_A = {0 , 2, 10, 12, 20};
    static int[] lista_B = {1, 3, 9};

    static private void merge(int[] lista_A, int[] lista_B) {
        Fila fila_A = new Fila(lista_A.length);
        for(int i = 0; i < lista_A.length; i++) {
            fila_A.insere(lista_A[i]);
        }
        Fila fila_B = new Fila(lista_B.length);
        for(int i = 0; i < lista_B.length; i++) {
            fila_B.insere(lista_B[i]);
        }
        Fila fila_C = new Fila((lista_A.length + lista_B.length));
        // trocar for por um
        for(int i = 0; i < lista_A.length + lista_B.length; i++) {
            if(lista_A.length >= lista_B.length) {
                if(fila_B.getDados() == null || fila_A.getDados() < fila_B.getDados()) {
                    fila_C.insere(fila_A.getDados());
                    fila_A.remove();
                }
                else {
                    fila_C.insere(fila_B.getDados());
                    fila_B.remove();
                }
            }
            else {
                if(fila_A.getDados() == null || fila_B.getDados() < fila_A.getDados()) {
                    fila_C.insere(fila_B.getDados());
                    fila_B.remove();
                }
                else {
                    fila_C.insere(fila_A.getDados());
                    fila_A.remove();
                }
            }
        }
        fila_C.imprime();
    }

    public static void main(String[] args) {
        merge(lista_A, lista_B);
    }

}
