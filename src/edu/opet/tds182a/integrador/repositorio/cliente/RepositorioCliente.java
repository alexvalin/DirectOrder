package edu.opet.tds182a.integrador.repositorio.cliente;

import edu.opet.tds182a.integrador.cliente.Cliente;

public class RepositorioCliente {


	public static final Cliente[] Clientes = null;

	public static void main(String[] args) {
	   	 
	     
	   	 Clientes[] listaClientes1 = new Clientes [5];
	   	Clientes novoCliente = new Clientes();
	   	 novoCliente.nome = "jose";
	   	 listaClientes1[0] = novoCliente;
	   	 
	   	 
	   	
	   
	   	Clientes outroCliente = new Clientes();
	   	 outroCliente.nome = "maria";
	   	 listaClientes1[1] = outroCliente;
	   	 
	   	Clientes newCliente = new Clientes();
	   	newCliente.nome = "mateus";
	  	 listaClientes1[2] = newCliente;
	   	 
	   	 for(int i = 0; i < listaClientes1.length; i++) {
	   		Clientes clienteRecuperado = listaClientes1[i];
	   		 if(clienteRecuperado != null)
	   			 System.out.println(clienteRecuperado.nome);
	   	 	}

	  }

}


