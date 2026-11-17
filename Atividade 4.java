public static int filtraOperacoes(Operacao[] vOp, int tamOp, Operacao[] vOpFiltrado, int x) {
    int tamFiltrado = 0;
    for (int i = 0; i < tamOp; i += 1) {
        if (vOp[i].idConta == x) {
            vOpFiltrado[tamFiltrado] = vOp[i];
            tamFiltrado += 1;
        }
    }
    return tamFiltrado;
}
