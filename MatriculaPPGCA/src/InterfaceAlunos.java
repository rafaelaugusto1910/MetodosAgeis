import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceAlunos {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public void exibirFormularioInscricao() {
		Aluno novoAluno = null;
		
		System.out.println("Digite o nome do aluno: ");
		String nome = scan.nextLine();
		
		System.out.println("Digite o cpf do aluno: ");
		String cpf = scan.nextLine();
		
		System.out.println("Digite o identificador do aluno: ");
		String identificador = scan.nextLine();
		
		System.out.println("Digite o codigo da disciplina: ");
		String disciplina = scan.nextLine();
		
		novoAluno = new Aluno(nome, cpf, identificador, disciplina);
		alunos.add(novoAluno);
		
		System.out.println("Aluno inscrito com sucesso!");
		System.out.println("");
	}
	
}
