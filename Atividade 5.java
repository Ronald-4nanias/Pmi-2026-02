public static void extrato(Conta[] vContas, int tamConta, Operacao[] vOp, int tamOp) {
    int idConta, pos, tamFiltrado, inicio;
    double saldo;
    Operacao[] vOpFiltrado = new Operacao[TAM_OP];
    System.out.println("Digite o ID da conta: ");
    idConta = sc.nextInt();
    sc.nextLine(); 
    pos = buscaId(vContas, tamConta, idConta);
    if (pos == -1) {
        System.out.println("Conta não encontrada!");
        return;
    }
    tamFiltrado = filtraOperacoes(vOp, tamOp, vOpFiltrado, idConta);
    
    inicio = tamFiltrado - 5;
    if (inicio < 0) {
        inicio = 0;
    }
    saldo = somaOperacoes(vOpFiltrado, 0, inicio - 1);
    System.out.println("+----------------------------------------+");
    System.out.printf("| C O N T A N.%03d\n", vContas[pos].id);
    System.out.println("+----------------------------------------+");
    System.out.printf("|CLIENTE: %s\n", vContas[pos].cliente);
    System.out.println("+----------------------------------------+");
    System.out.println("| ID | O P E R A Ç Ã O | VALOR | SALDO |");
    System.out.println("+----+-----------------+--------+--------+");
    System.out.printf("|    |Saldo Anterior   |        |%8s|\n", formatarValor(saldo));
    for (int i = inicio; i <= tamFiltrado - 1; i += 1) {
        saldo += vOpFiltrado[i].valor;
        System.out.printf("|%04d|%-17s|%8s|%8s|\n", vOpFiltrado[i].id,
            nomeOperacao(vOpFiltrado[i].tipo), formatarValor(vOpFiltrado[i].valor),
            formatarValor(saldo));
    }
    System.out.println("+----+-----------------+--------+--------+");
    System.out.printf("Saldo Atual | %8s|\n", formatarValor(saldo));
    System.out.println("+--------+");
}
public static double somaOperacoes(Operacao[] v, int inicio, int fim) {
    double soma = 0;
    for (int i = inicio; i <= fim; i += 1) {
        soma += v[i].valor;
    }
    return soma;
}
public static String nomeOperacao(char tipo) {
    if (tipo == 'D') {
        return "Depósito";
    } else if (tipo == 'S') {
        return "Saque";
    } else {
        return "Transferência";
    }
}
public static String formatarValor(double valor) {
    if (valor < 0) {
        return String.format("%.2fD", -valor);
    }
    return String.format("%.2fC", valor);
}
