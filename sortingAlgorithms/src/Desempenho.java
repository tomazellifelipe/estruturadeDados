import java.lang.reflect.Method;
import java.util.Random;

public class Desempenho {


    public static void main(String[] args)
    {
        // tempos
        long tempoInicial;
        long tempoFinal;

        // quase ordenados
        int[] qord10_3 = new int[1000];
        int[] qord10_4 = new int[5000];
        int[] qord10_5 = new int[10000];

        arrayQordenado(qord10_3);
        arrayQordenado(qord10_4);
        arrayQordenado(qord10_5);

        // desordenados
        int[] desord10_3 = new int[1000];
        int[] desord10_4 = new int[5000];
        int[] desord10_5 = new int[10000];

        arrayDesordenado(desord10_3);
        arrayDesordenado(desord10_4);
        arrayDesordenado(desord10_5);

        // ordenados decrescente
        int[] dord10_3 = new int[1000];
        int[] dord10_4 = new int[5000];
        int[] dord10_5 = new int[10000];

        arrayDordenado(dord10_3);
        arrayDordenado(dord10_4);
        arrayDordenado(dord10_5);

        InsertionSort is = new InsertionSort();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();

        System.out.println("Tamanho do conjunto: " + qord10_3.length);
        System.out.println("                Insertion | Merge | Quick");
        System.out.print("Quase Ordenado: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(qord10_3);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(qord10_3, 0, qord10_3.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(qord10_3,0, qord10_3.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

        System.out.print("   Desordenado: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(desord10_3);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(desord10_3, 0, desord10_3.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(desord10_3,0, desord10_3.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

        System.out.print("   Decrescente: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(dord10_3);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(dord10_3, 0, dord10_3.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(dord10_3,0, dord10_3.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("     " + (tempoFinal - tempoInicial) + " ms");
        //-----------------------------------------------------------------

        System.out.println("Tamanho do conjunto: " + qord10_4.length);
        System.out.println("                Insertion | Merge | Quick");
        System.out.print("Quase Ordenado: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(qord10_4);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(qord10_4, 0, qord10_4.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(qord10_4,0, qord10_4.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

        System.out.print("   Desordenado: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(desord10_4);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(desord10_4, 0, desord10_4.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(desord10_4,0, desord10_4.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

        System.out.print("   Decrescente: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(dord10_4);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(dord10_4, 0, dord10_4.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(dord10_4,0, dord10_4.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");
        //---------------------------------------------------------------

        System.out.println("Tamanho do conjunto: " + qord10_5.length);
        System.out.println("                Insertion | Merge | Quick");
        System.out.print("Quase Ordenado: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(qord10_5);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(qord10_5, 0, qord10_5.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(qord10_5,0, qord10_5.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

        System.out.print("   Desordenado: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(desord10_5);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(desord10_5, 0, desord10_5.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(desord10_5,0, desord10_5.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

        System.out.print("   Decrescente: ");
        tempoInicial = System.currentTimeMillis();
        is.sort(dord10_5);
        tempoFinal = System.currentTimeMillis();
        System.out.print("     " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        ms.sort(dord10_5, 0, dord10_5.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.print("    " + (tempoFinal - tempoInicial) + " ms");
        tempoInicial = System.currentTimeMillis();
        qs.sort(dord10_5,0, dord10_5.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("    " + (tempoFinal - tempoInicial) + " ms");

    }

    // Methods for the array creation

    private static void arrayDordenado(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = array.length - i;
        }
    }

    private static void arrayQordenado(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = i;
        }
        Random rd = new Random();
        for (int i = 0; i < array.length * .1; i++)
        {
            array[rd.nextInt(array.length)] = rd.nextInt(array.length);
        }
    }

    private static void arrayDesordenado(int[] array)
    {
        Random rd = new Random(); // creating Random object
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rd.nextInt(array.length * 5); // storing random integers in an array
        }
    }
}
