import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Seguradora {
    
    // INSTANCE VARIABLES
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List <Sinistro> listaSinistros  = new ArrayList<>();
    private List <Cliente> listaClientes  = new ArrayList<>();

    // CONSTRUCTOR
    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // GETTERS AND SETTERS
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
    public Sinistro getListaSinistros(int i){
        return listaSinistros.get(i);
    }
    public Cliente getListaClientes(int i){
        return listaClientes.get(i);
    }

    // ADD/REMOVE CLIENT IN THE LIST METHOD
    public void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void removeCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }

    // ADD/REMOVE SINISTRO IN THE LIST METHOD
    public void addSinistro(Sinistro sinistro){
        listaSinistros.add(sinistro);
    }
    public void removeSinistro(Sinistro sinistro){
        listaSinistros.remove(sinistro);
    }

    public Veiculo addVeiculos(){
        
        Scanner in = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("ENTRE COM A PLACA DO CARRO >> ");
        String placa = in.nextLine();

        System.out.print("ENTRE COM A MARCA DO CARRO >> ");
        String marca = in.nextLine();

        System.out.print("ENTRE COM O MODELO DO CARRO >> ");
        String modelo = in.nextLine();

        System.out.print("ENTRE COM O ANO DE FABRICACAO DO CARRO >> ");
        int anoFabricacao = in.nextInt();

        // System.out.print("\033[H\033[2J");
        // System.out.flush();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

        return veiculo;
    }

    // REGISTER CLIENT (PF) METHOD
    public boolean registerClientPF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento, int n){
        ClientePF cliente = new ClientePF(nome, endereco, dataLicenca, educacao, genero, classeEconomica, cpf, dataNascimento);
        if(cliente.validarCPF(cpf) == false){
            return false;
        }
        else{
            for(int i = 0; i < n; i++){
                Veiculo veiculo = this.addVeiculos();
                cliente.adicionaVeiculo(veiculo);
            }
            addCliente(cliente);
            return true;
        }
    }
    // REGISTER AN ENTERPRISE (PJ) METHOD
    public boolean registerClientePJ(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cnpj, Date dataFundacao, int n){
        ClientePJ cliente = new ClientePJ(nome, endereco, dataLicenca, educacao, genero, classeEconomica, cnpj, dataFundacao);
        if(cliente.validarCnpj(cnpj) == false){
            return false;
        }
        else{
            for(int i = 0; i < n; i++){
                Veiculo veiculo = addVeiculos();
                cliente.adicionaVeiculo(veiculo);
            }
            addCliente(cliente);
            return true;
        }
    }

    // GENERATE A "SINISTRO"
    public void generateSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
        addSinistro(sinistro);
    }

    // CONSULT SINISTROS BY CLIENT
    public void consultSinisto(Cliente cliente){
        for(Sinistro sinistro : listaSinistros){
            if(sinistro.getCliente().getNome() == cliente.getNome()){
                System.out.println(sinistro.toString());
                System.out.println("************");
            }
            else {
                System.out.println("NÃO ENCONTRAMOS NENHUM SINISTRO DE " + cliente.getNome() + " :(");
            }
        }
    }

    // lIST ALL CLIENTS
    public void listarCLientes(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**LISTA DE CLIENTES**");
        int i = 1;
        for(Cliente cliente : listaClientes){
            System.out.println("-> CLIENTE " + i + ": ");
            System.out.println(cliente.toString());
            System.out.println("************");
            i++;
        }
    }

    //LIST ALL "SINISTROS"
    public void listarSinistros(){
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
        System.out.println("**LISTA DE SINISTROS**");
        int i = 1;
        for(Sinistro sinistro : listaSinistros){
            System.out.println("-> SINISTRO " + i + ": ");
            System.out.println(sinistro.toString());
            System.out.println("************");
            i++;
        }
    }

}
