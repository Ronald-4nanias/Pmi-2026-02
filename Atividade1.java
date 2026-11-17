import java.util.Scanner;
public static Scanner sc = new Scanner(System.in);
public static int cadastrarConta(Conta[] v, int tam) {
    int id;
    String cliente;
    double saldo, limite;
    if (tam >= TAM_CONTAS) {
        System.out.println("Vetor de contas cheio, não é possível cadastrar!");
        return tam;
    }
    System.out.println("Digite o ID: ");
    id = sc.nextInt();
    sc.nextLine(); 
    if (buscaId(v, tam, id) != -1) {
        System.out.println("Já existe uma conta com esse ID!");
        return tam;
    }
    System.out.println("Digite o nome do cliente: ");
    cliente = sc.nextLine();
    saldo = lerValorNaoNegativo("Digite o saldo: ");
    limite = lerValorNaoNegativo("Digite o limite: ");
    v[tam] = new Conta();
    v[tam].id = id;
    v[tam].cliente = cliente;
    v[tam].saldo = saldo;
    v[tam].limite = limite;
    return tam + 1;
}

public static double lerValorNaoNegativo(String mensagem) {
    double valor;
    System.out.println(mensagem);
    valor = sc.nextDouble();
    sc.nextLine(); 
    while (valor < 0) {
        System.out.println("Valor negativo não é permitido! " + mensagem);
        valor = sc.nextDouble();
        sc.nextLine();
    }
    return valor;
}
