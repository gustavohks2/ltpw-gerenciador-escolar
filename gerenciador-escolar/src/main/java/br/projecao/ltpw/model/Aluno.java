package br.projecao.ltpw.model;
// Generated 04/05/2019 17:43:09 by Hibernate Tools 4.3.1


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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Aluno generated by hbm2java
 */
@Entity
@Table(name="Aluno"
    ,catalog="projecao"
)
public class Aluno  implements java.io.Serializable {


     private int idAluno;
     private Pessoa pessoa;
     private Integer semestre;
     private Set<Turma> turmas = new HashSet<Turma>(0);

    public Aluno() {
    }

	
    public Aluno(int idAluno, Pessoa pessoa) {
        this.idAluno = idAluno;
        this.pessoa = pessoa;
    }
    public Aluno(int idAluno, Pessoa pessoa, Integer semestre, Set<Turma> turmas) {
       this.idAluno = idAluno;
       this.pessoa = pessoa;
       this.semestre = semestre;
       this.turmas = turmas;
    }
   
     @Id 
     @GeneratedValue
    
    @Column(name="idAluno", unique=true, nullable=false)
    public int getIdAluno() {
        return this.idAluno;
    }
    
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name="idPessoa", referencedColumnName = "idPessoa")
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
    @Column(name="semestre")
    public Integer getSemestre() {
        return this.semestre;
    }
    
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

@ManyToMany()
    @JoinTable(name="Aluno_Turma", catalog="projecao", joinColumns = { 
        @JoinColumn(name="idAluno", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="idTurma", nullable=false, updatable=false) })
    public Set<Turma> getTurmas() {
        return this.turmas;
    }
    
    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }




}

