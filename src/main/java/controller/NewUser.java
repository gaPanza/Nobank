package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Accountholder;
import serviceImpl.AccountHolderServiceImpl;

@ManagedBean(name = "NewUser")
@ViewScoped
public class NewUser {
	private Long cpf;
	private String senha;

	public String delegateUser() {
		try {

			AccountHolderServiceImpl accountHolderServiceImpl = new AccountHolderServiceImpl();
			int accountNumber = (int) (Math.random() * 9999);

			if (accountNumber <= 1000) {
				accountNumber = accountNumber + 1000;
			}
			int agencyNumber = (int) (Math.random() * 9999);

			if (agencyNumber <= 1000) {
				agencyNumber = agencyNumber + 1000;
			}
			Accountholder accountHolder = new Accountholder(cpf, accountNumber, agencyNumber, senha, 1000.00);
			accountHolderServiceImpl.persist(accountHolder);
			return "login.xhtml";
		} catch (Exception e) {
			return "error";
		}
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
