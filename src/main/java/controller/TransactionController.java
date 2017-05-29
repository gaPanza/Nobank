package controller;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Accountholder;
import bean.TransactionTransfer;
import serviceImpl.AccountHolderServiceImpl;
import serviceImpl.TransactionServiceImpl;

@ManagedBean(name = "TransactionController")
@ViewScoped
public class TransactionController {
	private Integer account;
	private Integer agency;
	private Double value;
	private Long cpf;

	public String transferMoney() {

		AccountHolderServiceImpl accountHolderServiceImpl = new AccountHolderServiceImpl();
		Accountholder recipient = accountHolderServiceImpl.findByCpf(getCpf());
		Accountholder sender = HomePageController.getAccountholder();

		if (value < 0)
			return "";
		if (sender.getMoney() < value)
			return "";
		if (!recipient.equals(null)) {
			TransactionTransfer transactionTransfer = new TransactionTransfer();
			Calendar calendar = Calendar.getInstance();
			transactionTransfer.setIdAccountholder(sender.getId());
			transactionTransfer.setIdRecipient(recipient.getId());
			transactionTransfer.setValueTransfer(value);
			transactionTransfer.setDate(new Timestamp(calendar.getTimeInMillis()));

			TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();
			try {
				transactionServiceImpl.persistTransfer(transactionTransfer);
			} finally {
				sender.setMoney(sender.getMoney() - value);
				recipient.setMoney(recipient.getMoney() + value);
				accountHolderServiceImpl.update(sender);
				accountHolderServiceImpl.update(recipient);
				HomePageController.setMoney(sender.getMoney());
			}
			return "accountManager.xthml";
		} else {
			return "";
		}

	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Integer getAgency() {
		return agency;
	}

	public void setAgency(Integer agency) {
		this.agency = agency;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
}
