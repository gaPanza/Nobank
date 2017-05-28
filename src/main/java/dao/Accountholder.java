package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "AccountHolder")
public class Accountholder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="checkId_seq")
    @SequenceGenerator(name="checkId_seq", sequenceName="checkId_seq", allocationSize=1)
	private int id;
	
	@Column
	private Integer cpf;
	
	@Column
	private Integer accountNumber;
	
	@Column
	private Integer agencyNumber;
	
	@Column
	private String password;
	
	public void setPassword(String password){
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(Integer agencyNumber) {
		this.agencyNumber = agencyNumber;
	}
	
	
	
	
}
