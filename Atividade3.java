public static int insertionSortCliente(Conta[] v, int tam) {
    Conta chave;
    int j;
    for (int i = 1; i <= tam - 1; i += 1) {
        chave = v[i];
        j = i - 1;
        while (j >= 0 && chave.cliente.compareToIgnoreCase(v[j].cliente) < 0) {
            v[j + 1] = v[j];
            j -= 1;
        }
        v[j + 1] = chave;
    }
    return tam;
}
