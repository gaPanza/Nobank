package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
public class Manager {
	private List<Accountholder> accountholders;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkid_seq")
	@SequenceGenerator(name = "checkid_seq", sequenceName = "checkid_seq", allocationSize = 1)
	private int id;
	
	@Column
	private Long cpf;
	
	@Column
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Manager")
	private List<Accountholder> getAccountHolders(){
		return accountholders;
	}

	public List<Accountholder> getAccountholders() {
		return accountholders;
	}

	public void setAccountholders(List<Accountholder> accountholders) {
		this.accountholders = accountholders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Manager(List<Accountholder> accountholders, Long cpf, String password) {
		super();
		this.accountholders = accountholders;
		this.cpf = cpf;
		this.password = password;
	}

}
