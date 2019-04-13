import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
	
	public static void executar() {
		ControleDisciplinas.realizarCargaInicial();
		
		Scanner scan = new Scanner(System.in);
		
		int opcao = -1;
		
		while(opcao != 0) {
			System.out.println("--------------Menu Principal--------------");
			System.out.println("1 - Inscrição do aluno");
			System.out.println("2 - Listar inscrições de alunos");
			System.out.println("3 - Selecionar aluno");
			System.out.println("4 - Matrícular aluno");
			System.out.println("5 - Informar resultado aos alunos");
			System.out.println("Digite o numero da opção escolhida: ");
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch(opcao) {
				case 1: ControleAlunos.exibirFormularioInscricao(); break;
				case 2: ControleDisciplinas.listarTodasInscricoes(); break;
				case 3: ControleDisciplinas.selecionarAlunos(); break;
				case 4: ControleDisciplinas.matricularAlunos(); break;
				case 5: ControleDisciplinas.informarAlunos(); break;
				default: opcao = 0; break;
			}
		}
	}
}
