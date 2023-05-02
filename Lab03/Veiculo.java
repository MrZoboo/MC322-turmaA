public class Veiculo {
    // INSTANCE VARIABLES
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    // CONSTRUCTOR
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    //GETTERS AND SETTERS
    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public int getAnoFabricacao(){
        return anoFabricacao;
    }
    public void setAnoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }

    // TOSTRING METHOD
    @Override
    public String toString() {
        return "PLACA: " + placa + "\n" + "MARCA: " + marca + "\n" + "MODELO: " + modelo + "\n" + "ANO DE FABRICACAO: " + anoFabricacao + "\n";
    }
}
