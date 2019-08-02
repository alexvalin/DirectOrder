package edu.opet.tds182a.integrador.oracle;


import edu.opet.tds182a.integrador.cliente.Cliente;

public class MainDB {

	public static void main(String[] args) {
		OracleDB acessoDB = new OracleDB();

		Cliente novoCliente = new Cliente();

		novoCliente.cnpj = "123456";
		novoCliente.razaoSocial = "Servitta LTDA";
		novoCliente.endereco = "Adel Karan";
		novoCliente.telefone = "99999999";
		novoCliente.email = "joao@gmail.com";
		

		if (acessoDB.inserir(novoCliente)) {
			System.out.println("inseriu ok");
		} else {
			System.out.println("inseriu nok");
		}

		Cliente[] listaClientes = acessoDB.listarTodosClientes();

		for (int i = 0; i < listaClientes.length; i++) {
			Cliente clienteRetornado = listaClientes[i];

			if (clienteRetornado != null) {

				System.out.println(clienteRetornado.cnpj);
				System.out.println(clienteRetornado.razaoSocial);
				System.out.println(clienteRetornado.endereco);
				System.out.println(clienteRetornado.telefone);
				System.out.println(clienteRetornado.email);

			}
		}

		Cliente clienteRetornadoPeloId = acessoDB.listarCliente(0);

		System.out.println(clienteRetornadoPeloId.cnpj);
		System.out.println(clienteRetornadoPeloId.razaoSocial);
		System.out.println(clienteRetornadoPeloId.endereco);
		System.out.println(clienteRetornadoPeloId.telefone);
		System.out.println(clienteRetornadoPeloId.email);

	}

}
