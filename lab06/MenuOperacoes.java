public enum MenuOperacoes {
    CADASTROS("Cadastros", new SubmenuOperacoes[] {
			SubmenuOperacoes.CADASTRAR_CLIENTE,
			SubmenuOperacoes.CADASTRAR_VEICULO,
			SubmenuOperacoes.CADASTRAR_SEGURADORA,
			SubmenuOperacoes.VOLTAR
	}),
	LISTAR("Listar", new SubmenuOperacoes[] {
			SubmenuOperacoes.LISTAR_CLIENTES,
			SubmenuOperacoes.LISTAR_SINISTROS,
			SubmenuOperacoes.LISTAR_VEICULOS,
			SubmenuOperacoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubmenuOperacoes[] {
			SubmenuOperacoes.EXCLUIR_CLIENTE,
			SubmenuOperacoes.EXCLUIR_VEICULO,
			SubmenuOperacoes.EXCLUIR_SINISTRO,
			SubmenuOperacoes.VOLTAR}),
	GERAR_SINISTRO("Gerar Sinistro", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
	TRANSFERIR_SEGURO("Transferir Seguro", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
	CALCULAR_RECEITA("Calcular Receita", new SubmenuOperacoes[] {SubmenuOperacoes.VOLTAR}),
	SAIR("Sair", new SubmenuOperacoes[] {});
	
	//atributos
	private final String descricao;
	private final SubmenuOperacoes[] submenu;
	
	//Construtor
	MenuOperacoes(String descricao, SubmenuOperacoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOperacoes[] getSubmenu() {
		return submenu;
	}

    public static class Validacao{

        //CHECK IF THE CPF IS ELEGIBLE
        public static boolean validaCPF(String cpf){
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
        //CHECK IF THE CNPJ IS ELEGIBLE
        public static boolean validaCNPJ(String cnpj){
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
        //CHECK IF THE NAME IS ELEGIBLE
        public static boolean validaNome(String nome){
            boolean valido = true;
            
            for(int i = 0; i < nome.length(); i++){
                int a = (int) nome.charAt(i);
                if((a < 65) || (a > 90 && a < 97) || (a > 122)){
                    valido = false;
                    break;   
                }
            }
            return valido;
        }
        // AUXILIAR FUNCTION
        private static int verificaResto(int a){
            if(a >= 2){
                return 11-a;
            }
            else{
                return 0;
            }
        }
    }
}