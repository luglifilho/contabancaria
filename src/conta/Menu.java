package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner scanner = new Scanner(System.in);

		/*
		 * // Teste Classe conta Corrente ContaCorrente cc1 = new ContaCorrente(2, 123,
		 * 1, "Mariana", 15000.0f, 1000.0f); cc1.visualizar(); cc1.sacar(12000.0f);
		 * cc1.visualizar(); cc1.depositar(5000.0f); cc1.visualizar();
		 * 
		 * // Teste Classe conta Poupanca ContaPoupanca cp1 = new ContaPoupanca(3, 123,
		 * 2, "Victor", 100000.0f, 15); cp1.visualizar(); cp1.sacar(12000.0f);
		 * cp1.visualizar(); cp1.depositar(5000.0f); cp1.visualizar();
		 */

		int op = 0, numero, agencia, tipo, aniversario;
		float saldo, limite;

		do {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("***************************************************");
			System.out.println("                                                   ");
			System.out.println("             BANCO DO BRAZIL COM Z                 ");
			System.out.println("                                                   ");
			System.out.println("***************************************************");
			System.out.println("                                                   ");
			System.out.println("             1 - Criar Conta                       ");
			System.out.println("             2 - Listar todas as Contas            ");
			System.out.println("             3 - Buscar Conta por Número           ");
			System.out.println("             4 - Atualizar dados da COnta          ");
			System.out.println("             5 - Apagar Conta                      ");
			System.out.println("             6 - Sacar                             ");
			System.out.println("             7 - Depositar                         ");
			System.out.println("             8 - Transferir Valores entre Contas   ");
			System.out.println("             9 - Sair                              ");
			System.out.println("                                                   ");
			System.out.println("***************************************************");
			System.out.println("Entre com a opção desejada:");
			System.out.println("                                                   " + Cores.TEXT_RESET);

			try {
				op = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				op = 0;
			}

			if (op == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			String titular;
			switch (op) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
				System.out.println("Digite o Numero da Agencia: ");
				agencia = scanner.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				do {
					System.out.println("Digite o Tipo de COnta ( 1-CC ou 2-CP)");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da OCnta (R$)");
				saldo = scanner.nextFloat();

				switch (tipo) {
				case 1: {
					System.out.println("Digitge o Limite de Crédito (R$): ");
					limite = scanner.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					break;
				}
				case 2: {
					System.out.println("Digite o dia do Aniversario da COnta: ");
					aniversario = scanner.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					break;
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da Conta: ");
				numero = scanner.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					System.out.println("Digite o número da Agencia: ");
					agencia = scanner.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					titular = scanner.nextLine();
					
					System.out.println("Digite o saldo da Conta (R$): ");
					saldo = scanner.nextFloat();
					
					switch (tipo) {
					case 1 : {
						System.out.println("Digite o limite da Conta (R$): ");
						limite = scanner.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 : {
						System.out.println("Digite o dia do Aniversario da COnta: ");
						aniversario = scanner.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						
					}
					default : {
						System.out.println("Tipo de conta inválido!");
					}
					}
				}else {
					System.out.println("A Conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				System.out.println("Digite o n;umero da conta: ");
				numero = scanner.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazl com Z - O seu Futuro começa aqui!");
				sobre();
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n");
				break;
			}

		} while (op != 9);

		scanner.close();
		System.exit(0);

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Daniel Lugli - luglifilho@gmail.com");
		System.out.println("https://github.com/luglifilho");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
