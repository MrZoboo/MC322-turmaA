import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class ClientePF extends Cliente{
    // INSTANCE VARIABLES 
    private final String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    // CONSTRUCTOR
    public ClientePF(String nome, String endereco, double valorSeguro, String cpf, String genero, Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica){
        super(nome, endereco, valorSeguro);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }

    // GETTERS AND SETTERS
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public Date getDataLicenca(){
        return dataLicenca;
    }
    public void setDataLicenca(Date dataLicenca){
        this.dataLicenca = dataLicenca;
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
    public String getClasseEconomica(){
        return classeEconomica;
    }
    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }
    public String getCpf(){
        return cpf;
    }

    // CHECK IF THE CPF IS ELEGIBLE
    public boolean validarCPF(){
        return MenuOperacoes.Validacao.validaCPF(cpf);
    }

    // CALCULA IDADE 
    public int calculaIdade(Date dataNascimento){
        LocalDate nasc = dataNascimento.toLocalDate();
        LocalDate agr = LocalDate.now();
        Period idade = Period.between(nasc, agr);
        return idade.getYears(); 
    }
    //CALCULA SCORE
    @Override
    public double calculaScore(int idade) {
        if(idade >= 18 && idade < 30){
            return CalcSeguro.FATOR_18_30.getValor() * CalcSeguro.VALOR_BASE.getValor() * listaVeiculos.size();
        }
        else if(idade >= 30 && idade < 60){
            return CalcSeguro.FATOR_30_60.getValor() * CalcSeguro.VALOR_BASE.getValor() * listaVeiculos.size();
        }
        else if(idade >= 60 && idade <= 90){
            return CalcSeguro.FATOR_60_90.getValor() * CalcSeguro.VALOR_BASE.getValor() * listaVeiculos.size();
        }
        else{
            return -1;
        }
    }

    //TOSTRING METHOD
    public String toString(){
        return "Nome: " + nome + "\n" + "Endereco: " + endereco + "\n" + "Cpf: " + cpf + "\n" +"Data de Nascimento: " + dataNascimento + "\n" + "Genero: " + genero + "\n" + "Data da Licenca: " + dataLicenca + "\n" + "Educacao: " + educacao + "\n" + "Classe Economica: " +classeEconomica + "\n" + "Valor do Seguro: " +valorSeguro + "\n";
    }
    

}
