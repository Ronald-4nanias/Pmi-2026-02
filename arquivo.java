
public class Prova1 {

    public static boolean contem(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                return true;
            }
        }
        return false;
    }

    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;
        for (int i = 0; i < tamA; i++) {
            if (!contem(u, tamU, a[i])) {
                u[tamU] = a[i];
                tamU++;
            }
        }
        for (int i = 0; i < tamB; i++) {
            if (!contem(u, tamU, b[i])) {
                u[tamU] = b[i];
                tamU++;
            }
        }
        return tamU;
    }

    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;
        for (int i = 0; i < tamV; i++) {
            if (!contem(vsr, tamVSR, v[i])) {
                vsr[tamVSR] = v[i];
                tamVSR++;
            }
        }
        return tamVSR;
    }

    public static void rotacionar(int[] v, int tam, int k) {
        while (k > 0) {
            int primeiro = v[0];
            for (int i = 0; i < tam - 1; i++) {
                v[i] = v[i + 1];
            }
            v[tam - 1] = primeiro;
            k--;
        }
        while (k < 0) {
            int ultimo = v[tam - 1];
            for (int i = tam - 1; i > 0; i--) {
                v[i] = v[i - 1];
            }
            v[0] = ultimo;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] u = new int[10];
        int tamU = uniao(new int[]{1, 3, 5}, 3, new int[]{3, 4, 5, 6}, 4, u);
        for (int i = 0; i < tamU; i++) {
            System.out.print(u[i] + " ");
        }
        System.out.println();

        int[] v = {7, 2, 9, 1, 5};
        ordenar(v, 5);
        for (int i = 0; i < 5; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();

        int[] vsr = new int[9];
        int tamVSR = gerarVetorSemRepeticao(new int[]{5, 2, 5, 3, 3, 8, 3, 8, 2}, 9, vsr);
        for (int i = 0; i < tamVSR; i++) {
            System.out.print(vsr[i] + " ");
        }
        System.out.println();

        int[] r = {1, 2, 3, 4, 5};
        rotacionar(r, 5, 2);
        for (int i = 0; i < 5; i++) {
            System.out.print(r[i] + " ");
        }
        System.out.println();
    }
}
