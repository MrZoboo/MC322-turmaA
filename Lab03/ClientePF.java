import java.sql.Date;

public class ClientePF extends Cliente {
    // INSTANCE VARIABLES
    private final String cpf;
    private Date dataNascimento;
    
    // CONSTRUCTOR
    public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero, String classeEconomica, String cpf, Date dataNascimento){
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    // GETTERS AND SETTERS
    public String getCpf(){
        return cpf;
    }
    // public void setCpf(String cpf){
    //     this.cpf = cpf;
    // }
    public Date getDate(){
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
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
    // CPF VALIDATION
    public boolean validarCPF(String cpf){
        String cpfTratado = cpf.replaceAll("\\.", "");
        cpfTratado = cpfTratado.replaceAll("-", "");
        
        if(cpfTratado.length() != 11){
            return false;
        }else{
            boolean igual = true;
            int k = 10;
            int s1 = 0;
            int s2 = 0;
            for(int i= 0; i < cpfTratado.length(); i++){
                if(i < cpfTratado.length() - 2){
                    s1 += ((int)cpfTratado.charAt(i)- 48)*k;
                }
                if(i < cpfTratado.length() - 1){
                    s2 += ((int)cpfTratado.charAt(i)- 48)*(k+1);
                }
                
                if(cpfTratado.charAt(0) != cpfTratado.charAt(i)){
                    igual = false;
                }
                k--;
            }
            s1 = verificaResto(s1%11);
            s2 = verificaResto(s2%11);

            if(s1 != (int) cpfTratado.charAt(9) -48 || s2 != cpfTratado.charAt(10) - 48){
                return false;
            }
            else{
                return !igual;
            }
            
        }
    }
    
    // TO STRING METHOD
    public String toString(){
        return "NOME: " + nome + "\n" + "ENDERECO: " + endereco + "\n" + "DATA DA LICENCA: " + dataLicenca + "\n" + "EDUCACAO: " + educacao + "\n" + "GENERO: " + genero + "\n" + "CPF: " + cpf + "\n" + "DATA DE NASCIMENTO: " + dataNascimento + "\n";
    }
}
