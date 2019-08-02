package edu.opet.tds182a.integrador.cliente;


import br.edu.uniopet.Reader;
import edu.opet.tds182a.integrador.oracle.OracleDB;


public class ControleCliente
{

    public ControleCliente()
    {
    }

    public static void mostrarTelaInclusaoCliente()
    {
        System.out.println("CADASTRE SUA EMPRESA ");
        String cnpj = Reader.readStringNotNull("Insira o CNPJ da empresa:  ");
        String razaoSocial = Reader.readStringNotNull("Entre com a raz\343o social:  ");
        String endereco = Reader.readStringNotNull("Digite o seu endere\347o:  ");
        String telefone = Reader.readStringNotNull("Digite o seu Telefone : ");
        String email = Reader.readStringNotNull("Digite o seu Email:  ");
        Cliente novoCliente = new Cliente();
        novoCliente.cnpj = cnpj;
        novoCliente.razaoSocial = razaoSocial;
        novoCliente.endereco = endereco;
        novoCliente.telefone = telefone;
        novoCliente.email = email;
        boolean inseriuCliente = inserirCliente(novoCliente);
        if(inseriuCliente)
            System.out.println("Empresa cadastrada com sucesso! ");
        else
            System.out.println("Op\347\343o Invalida");
    }

    public static boolean inserirCliente(Cliente novoCliente)
    {
        OracleDB acessoDB = new OracleDB();
        return acessoDB.inserir(novoCliente);
    }

    public static void mostrarTelaInclusaoUsuario()
    {
        System.out.println("CRIAR  USUARIOS ");
        String login = Reader.readStringNotNull(" login :   ");
        String senha = Reader.readStringNotNull(" senha :  ");
        String cnpj = Reader.readStringNotNull("  CNPJ:  ");
        Usuario novoUsuario = new Usuario();
        novoUsuario.login = login;
        novoUsuario.senha = senha;
        novoUsuario.cnpj = cnpj;
        boolean cadastroUsuario = cadastroUsuario(novoUsuario);
        if(cadastroUsuario)
            System.out.println("Usuario cadastrado com sucesso!");
        else
            System.out.println("Op\347\343o Invalida");
    }

    public static boolean cadastroUsuario(Usuario novoUsuario)
    {
        OracleDB acessoDB = new OracleDB();
        return acessoDB.inserir(novoUsuario);
    }

    public static void mostrarTelaListaClientes()
    {
        System.out.println("LISTAR TODOS OS CLIENTES");
        System.out.println("-----------------------");
        Cliente listaClientes[] = listarTodosClientes();
        for(int i = 0; i < listaClientes.length; i++)
        {
            Cliente clienteEncontrado = listaClientes[i];
            if(clienteEncontrado != null)
            {
                System.out.println("EMPRESA\n");
                System.out.println((new StringBuilder("CNPJ : ")).append(clienteEncontrado.cnpj).append("\n").toString());
                System.out.println((new StringBuilder("RAZ\303O SOCIAL: ")).append(clienteEncontrado.razaoSocial).append("\n").toString());
                System.out.println((new StringBuilder("ENDERE\307O:  ")).append(clienteEncontrado.endereco).append("\n").toString());
                System.out.println((new StringBuilder("TELEFONE: ")).append(clienteEncontrado.telefone).append("\n").toString());
                System.out.println((new StringBuilder("EMAIL : ")).append(clienteEncontrado.email).append("\n").toString());
                System.out.println("-----------------------");
            }
        }

    }

    public static Cliente[] listarTodosClientes()
    {
        OracleDB acessoDB = new OracleDB();
        return acessoDB.listarTodosClientes();
    }

    public static void mostrarTelaExcluirCliente()
    {
        OracleDB acessoDB = new OracleDB();
        System.out.println("EXCLUA CLIENTE ");
        Cliente cliente = new Cliente();
        String cnpj = Reader.readStringNotNull(" cnpj:  ");
        cliente.cnpj = cnpj;
        if(acessoDB.excluirCliente(cliente))
            System.out.println("Cliente Excluido");
        else
            System.out.println("Cliente  nao Excluido");
    }

    public static void alterarCliente()
    {
        OracleDB acessoDB = new OracleDB();
        System.out.println("Altere  CLIENTE ");
        Cliente cliente = new Cliente();
        String cnpj = Reader.readStringNotNull(" cnpj:  ");
        cliente.cnpj = cnpj;
        String telefone = Reader.readStringNotNull(" telefone:  ");
        cliente.telefone = telefone;
        String email = Reader.readStringNotNull(" email:  ");
        cliente.email = email;
        if(acessoDB.alterarCliente(cliente))
            System.out.println("Cliente Alterado");
        else
            System.out.println("Erro ao  Alterar cliente");
    }
}