import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ClientePJ extends Cliente {

    //INSTANCE VARIABLES
    private final String cnpj;
    private Date dataFundacao;
    private List<Frota> listaFrota = new ArrayList<>();

    // CONSTRUCTORS
    public ClientePJ(String nome, String telefone, String email, String endereco, String cnpj, Date dataFundacao, List<Frota> listFrota) {
        super(nome, telefone, email, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.listaFrota = listFrota;
    }

    public ClientePJ(String nome, String telefone, String email, String endereco, String cnpj, Date dataFundacao) {
        super(nome, telefone, email, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    // GETTERS AND SETTERS
    public String getCnpj() {
        return this.cnpj;
    }

    public List<Frota> getListaFrota() {
        return this.listaFrota;
    }

    public void setListaFrota(List<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    public Date getDataFundacao() {
        return this.dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    // CADASTRAR FROTA
    public boolean cadastrarFrota(Frota frota){
        boolean exists = false;
        for(Frota x : listaFrota){
            if(x == frota){
                exists = true;
            }
        }
        if(!exists){
            listaFrota.add(frota);
        }
        return exists;
    }
    // ATUALIZAR FROTA
    public boolean atualizarFrota(int a, Veiculo veiculo, Frota frota){
        if(a == 1){
            return frota.addVeiculo(veiculo);
        }
        else{
            return frota.removeVeiculo(veiculo);
        }
    }
    public int calculaIdade(){
        LocalDate nasc = dataFundacao.toLocalDate();
        LocalDate agr = LocalDate.now();
        Period idade = Period.between(nasc, agr);
        return idade.getYears(); 
    }


    @Override
    public String toString() {
        return "{" +
            " cnpj='" + getCnpj() + "'" +
            ", dataFundacao='" + getDataFundacao() + "'" +
            ", listaFrota='" + getListaFrota() + "'" +
            "}";
    }
}
