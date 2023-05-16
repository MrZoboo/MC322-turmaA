import java.sql.Date;

public class Sinistro {
    private final int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //CONSTRUCTOR
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
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

    // GETTERS AND SETTERS
    public Date getData(){
        return data;
    }
    public void setData(Date data){
        this.data = data;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public int getId(){
        return id;
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

    public String toString(){
        return "ID do sinistro: " + id +  "\n" + "Nome do Cliente: " + cliente.getNome() + "\n" + "Placa do Carro: " + veiculo.getPlaca() + "\n" + "Seguradora: " + seguradora.getNome() +  "\n" + "Data: " + data + "\n" + "Endereco: " + endereco + "\n";
    }

}
