package sistema.model;

import java.awt.Container;

public class aluno implements Entidade {
	private Integer codigo;
	private String sexo;
	private String nome;
	private Long cpf;
	private Long rg;
	private Long telefone;
	private Long celular;
	private String endereco;
	private String email;
	private String cidade;
	private String cep;
	

	

	public aluno() {

	}

	public aluno(Integer codigo,String sexo, String nome, Long cpf, Long rg, Long telefone, Long celular, String endereco,
			String email, String cidade, String cep) {
		this.codigo = codigo;
		this.sexo=sexo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;
		this.email = email;
		this.cidade = cidade;
		this.cep = cep;
	 
	}

	public Integer getCodigo() {
		return this.codigo;
	}
	
	
	public void setSexo(String sexo){
		this.sexo=sexo;
	}
	
	public String getSexo(){
		return this.sexo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}