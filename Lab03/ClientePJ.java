import java.sql.Date;

public class ClientePJ extends Cliente {
    // INSTANCE VARIABLES
    private final String cnpj;
    private Date dataFundacao;

    // CONSTRUCTOR METHOD
    public ClientePJ(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cnpj, Date dataFundacao){
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    // GETTERS AND SETTERS
    public String getCnpj(){
        return cnpj;
    }
    // public void setCnpj(String cnpj){
    //     this.cnpj = cnpj;
    // }
    public Date getDataFundacao(){
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    // AUXILIAR FUNCTION
    private int verificaResto(int a){
        if(a >= 2){
            return 11-a;
        }
        else{
            return 0;
        }
    }
    // VALIDAR CNPJ

    public boolean validarCnpj(String cnpj){
        String cnpjTratado = cnpj.replaceAll("\\.", "");
        cnpjTratado = cnpjTratado.replaceAll("-", "");
        cnpjTratado = cnpjTratado.replaceAll("/", "");

        if(cnpjTratado.length() != 14){
            return false;
        }else{
            int[] l1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}; //12
            int[] l2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}; //13
            int s1 = 0;
            int s2 = 0;
            for(int i = 0; i < cnpjTratado.length(); i++){
                if(i < 12){
                    s1  += ((int) cnpjTratado.charAt(i) - 48) * l1[i];
                }
                if(i < 13){
                    s2 += ((int) cnpjTratado.charAt(i) - 48) * l2[i];
                }  
            }
            s1 = verificaResto(s1%11);
            s2 = verificaResto(s2%11);
            
            if(s1 != (int) cnpjTratado.charAt(12) -48 || s2 != cnpjTratado.charAt(13) - 48){
                return false;
            }
            else{
                return true;
            }
        }
    }

    // TOSTRING METHOD
    public String toString(){
        return "NOME: " + nome + "\n" + "ENDERECO: " + endereco + "\n" + "DATA DA LICENCA: " + dataLicenca + "\n" + "EDUCACAO: " + educacao + "\n" + "GENERO: " + genero + "\n" + "CNPJ: " + cnpj + "\n" + "DATA DE FUNDACAO: " + dataFundacao + "\n";
    }
}
