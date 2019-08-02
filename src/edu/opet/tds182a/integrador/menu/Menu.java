package edu.opet.tds182a.integrador.menu;

import br.edu.uniopet.Reader;
import edu.opet.tds182a.integrador.cliente.ControleCliente;

public class Menu
{

    public Menu()
    {
    }

    public static void mostrarMenuPrincipal()
    {
        boolean sair = false;
        do
        {
            System.out.println("Direct Orders");
            System.out.println("-----------------------");
            System.out.println("Menu Direct Orders  ");
            System.out.println("-----------------------");
            System.out.println("1 - Cadastro Empresa ");
            System.out.println("2 - Cadastro  Usuario  ");
            System.out.println("3 - Consulta Empresas  ");
            System.out.println("4 - Excluir Empresa  ");
            System.out.println("5 - Aleterar Empresa  ");
            System.out.println("6- Sair ");
            System.out.println("-----------------------");
            int opcaoMenu = Reader.readIntNotNull("Escolha uma das  op\347\365es:  ").intValue();
            switch(opcaoMenu)
            {
            case 1: // '\001'
                ControleCliente.mostrarTelaInclusaoCliente();
                break;

            case 2: // '\002'
                ControleCliente.mostrarTelaInclusaoUsuario();
                break;

            case 3: // '\003'
                ControleCliente.mostrarTelaListaClientes();
                break;

            case 4: // '\004'
                ControleCliente.mostrarTelaExcluirCliente();
                break;

            case 5: // '\005'
                ControleCliente.alterarCliente();
                break;

            case 6: // '\006'
                sair = true;
                System.out.println("Obrigado por usar o sistema!");
                break;

            default:
                System.out.println("Opcao invalida");
                break;
            }
        } while(!sair);
    }
}
