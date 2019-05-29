package br.projecao.ltpw.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.CascadeType;

@Entity
@Table(name = "Professor", catalog = "projecao")
public class Professor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idProfessor;
	private Pessoa pessoa;
	private Double salario;
//	private Set<Turma> turmas = new HashSet<Turma>(0);

	public Professor() {
	}

	public Professor(Pessoa pessoa, Double salario, Set<Turma> turmas) {
		this.pessoa = pessoa;
		this.salario = salario;
//		this.turmas = turmas;
	}

	@Id
	@GeneratedValue

	@Column(name = "idProfessor", unique = true, nullable = false)
	public int getIdProfessor() {
		return this.idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPessoa", nullable = false)
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Column(name = "salario")
	public Double getSalario() {
		return this.salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "Professor_Turma", catalog = "projecao", joinColumns = {
//			@JoinColumn(name = "idProfessor", nullable = false, updatable = false) }, inverseJoinColumns = {
//					@JoinColumn(name = "idTurma", nullable = false, updatable = false) })
//	public Set<Turma> getTurmas() {
//		return this.turmas;
//	}
//
//	public void setTurmas(Set<Turma> turmas) {
//		this.turmas = turmas;
//	}

}
