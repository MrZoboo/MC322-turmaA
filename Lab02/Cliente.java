

public class Cliente {
    // Instance variables
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    // Constructor method
    public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Getters e setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    // toSring method
    public String toString() {
        return "Nome: " + nome + "\n" + "Cpf: " + cpf + "\n" + "Data de nascimento: " + dataNascimento + "\n" + "Idade: " + idade + "\n" + "Endereco: "  + endereco + "\n";
    }

    private int verificaResto(int a){
        if(a >= 2){
            return 11-a;
        }
        else{
            return 0;
        }
    }

    // Validar cpf
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
     
    
}
