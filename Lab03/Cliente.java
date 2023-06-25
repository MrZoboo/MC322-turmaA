import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    //INSTANCE VARIABLES
    protected String nome ;
    protected String endereco;
    protected Date dataLicenca;
    protected String educacao;
    protected String genero;
    protected String classeEconomica;
    protected List <Veiculo> listaVeiculos = new ArrayList<>();

    //CONSTRUCTOR
    public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica){
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
    }

    //GETTERS AND SETTERS
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public Date getDataLicenca(){
        return dataLicenca;
    }
    public void setDataLicenca(Date dataLicenca){
        this.dataLicenca = dataLicenca;
    }
    public String getEdeucacao(){
        return educacao;
    }
    public void setEducacao(String educacao){
        this.educacao = educacao;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public String getClasseEconomica(){
        return classeEconomica;
    }
    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }
    public Veiculo getVeiculo(int i){
        return listaVeiculos.get(i); 
    }

    //ADDING/REMOVING A VELICHE IN THE LIST
    public void adicionaVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        listaVeiculos.remove(veiculo);
    }

    //TO STRING METHOD
    @Override
    public String toString() {
        String string1 = "NOME: " + nome + "\n" + "ENDERECO: " + endereco + "\n" + "DATA DA LICENCA: " + dataLicenca + "\n" + "EDUCACAO: " + educacao + "\n" + "GENERO: " + genero + "\n";

        return string1;
    }

}
