import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    // INSTANCE VARIABLES 
    protected String nome;
    protected String endereco;
    protected List <Veiculo> listaVeiculos = new ArrayList<>();
    protected double valorSeguro;
    protected int qtdeSinistros = 0;

    // CONSTRUCTOR
    public Cliente(String nome, String endereco, double valorSeguro){
        this.nome = nome;
        this.endereco = endereco;
        this.valorSeguro = valorSeguro;
    }

    // GETTERS AND SETTERS
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
    public double getValorSeguro(){
        return valorSeguro;
    }
    public void setValorSeguro(double valorSeguro){
        this.valorSeguro = valorSeguro;
    }

    // ADD VELICHE
    public void adicionaVeiculo(Veiculo veiculo){
        listaVeiculos.add(veiculo);
    }

    // REMOVE VELICHE
    public void removeVeiculo(Veiculo veiculo){
        listaVeiculos.remove(veiculo);
    }

    // CALCULATE SCORE
    public abstract double calculaScore(int a);
    
    //TO STRING METHOD
    public abstract String toString();

}
