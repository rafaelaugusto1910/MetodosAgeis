import java.util.ArrayList;

public class Disciplina {
	private String codigo;
	private String nome;
	private ArrayList<Aluno> alunosInscritos;
	private ArrayList<Aluno> alunosMatriculados;
	private ArrayList<Aluno> alunosSelecionados;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Aluno> getInscritos() {
		return this.alunosInscritos;
	}
	public ArrayList<Aluno> getMatriculados() {
		return this.alunosMatriculados;
	}
	public ArrayList<Aluno> getSelecionados() {
		return this.alunosSelecionados;
	}
	
	public Disciplina(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.alunosInscritos = new ArrayList<Aluno>();
		this.alunosMatriculados = new ArrayList<Aluno>();
		this.alunosSelecionados = new ArrayList<Aluno>();
	}
	
	public boolean inscreverAluno(Aluno aluno) {
		for(Aluno alunoAux : alunosInscritos) {
			if (alunoAux.getIdentificador().equals(aluno.getIdentificador())) {
				return true;
			}
		}
		
		for(Aluno alunoAux : alunosSelecionados) {
			if (alunoAux.getIdentificador().equals(aluno.getIdentificador())) {
				return true;
			}
		}
		
		for(Aluno alunoAux : alunosMatriculados) {
			if (alunoAux.getIdentificador().equals(aluno.getIdentificador())) {
				return true;
			}
		}
		
		return alunosInscritos.add(aluno);
	}
	
	public boolean selecionarAluno(String identificadorAluno) {
		Aluno alunoInscrito = null; 
		for(Aluno aluno : alunosInscritos) {
			if (aluno.getIdentificador().equals(identificadorAluno)) {
				alunoInscrito = aluno;
				break;
			}
		}
				
		if (alunoInscrito == null) return false;
		
		alunosSelecionados.add(alunoInscrito);
		alunosInscritos.remove(alunoInscrito);
		
		return true;
	}
	
	public boolean matricularAluno(String identificadorAluno) {
		Aluno alunoSelecionado = null;
		
		for(Aluno aluno : alunosSelecionados) {
			if (aluno.getIdentificador().equals(identificadorAluno)) {
				alunoSelecionado = aluno;
				break;
			}
		}
		
		if (alunoSelecionado == null) return false;
		
		alunosMatriculados.add(alunoSelecionado);
		alunosSelecionados.remove(alunoSelecionado);
		
		return true;
	}
	
	@Override
	public String toString() {
		return this.codigo + " - " + this.nome;
	}
}
