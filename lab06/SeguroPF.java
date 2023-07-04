import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class SeguroPF extends Seguro{
    // Instance variables
    private Veiculo veiculo;

    //Constructors
    public SeguroPF(int id, Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        super(id, dataInicio, dataFim, seguradora, 1, cliente);
        this.valorMensal = calcularValor();
        this.veiculo = veiculo;
    }
    public SeguroPF(int id, Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, Veiculo veiculo, Cliente cliente){
        super(id, dataInicio, dataFim, seguradora, 1, listaSinistros, listaCondutores, cliente);
        this.valorMensal = calcularValor();
        this.veiculo = veiculo;
    }
    
    //Getters and setters
    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean autorizarCondutor(Condutor condutor){
        boolean isPossible = true;
        for(Condutor c: listaCondutores){
            if(c.equals(condutor)){
                return !isPossible;
            }
        }
        listaCondutores.add(condutor);
        return isPossible;
    }

    public boolean desautorizarCondutor(Condutor condutor){
        boolean isPossible = true;
        for(Condutor c : listaCondutores){
            if(c.equals(condutor)){
                listaCondutores.remove(c);
                return isPossible;
            }
        }
        return !isPossible;
    }
    public boolean gerarSinistro(){
        return true;
    }

    public double calcularValor(){
        int VALOR_BASE = 10;
        double FATOR_IDADE;
        if(cliente.calculaIdade() < 30){
            FATOR_IDADE = 1.25;

        }else if(cliente.calculaIdade() < 60){
            FATOR_IDADE = 1.0;
        }
        else{
            FATOR_IDADE = 1.5;
        }

        double valor = VALOR_BASE*FATOR_IDADE*(1+1/())
    }

    @Override
    public String toString() {
        return "{" +
            " veiculo='" + getVeiculo() + "'" +
            ", cliente='" + getCliente() + "'" +
            "}";
    }
    

}
