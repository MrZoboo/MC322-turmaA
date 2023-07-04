import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ClientePF extends Cliente {
    // Instance Variables
    private final String cpf;
    private String genero;
    private String educacao;
    private Date dataNascimento;
    private List<Veiculo> listaVeiculos = new ArrayList<>();

    // Constructors
    public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, Date dataNascimento, List<Veiculo> listaVeiculos){
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = listaVeiculos;
    }
    public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, Date dataNascimento){
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
    }
    
    // Getters and Setters
    public String getCpf(){
        return cpf;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getEducacao(){
        return educacao;
    }
    public void setEducacao(String educacao){
        this.educacao = educacao;
    }
    public Date getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    public List<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }

    // Cadastrar Veiculo
    public boolean cadastrarVeiculo(Veiculo veiculo){
        boolean works = true;
        for(Veiculo v : listaVeiculos){
            if(veiculo == v){
                works = false;
                return works;
            }
        }
        listaVeiculos.add(veiculo);
        return works;
    }

    // Remover Veiculo
    public boolean removerVeiculo(Veiculo veiculo){
        boolean works = false;
        for(Veiculo v : listaVeiculos){
            if(veiculo == v){
                works = true;
                listaVeiculos.remove(v);
                return works;
            }
        }
        return works;
    }

    // Calcular idade
    public int calculaIdade(){
        LocalDate nasc = dataNascimento.toLocalDate();
        LocalDate agr = LocalDate.now();
        Period idade = Period.between(nasc, agr);
        return idade.getYears(); 
    }
    

    @Override
    public String toString() {
        return "{" +
            " cnpj='" + getCpf() + "'" +
            ", genero='" + getGenero() + "'" +
            ", educacao='" + getEducacao() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", listaVeiculos='" + getListaVeiculos() + "'" +
            "}";
    }

}
