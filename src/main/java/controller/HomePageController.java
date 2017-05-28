package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.Accountholder;
import serviceImpl.AccountHolderServiceImpl;

@ManagedBean(name = "HomePageController")
@SessionScoped
public class HomePageController {
	private String login;
	private String senha;
	private Boolean isAuth;

	public String xd() {
		login = "hue";
		System.out.println("hue");
		return "";
	}

	public String btnLogin() {
		System.out.println("Aqui");

		Accountholder accHld = new Accountholder();
		accHld.setCpf(1409628876);
		accHld.setAccountNumber(1);
		accHld.setAgencyNumber(1);
		accHld.setPassword("admin");

		AccountHolderServiceImpl accountHolderServiceImpl = new AccountHolderServiceImpl();

		accountHolderServiceImpl.persist(accHld);

		System.out.println(accHld.getId());

		return "";
	}

	public HomePageController() {
		login = new String();
		senha = new String();
		isAuth = false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(Boolean isAuth) {
		this.isAuth = isAuth;
	}

}
