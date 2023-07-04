import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Seguro {
    // Instance variables
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    protected double valorMensal;
    protected List<Sinistro> listaSinistros = new ArrayList<>();
    protected List<Condutor> listaCondutores = new ArrayList<>();
    public Cliente cliente;

    // Constructors
    public Seguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora, double valorMensal, Cliente cliente){
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.valorMensal = valorMensal;
        this.cliente = cliente;
    }
    public Seguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora, double valorMensal, List<Sinistro> listaSinistros, List<Condutor> listaCondutores, Cliente cliente){
        this.id = id; 
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.valorMensal = valorMensal;
        this.listaCondutores = listaCondutores;
        this.listaSinistros = listaSinistros;
        this.cliente = cliente;
    }

    //Getters and Setters
    public int getId() {
        return this.id;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return this.seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public double getValorMensal() {
        return this.valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public List<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public List<Condutor> getListaCondutores() {
        return this.listaCondutores;
    }

    public void setListaCondutores(List<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public Cliente getCliente(){
        return cliente;
    }
     
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    

    public abstract boolean autorizarCondutor(Condutor condutor);

    public abstract boolean desautorizarCondutor(Condutor condutor);
    
    public abstract double calcularValor();
    
    public abstract boolean gerarSinistro();

}
