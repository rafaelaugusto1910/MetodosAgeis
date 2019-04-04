
public class Aluno {
	private String nome;
	private String cpf;
	private String identificador;
	private String disciplina;
	
	public Aluno(String nome, String cpf, String identificador, String disciplina)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.identificador = identificador;
		this.disciplina = disciplina;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
