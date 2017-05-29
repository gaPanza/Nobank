package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Accountholder;
import bean.TransactionTransfer;
import serviceImpl.AccountHolderServiceImpl;
import serviceImpl.TransactionServiceImpl;

@ManagedBean(name = "HomePageController")
@SessionScoped
public class HomePageController {
	private static Accountholder accountholder;
	private Long login;
	private String password;
	private Boolean isAuth;
	private static Double money;
	private List<TransactionTransfer> topTransactions = new ArrayList<TransactionTransfer>();

	public String btnLogin() {

		AccountHolderServiceImpl accountHolderServiceImpl = new AccountHolderServiceImpl();
		accountholder = accountHolderServiceImpl.findByCpfAndPassword(login, password);

		TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
		topTransactions = transactionServiceImpl.findTopTransactions(accountholder);

		if (accountholder.equals(null)) {
			return "";
		} else {
			money = accountholder.getMoney();
			return "accountManager.xhtml";
		}
	}

	public static Accountholder getAccountholder() {
		return accountholder;
	}

	public static void setAccountholder(Accountholder accountholder) {
		HomePageController.accountholder = accountholder;
	}

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(Boolean isAuth) {
		this.isAuth = isAuth;
	}

	public Double getMoney() {
		return money;
	}

	public static void setMoney(Double money) {
		HomePageController.money = money;
	}

	public List<TransactionTransfer> getTopTransactions() {
		return topTransactions;
	}

	public void setTopTransactions(List<TransactionTransfer> topTransactions) {
		this.topTransactions = topTransactions;
	}

}
