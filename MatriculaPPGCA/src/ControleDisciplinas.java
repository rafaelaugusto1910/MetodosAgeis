import java.util.ArrayList;
import java.util.Scanner;

public class ControleDisciplinas {
	
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public static ArrayList<Professor> professores = new ArrayList<Professor>() {
		{
			add(new Professor(1, "Pedro"));
			add(new Professor(2, "Jose"));
			add(new Coordenador(3, "Maria"));
		}
	};
	
	
	public static Disciplina buscarDisciplina(String codigo) {
		for(Disciplina disciplina : disciplinas)
			if (disciplina.getCodigo().equals(codigo))
				return disciplina;
		
		return null;
	}
	
	public static void listarDisciplinas() {
		System.out.println("");
		System.out.println("------------- Disciplinas -------------");
		for(Disciplina disciplina : disciplinas) {
			System.out.println(disciplina.toString());
		}
		System.out.println("");
	}
	
	public static boolean verificarProfessor() {
		System.out.println("Digite seu código de professor: ");
		int codigo = scan.nextInt();
		
		for(Professor professor : professores) {
			if (professor.getCodigo() == codigo) {
				scan.nextLine();
				return true;
			}
		}
		
		scan.nextLine();
		return false;
	}
	
	public static boolean verificarCoordenador() {
		System.out.println("Digite seu código de coordenador: ");
		int codigo = scan.nextInt();
		
		for(Professor professor : professores) {
			
			if (professor.getCodigo() == codigo && professor instanceof Coordenador) {				
				scan.nextLine();
				return true;
			}
		}
		scan.nextLine();
		return false;
	}
	
	public static void listarTodasInscricoes() {
		
		if (!verificarCoordenador())
		{
			System.out.println("Você não está cadastrado como um coordenador!");
			return;
		}
		
		for(Disciplina disciplina : disciplinas) {
			System.out.println("------------ " + disciplina.toString() + " -----------" );
			for(Aluno aluno : disciplina.getInscritos()) {
				System.out.println("INSCRITO -- " + aluno.toString());
			}
			for(Aluno aluno : disciplina.getSelecionados()) {
				System.out.println("SELECIONADO -- " + aluno.toString());
			}
			for(Aluno aluno : disciplina.getMatriculados()) {
				System.out.println("MATRICULADO -- " + aluno.toString());
			}
			System.out.println("");
		}
		
		System.out.println("");
	}
	
	public static void listarParaSelecao(String codigoDisciplina) {
		Disciplina disciplinaEscolhida = buscarDisciplina(codigoDisciplina);
		
		if (disciplinaEscolhida == null) {
			System.out.println("Disciplina não encontrada! Digite o código novamente..");
			return;
		}
		
		System.out.println("--------- Alunos Inscritos ----------");
		for(Aluno aluno : disciplinaEscolhida.getInscritos()) {
			System.out.println(aluno.toString());
		}
		
		System.out.println("");
	}
	
	public static void listarParaMatricula(String codigoDisciplina) {
		Disciplina disciplinaEscolhida = buscarDisciplina(codigoDisciplina);
		
		if (disciplinaEscolhida == null) {
			System.out.println("Disciplina não encontrada! Digite o código novamente..");
			return;
		}
		
		System.out.println("--------- Alunos Selecionados ----------");
		for(Aluno aluno : disciplinaEscolhida.getSelecionados()) {
			System.out.println(aluno.toString());
		}
		
		System.out.println("");
	}
	
	public static void listarMatriculados(String codigoDisciplina) {
		Disciplina disciplinaEscolhida = buscarDisciplina(codigoDisciplina);
		
		if (disciplinaEscolhida == null) {
			System.out.println("Disciplina não encontrada! Digite o código novamente..");
			return;
		}
		
		System.out.println("--------- Alunos Matriculados ----------");
		for(Aluno aluno : disciplinaEscolhida.getMatriculados()) {
			System.out.println(aluno.toString());
		}
		
		System.out.println("");
	}
	
	public static void selecionarAlunos() {
		
		if (!verificarProfessor()) {
			System.out.println("Você não está cadastrado como um professor!");
			return;
		}
		
		listarDisciplinas();
		Disciplina disciplina = null;
		
		do {
			System.out.println("Caro Professor, digite o código da sua disciplina: ");
			String codigo = scan.nextLine();
			
			disciplina = buscarDisciplina(codigo);
			listarParaSelecao(codigo);
			
			System.out.println("Por favor, digite os identificadores dos alunos selecionados, separados por ponto e vírgula (;)");
			String identificadores = scan.nextLine();
			String[] listaIdentificadores = identificadores.split(";");
			
			for(String identificador : listaIdentificadores) {
				disciplina.selecionarAluno(identificador);
			}
			
			listarParaMatricula(disciplina.getCodigo());
			
		} while (disciplina == null);
	}
	
	public static void matricularAlunos() {

		if (!verificarCoordenador()) {
			System.out.println("Você não está cadastrado como um coordenador!");
			return;
		}
		
		listarDisciplinas();
		Disciplina disciplina = null;
		
		do {
			System.out.println("Caro Professor, digite o código da sua disciplina: ");
			String codigo = scan.nextLine();
			
			disciplina = buscarDisciplina(codigo);
			listarParaMatricula(codigo);
			
			System.out.println("Por favor, digite os identificadores dos alunos matriculados, separados por ponto e vírgula (;)");
			String identificadores = scan.nextLine();
			String[] listaIdentificadores = identificadores.split(";");
			
			for(String identificador : listaIdentificadores) {
				disciplina.matricularAluno(identificador);
			}
			
			listarMatriculados(disciplina.getCodigo());
			
		} while (disciplina == null);
	}
	
	public static void realizarCargaInicial() {
		disciplinas.add(new Disciplina("CABS001", "Algoritmos e Estruturas de Dados"));
		disciplinas.add(new Disciplina("CABS002", "Programação Avançada"));
		disciplinas.add(new Disciplina("CABS003", "Engenharia de Requisitos (vide CAES003)"));
		disciplinas.add(new Disciplina("CABS004", "Projeto de Software"));
		disciplinas.add(new Disciplina("CABS005", "Inteligência Artificial"));
		disciplinas.add(new Disciplina("CABS006", "Sistemas Operacionais"));
		disciplinas.add(new Disciplina("CABS007", "Projeto e Análise de Algoritmos"));
		disciplinas.add(new Disciplina("CABS008", "Bancos de Dados"));
		disciplinas.add(new Disciplina("CABS009", "Metodologia de Pesquisa"));
		disciplinas.add(new Disciplina("CABS010", "Processamento Digital de Imagens"));
		disciplinas.add(new Disciplina("CABS011", "Redes de Computadores"));
	}
}
