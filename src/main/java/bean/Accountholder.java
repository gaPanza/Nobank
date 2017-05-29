package bean;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "AccountHolder")
@SqlResultSetMapping(name = "AccountholderbyCPF", classes = {
		@ConstructorResult(targetClass = Accountholder.class, columns = { @ColumnResult(name = "id"),
				@ColumnResult(name = "cpf", type = Long.class), @ColumnResult(name = "accountNumber"),
				@ColumnResult(name = "agencyNumber"), @ColumnResult(name = "password"),
				@ColumnResult(name = "money", type = Double.class) }) })
public class Accountholder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkId_seq")
	@SequenceGenerator(name = "checkId_seq", sequenceName = "checkId_seq", allocationSize = 1)
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

	public Accountholder() {

	}

}
