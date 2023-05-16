import java.sql.Date;
import java.util.Scanner;

public class AppMain {
	
	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
		System.out.println("Menu principal");
		for(MenuOperacoes op: menuOperacoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOperacoes op) {
		SubmenuOperacoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOperacoes lerOpcaoMenuExterno() {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);
		opUsuarioConst = MenuOperacoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOperacoes lerOpcaoSubmenu(MenuOperacoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOperacoes op) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op);
				break;
			case GERAR_SINISTRO:
				System.out.println("Executar metodo gerar Sinistro");
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Executar metodo tranferir seguro");
				break;
			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita");
				break;
			case SAIR:
                break;
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOperacoes opSubmenu) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
			System.out.println("Chamar metodo cadastrar cliente");
			break;
		case CADASTRAR_VEICULO:
			System.out.println("Chamar metodo cadastrar veiculo");
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Chamar metodo cadastrar seguradora");
			break;
		case LISTAR_CLIENTES:
			System.out.println("Chamar metodo listar clientes");
			break;
		case LISTAR_SINISTROS:
			System.out.println("Chamar metodo listar sinistros");
			break;
		case LISTAR_VEICULOS:
			System.out.println("Chamar metodo listar veiculos");
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Chamar metodo excluir cliente");
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Chamar metodo excluir veiculo");
			break;
		case EXCLUIR_SINISTRO:
			System.out.println("Chamar metodo excluir sinistro");
			break;
		case VOLTAR:
			break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOperacoes op) {
		SubmenuOperacoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOperacoes.VOLTAR);
	}
	
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) {

        // Instanciando 2 veiculos:
        Veiculo veiculo1 = new Veiculo("JEK8899", "Ford", "Maverick", 1976);
        Veiculo veiculo2 = new Veiculo("PAC3355", "Mercedes", "C-180", 2002);
        
        //Instanciando 2 clientes (PF e PJ) e uma seguradora:
        ClientePF clientepf = new ClientePF("Gabriel", "Barao Geraldo", 0.0, "111.444.777-35", "masculino", Date.valueOf("2023-03-10"), "Universitario", Date.valueOf("2002-03-10") , "Classe media");
        ClientePJ clientepj = new ClientePJ("Localiza", "Aeroporto VCP", 0, "18781203/0001-28", Date.valueOf("2007-04-11"), 1000);
        Seguradora  seguradora1 = new Seguradora("MC322 INSURANSE", "(19)99955-6678", "mcinsurance@hotmail.com", "Barao Geraldo");

        //Adicionando pelo menos 1 veiculo em cada cliente instanciado:
        clientepf.adicionaVeiculo(veiculo1);
        clientepj.adicionaVeiculo(veiculo2);

        //Cadastrando pelo menos um cliente (pf e pj) na seguradora:
        seguradora1.cadastroCliente(clientepf);
        seguradora1.cadastroCliente(clientepj);

        //Gerando 2 sisnistros:
        seguradora1.gerarSinistro(Date.valueOf("2013-04-11"), "Campinas", seguradora1, veiculo1, clientepf);
        seguradora1.gerarSinistro(Date.valueOf("2023-02-10"), "Brasilia", seguradora1, veiculo2, clientepj);
        
        // O CÁLCULO DO PRECO DO SEGURO E A ATUALIZACAO DO MESMO ESTAO ACONTECENDO AUTOMATICAMENTE NA CLASSE SEGURADORA
        System.out.println("***CLIENTES***");
        seguradora1.listarClientes();
        System.out.println("***SINISTROS***");
        seguradora1.listarSinistros();
        System.out.println("***VISUALIZANDO SINISTRO DE GABRIEL***");
        seguradora1.visualzarSinistro("Gabriel");
        System.out.println("***CALCULO DA RECEITA***");
        System.out.println(seguradora1.calculaReceita());


        //CHAMANDO O MENU DE OPERACOES
		MenuOperacoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOperacoes.SAIR);
		System.out.println("Saiu do sistema");
        
	}

}