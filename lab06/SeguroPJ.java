import java.sql.Date;
import java.util.List;

public class SeguroPJ extends Seguro {
    public Frota frota;   

    //Constructors
    public SeguroPJ(int id, Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, Cliente cliente){
        super(id, dataInicio, dataFim, seguradora, 1, cliente);
        this.valorMensal = calcularValor();
        this.frota = frota;
    }
    public SeguroPJ(int id, Date dataInicio, Date dataFim, Seguradora seguradora, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, Frota frota, Cliente cliente){
        super(id, dataInicio, dataFim, seguradora, 1, listaSinistros, listaCondutores, cliente);
        this.valorMensal = calcularValor();
        this.frota = frota;
    }

    //Getters and Setters

    public Frota getFrota() {
        return this.frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
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
        double valor;
        int idade = cliente.calculaIdade();
        
        valor = VALOR_BASE*(1 + 1/(frota.getListaVeiculos().size()+2))*(1 +  1/(idade+2));
        return valor;
    }

}
