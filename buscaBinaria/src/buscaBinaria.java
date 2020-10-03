public class buscaBinaria {
    static int[] dados = {0, 13, 24, 35, 46, 57};

    public static int busca_binaria(int[] dados, int x, int inicio, int fim) {
        int meio = (fim + inicio) / 2;
        if (meio == inicio && dados[inicio] == x) {
            return inicio;
        }
        else if (meio == inicio && dados[fim] == x) {
            return fim;
        }
        else if (meio == inicio) {
            return -1;
        }
        else if (dados[meio] == x) {
            return meio;
        }
        else if (dados[meio] < x) {
            inicio = meio;
            return busca_binaria(dados, x, inicio, fim);
        }
        fim = meio;
        return busca_binaria(dados, x, inicio, fim);
    }

    public static void main(String[] args) {
        System.out.println(busca_binaria(dados, 57, 0, 5));
    }
}
