package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Accountholder")
public class Accountholder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkid_seq")
	@SequenceGenerator(name = "checkid_seq", sequenceName = "checkid_seq", allocationSize = 1)
	private int id;

	@Column
	private Long cpf;

	@Column
	private Integer accountNumber;

	@Column
	private Integer agencyNumber;

	@Column
	private String password;

	@Column
	private Double money;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Manager_id")
	private Manager manager;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Accountholder(int id, Long cpf, Integer accountNumber, Integer agencyNumber, String password, Double money) {
		this.id = id;
		this.cpf = cpf;
		this.accountNumber = accountNumber;
		this.agencyNumber = agencyNumber;
		this.password = password;
		this.money = money;
	}

	public Accountholder(Long cpf, Integer accountNumber, Integer agencyNumber, String password, Double money) {
		this.cpf = cpf;
		this.accountNumber = accountNumber;
		this.agencyNumber = agencyNumber;
		this.password = password;
		this.money = money;
	}
	
	

	public Accountholder(Long cpf, Integer accountNumber, Integer agencyNumber, String password, Double money,
			Manager manager) {
		this.cpf = cpf;
		this.accountNumber = accountNumber;
		this.agencyNumber = agencyNumber;
		this.password = password;
		this.money = money;
		this.manager = manager;
	}

	public Accountholder() {

	}

}
