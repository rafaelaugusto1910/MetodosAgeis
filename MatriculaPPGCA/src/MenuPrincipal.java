import java.util.Scanner;

public class MenuPrincipal {
	public static void executar() {
		Scanner scan = new Scanner(System.in);
		InterfaceAlunos interfaceAlunos = new InterfaceAlunos();
		
		
		int opcao = -1;
		
		while(opcao != 0) {
			System.out.println("--------------Menu Principal--------------");
			System.out.println("1 - Inscrição de aluno");
			System.out.println("");
			System.out.println("Digite o numero da opção escolhida: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch(opcao) {
				case 1: interfaceAlunos.exibirFormularioInscricao(); break;
				default: opcao = 0; break;
			}
		}
	}
}
