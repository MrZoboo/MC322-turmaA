import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Seguradora {
    //INSTANCE VARIABLES
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List <Sinistro> listaSinistros = new ArrayList<>();
    private List <Cliente> listaClientes = new ArrayList<>();

    //CONSTRUCTOR
    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    //GETTERS AND SETTERS
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    //CADASTRAR VEICULO
    public void cadastroVeiculo(Cliente cliente, String placa, String marca , String modelo, int anoFabricacao){
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
        cliente.adicionaVeiculo(veiculo);
    }

    //CADASTRAR CLIENE (cliente)(BOOLEAN)
    public void cadastroCliente(ClientePF cliente){
        cliente.setValorSeguro(calculaPrecoSeguroCliente(cliente.calculaScore(cliente.calculaIdade(cliente.getDataNascimento())),0));
        listaClientes.add(cliente);
    }
    public void cadastroCliente(ClientePJ cliente){
        cliente.setValorSeguro(calculaPrecoSeguroCliente(cliente.calculaScore(cliente.getQtdeFuncionarios()), 0));
        listaClientes.add(cliente);
    }
    public void cadastroCliente(String nome, String endereco, String cpf, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica){
        ClientePF cliente = new ClientePF(nome, endereco,  0 , cpf, genero, dataLicenca, educacao, dataNascimento, classeEconomica);
        cliente.setValorSeguro(calculaPrecoSeguroCliente(cliente.calculaScore(cliente.calculaIdade(dataNascimento)),0));
        listaClientes.add(cliente);
    }
    public void cadastroCliente(String nome, String endereco, String cnpj, Date dataFundacao, int qtdeFuncionarios){
        ClientePJ cliente = new ClientePJ(nome, endereco, 0, cnpj, dataFundacao, qtdeFuncionarios);
        cliente.setValorSeguro(calculaPrecoSeguroCliente(cliente.calculaScore(qtdeFuncionarios), 0));
        listaClientes.add(cliente);
    }
    
    //REMOVER CLIENTE (cliente) (BOOLEAN)
    public void removerCliente(Cliente cliente){
        for(Cliente x: listaClientes){
            if(x == cliente){
                listaClientes.remove(cliente);
            }
        }
    }

    //LISTAR CLIENTES (STRING)
    public void listarClientes(){
        for(Cliente x: listaClientes){
            System.out.print(x.toString());
            System.out.println("****************");
        }
    }

    //GERAR SINISTRO (BOOLEAN)

    public void gerarSinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        listaSinistros.add(sinistro);
        cliente.qtdeSinistros++;
        cliente.valorSeguro = (cliente.valorSeguro/(cliente.qtdeSinistros))*(cliente.qtdeSinistros+1);
    }

    // VISUALIZAR SINISTRO(string) (BOOLEAN)

    public void visualzarSinistro(String nome){
        for(Sinistro x: listaSinistros){
            if(x.getCliente().nome == nome){
                System.out.print(x.toString());
            }
        }
    }

    // LISTAR SINISTROS (STRING)
    public void listarSinistros(){
        for(Sinistro x: listaSinistros){
            System.out.print(x.toString());
            System.out.println("****************");
        }
    }

    // CALCULAR PRECO SEGURO DO CLIENTE ()
    public double calculaPrecoSeguroCliente(double score, int qtdeSinistros){
        return score * (1 + qtdeSinistros);
    }

    //CALCULAR RECEITA()
    public double calculaReceita(){
        double soma = 0;
        for(Cliente x : listaClientes){
            soma += x.valorSeguro;
        }
        return soma;
    }

    // TRANSFERENCIA DE SEGURO
}
