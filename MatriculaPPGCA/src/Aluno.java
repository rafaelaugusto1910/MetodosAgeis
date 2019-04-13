
public class Aluno {
	private String nome;
	private String cpf;
	private String identificador;
	private String email;
	private Disciplina disciplina;
	
	public Aluno(String nome, String cpf, String identificador, String email, Disciplina disciplina)
	{
		this.nome = nome;
		this.cpf = cpf;
		this.identificador = identificador;
		this.email = email;
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
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return this.identificador + " - " + this.nome;
	}
}
