import java.util.ArrayList;
import java.util.List;

public class Frota {
    private String code;
    private List<Veiculo> listaVeiculos = new ArrayList<>();

    public Frota(String code, List<Veiculo> listaVeiculos){
        this.code = code;
        this.listaVeiculos = listaVeiculos;
    }
    public Frota(String code){
        this.code = code;
    }
    
    //GETTERS AND SETTERS
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;  
    }
    public List<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }

    public boolean addVeiculo(Veiculo veiculo){
        boolean possible = true;
        for(Veiculo v: listaVeiculos){
            if(v == veiculo){
                possible = false;
            }
        }
        if(possible){
            listaVeiculos.add(veiculo);
        }
        return possible;
    }
    public boolean removeVeiculo(Veiculo veiculo){
        boolean possible = true;
        for(Veiculo v: listaVeiculos){
            if(v == veiculo){
                listaVeiculos.remove(v);
                return possible;
            }
        }
        return possible;
    }

    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", listaVeiculos='" + getListaVeiculos() + "'" +
            "}";
    }
    
}