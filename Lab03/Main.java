import java.sql.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Seguradora MC322_Insurance = new Seguradora("MC322_Insurance", "(19)99341-7762", "mcinsurance@gmail.com", "Barao Geraldo");
        Scanner in = new Scanner(System.in);
        System.out.print("Cadastrando o cliente:  \nEntre com o tipo de cliente (PF) ou (PJ), apenas letras maiúsculas >> ");
        String tipo_de_cliente = in.nextLine();
        in.nextLine();
        
        while(!tipo_de_cliente.equals("PF") && !tipo_de_cliente.equals("PJ")){
            System.out.print("DIGITE APENAS PF OU PJ >> ");
            tipo_de_cliente = in.nextLine();
        }
        if(tipo_de_cliente.equals("PF")){
            System.out.print("QUAL A DATA DA LICENCA? (SIM, entre com a data em MILISEGUNDOS a partir de 1970)");
            long ano = in.nextLong();
            in.nextLine();
            Date data = new Date(ano);
            System.out.print("ENTRE COM O NOME >> ");
            String nome =  in.nextLine();
            System.out.print("ENTRE COM O ENDERECO >> ");
            String endereco = in.nextLine();
            System.out.print("ENTRE COM O NIVEL DE ESCOLARIDADE >> ");
            String educacao = in.nextLine();
            System.out.print("ENTRE COM O GENERO >> ");
            String genero = in.nextLine();
            System.out.print("ENTRE COM A CLASSE ECONOMICA >> ");
            String classeEconomica = in.nextLine();
            System.out.print("ENTRE COM O CPF >> ");
            String cpf = in.nextLine();
            System.out.print("ENTRE COM O NUMERO DE VEICULOS A SEREM CADASTRADOS >> ");
            int n = in.nextInt();

            while(MC322_Insurance.registerClientPF(nome, endereco, data, educacao, genero, classeEconomica, cpf, data, n) == false){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("ERRO: CPF INVÁLIDO :( \nENTRE COM UM CPF VÁLIDO >> ");
                cpf = in.nextLine();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("GERANDO UM SINISTRO");
            in.nextLine();
            System.out.print("ENTRE COM O ENDERECO >> ");
            String endereco2 = in.nextLine();
            System.out.print("ENTRE COM A DATA, NO FORMATO QUE PREFERIR >> ");
            String date = in.nextLine();
            MC322_Insurance.generateSinistro(date, endereco2, MC322_Insurance, MC322_Insurance.getListaClientes(0).getVeiculo(0), MC322_Insurance.getListaClientes(0));
            MC322_Insurance.listarCLientes();
            MC322_Insurance.listarSinistros();
            in.nextLine();
    
        }

        else {
            System.out.print("QUAL A DATA DA LICENCA? (SIM, entre com a data em MILISEGUNDOS a partir de 1970)");
            long ano = in.nextLong();
            in.nextLine();
            Date data = new Date(ano);
            System.out.print("ENTRE COM O NOME >> ");
            String nome =  in.nextLine();
            System.out.print("ENTRE COM O ENDERECO >> ");
            String endereco = in.nextLine();
            System.out.print("ENTRE COM O NIVEL DE ESCOLARIDADE >> ");
            String educacao = in.nextLine();
            System.out.print("ENTRE COM O GENERO >> ");
            String genero = in.nextLine();
            System.out.print("ENTRE COM A CLASSE ECONOMICA >> ");
            String classeEconomica = in.nextLine();
            System.out.print("ENTRE COM O CNPJ >> ");
            String cnpj = in.nextLine();
            System.out.print("ENTRE COM O NUMERO DE VEICULOS A SEREM CADASTRADOS >> ");
            int n = in.nextInt();

            while(MC322_Insurance.registerClientePJ(nome, endereco, data, educacao, genero, classeEconomica, cnpj, data, n) == false){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("ERRO: CNPJ INVÁLIDO :( \nENTRE COM UM CNPJ VÁLIDO >> ");
                cnpj = in.nextLine();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("GERANDO UM SINISTRO");
            in.nextLine();
            System.out.print("ENTRE COM O ENDERECO >> ");
            String endereco2 = in.nextLine();
            System.out.print("ENTRE COM A DATA, NO FORMATO QUE PREFERIR >> ");
            String date = in.nextLine();
            MC322_Insurance.generateSinistro(date, endereco2, MC322_Insurance, MC322_Insurance.getListaClientes(0).getVeiculo(0), MC322_Insurance.getListaClientes(0));
            MC322_Insurance.listarCLientes();
            MC322_Insurance.listarSinistros();
            in.nextLine();
        }
        
        MC322_Insurance.removeCliente(MC322_Insurance.getListaClientes(0));
        MC322_Insurance.removeSinistro(MC322_Insurance.getListaSinistros(0));
        in.close();

    }

    
}
