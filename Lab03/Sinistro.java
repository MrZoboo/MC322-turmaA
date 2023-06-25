import java.lang.Math;

public class Sinistro {
    //INSTANCE VARIABLES
    private final int id;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //CONSTRUCTOR
    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.id = GenerateIds();
    }

    // FUNCTION THAT GENERATES UNIQUE IDS
    private  int GenerateIds(){
        int A = (int) (Math.random()*1000000);
        int B = 0;
        int C = 0;

        for(int i = 0; i < cliente.getNome().length(); i++){
            B += (int) cliente.getNome().charAt(i);
        }
        B = 10*B /(B + 1);

        for(int i = 0; i < veiculo.getModelo().length(); i++){
            C += (int) veiculo.getModelo().charAt(i);
        }
        C = 10*C /(C + 1);

        return A*100 + B*10 + C;
    }
    
    //GETTERS E SETTERS
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public Seguradora getSeguradora(){
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public int getId(){
        return id;
    }

    // TO STRING METHOD
    public String toString(){
        return "ID: " + id + "\n" + "DATA: " + data + "\n" + "ENDERECO: " + endereco + "\n" + "SEGURADORA: " + seguradora.getNome() + "\n" + "CLIENTE: " + cliente.getNome() + "\n" + "VEICULO: " + veiculo.getPlaca() + "\n";
    }
    
}
