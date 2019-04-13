import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ControleAlunos {
	
	private static Scanner scan = new Scanner(System.in);
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public static Aluno buscarAluno(String identificador) {
		for(Aluno aluno : alunos)
			if (aluno.getIdentificador().equals(identificador))
				return aluno;
		
		return null;
	}
	
	public static Aluno exibirFormularioInscricao() {
		System.out.println("Digite o nome do aluno: ");
		String nome = scan.nextLine();
		
		System.out.println("Digite o cpf do aluno: ");
		String cpf = scan.nextLine();
		
		System.out.println("Digite o identificador do aluno: ");
		String identificador = scan.nextLine();
		
		Disciplina disciplina = null;
		ControleDisciplinas.listarDisciplinas();
		do {
			System.out.println("Digite o codigo da disciplina: ");
			String codigoDisciplina = scan.nextLine();
			
			disciplina = ControleDisciplinas.buscarDisciplina(codigoDisciplina);
			
			if (disciplina == null)
				System.out.println("Disciplina não encontrada com este código!");
			
		} while (disciplina == null);
		
		Aluno novoAluno = new Aluno(nome, cpf, identificador, disciplina);
		alunos.add(novoAluno);		
		disciplina.inscreverAluno(novoAluno);
		
		System.out.println("Aluno inscrito com sucesso!");
		System.out.println("");

		return novoAluno;
	}
}
