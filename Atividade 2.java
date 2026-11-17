public static int buscaBinariaCliente(Conta[] v, int tam, String x) {
    int inicio = 0, fim = tam - 1, meio;
    while (inicio <= fim) {
        meio = (inicio + fim) / 2;
        if (v[meio].cliente.compareToIgnoreCase(x) == 0) {
            return meio;
        } else if (v[meio].cliente.compareToIgnoreCase(x) < 0) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }
    return -1;
}
