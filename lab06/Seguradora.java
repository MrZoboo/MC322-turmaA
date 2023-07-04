import java.util.ArrayList;
import java.util.List;

public class Seguradora {
    private final String cnpj;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Seguro> listaSeguros = new ArrayList<>();
    

    public Seguradora(String cnpj, String nome, String telefone, String endereco, String email, List<Cliente> listaClientes, List<Seguro> listaSeguros) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
    }
    public Seguradora(String cnpj, String nome, String telefone, String endereco, String email) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cliente> getListaClientes() {
        return this.listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Seguro> getListaSeguros() {
        return this.listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public void listarClientes(){
        System.out.println("**LISTA DE CLIENTES**");
        for(Cliente c : listaClientes){
            System.out.println(c.getNome());
        }
    }
    public boolean gerarSeguro(Seguro seguro){
        boolean isPossible = true;
        for(Seguro s : listaSeguros){
            if(s.equals(seguro)){
                return !isPossible;
            }
        }
        listaSeguros.add(seguro);
        return isPossible;
    }
    public boolean cancelarSeguro(Seguro seguro){
        boolean isPossible = true;
        for(Seguro s : listaSeguros){
            if(s.equals(seguro)){
                listaSeguros.remove(s);
                return isPossible;
            }
        }
        return !isPossible;
    }
    public boolean cadastrarCliente(Cliente cliente){
        boolean isPossible = true;
        for(Cliente c : listaClientes){
            if(c.equals(cliente)){
                return !isPossible;
            }
        }
        listaClientes.add(cliente);
        return isPossible;
    }
    public boolean removerCliente(Cliente cliente){
        boolean isPossible = true;
        for(Cliente c : listaClientes){
            if(c.equals(cliente)){
                listaClientes.remove(c);
                return isPossible;
            }
        }
        return !isPossible;
    }
    
    public List<Seguro> getSegurosPorCliente(Cliente cliente){
        List<Seguro> segurosCliente = new ArrayList<>();
        for(Seguro seguro : listaSeguros){
            if(seguro.getCliente().equals(cliente)){
                segurosCliente.add(seguro);
            }
        }
        return segurosCliente;
    }

    public List<Sinistro> getSinistrosPorCliente(Cliente cliente){
        List<Sinistro> sinistroCliente = new ArrayList<>();
        for(Seguro seguro : this.getSegurosPorCliente(cliente)){
            for(Sinistro sinistro : seguro.getListaSinistros()){
                
            }
        }
        return sinistroCliente;
    }

    public double calculaReceita(){
        double soma = 0;
        for(Cliente x : listaClientes){
            soma += x.valorSeguro;
        }
        return soma;
    }
}
