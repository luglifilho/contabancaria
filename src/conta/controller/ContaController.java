package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta Número: " + conta.getNumero() + " foi criada com sucesso!" );
		
	}

	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
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
		return ++ numero;
	}

}
