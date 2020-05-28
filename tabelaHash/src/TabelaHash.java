import java.util.Random;
import java.util.Scanner;

/**
 * Implementacao de uma tabela hash para a disciplina
 * Estrutura de dados
 *
 * @author Felipe Tomazelli
 * @since 2020-05-28
 */
public class TabelaHash {
    private int colisao;
    private final NodeTabela[] tabela;

    public TabelaHash(int tamanho)
    {
        this.tabela = new NodeTabela[tamanho];
        this.colisao = 0;
        vazio();
        popula();
    }

    public void insere(int chave)
    {
        int key = chave % tabela.length;
        if (tabela[key].getInformarcao() == -1) tabela[key] = new NodeTabela(chave);
        else
        {
            tabela[key].setLista(chave);
            this.colisao++;
        }
    }

    public void vazio()
    {
        for (int i = 0; i < tabela.length; i++)
            tabela[i] = new NodeTabela(-1);
    }

    public void popula()
    {
        Random random = new Random();
        float pop;
        float dpop = 0;
        while (dpop < .9)
        {
            for (int i = 0; i < 100; i++)
            {
                insere(random.nextInt(1000000));
            }
            pop = 0;
            for (NodeTabela n: tabela)
            {
                if (n.getInformarcao() != -1) pop++;
            }
            dpop = pop / tabela.length;
        }
    }

    public void imprime()
    {
        System.out.println("Quantidade de colisoes: " + colisao);
        for (int  i= 0; i < tabela.length; i++)
        {
            System.out.print(i + "| "  + tabela[i].getInformarcao() + " ");
            tabela[i].getLista().imprime();
            System.out.println();
        }
    }

    public boolean busca(int chave)
    {
        int key = chave % tabela.length;
        if (tabela[key].getInformarcao() != -1)
        {
            if (tabela[key].getInformarcao() == chave) return true;
            else return tabela[key].getLista().getNode(chave) != null;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o tamanho da tabela: ");
        int tamanho = scanner.nextInt();
        TabelaHash tabelaHash = new TabelaHash(tamanho);
        tabelaHash.imprime();
        System.out.print("Insira uma chave: ");
        int chave = scanner.nextInt();
        while (chave != -1)
        {
            if (tabelaHash.busca(chave)) System.out.println("Chave encontrada");
            else System.out.println("Chave nao encontrada");
            System.out.print("Insira outra chave, ou -1 para sair: ");
            chave = scanner.nextInt();
        }
    }
}
