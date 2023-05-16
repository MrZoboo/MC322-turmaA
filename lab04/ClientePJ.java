import java.sql.Date;

public class ClientePJ extends Cliente {
    //INSTANCE VARIABLES
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;
    
    //CONSTRUCTOR
    public ClientePJ(String nome, String endereco, double valorSeguro, String cnpj, Date dataFundacao, int qtdeFuncionarios){
        super(nome, endereco, valorSeguro);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //GETTERS AND SETTERS
    public Date getDataFundacao(){
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    public String getCnpj(){
        return cnpj;
    }
    
    //CHECK IF THE CNPJ IS ELEGIBLE
    public boolean validarCNPJ(){
        return MenuOperacoes.Validacao.validaCNPJ(cnpj);
    }


    //CALCULA SCORE
    public double calculaScore(int qtdeFuncionarios){
        return CalcSeguro.VALOR_BASE.getValor() * (1 + qtdeFuncionarios/100) * listaVeiculos.size();
    }
    //TOSTRING METHOD
    public String toString(){
        return "Nome da empresa: " + nome + "\n" + "Endereco: " + endereco + "\n" + "Valor do seguro: " + valorSeguro + "\n" + "Cnpj: " +cnpj + "\n" + "Data de fundacao: " + dataFundacao + "\n";
    }
}
