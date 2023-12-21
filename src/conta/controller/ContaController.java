package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.println("\nA Conta número: " + numero+ " não foi encontrada!");
		}

	}

	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta Número: " + conta.getNumero() + " foi criada com sucesso!");

	}

	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " +conta.getNumero() + " foi atualizada com Sucesso!");
		} else {
			System.out.println("\nA Conta numero: " +conta.getNumero() + " não foi encontrada!");
		}

	}

	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if( conta!= null) {
			if(listaContas.remove(conta) == true) {
				System.out.println("\nA conta numero: " + numero + "foi deletada com Sucesso!");
			}else {
				System.out.println("\nA conta numero: " + numero + "não foi encontrada!" );
			}
		}

	}

	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;

			}
		}
		return null;
	}

}
