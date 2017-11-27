package model;

import java.sql.Timestamp;

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
@Table(name = "transactiontransfer")
public class TransactionTransfer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkid_seqtrans")
	@SequenceGenerator(name = "checkid_seqtrans", sequenceName = "checkid_seqtrans", allocationSize = 1)
	private long id;

	@Column
	private int idAccountholder;

	@Column
	private Double valueTransfer;

	@Column
	private int idRecipient; // Accountholder que recebe o dinheiro

	@Column
	private Timestamp date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdAccountholder() {
		return idAccountholder;
	}

	public void setIdAccountholder(int idAccountholder) {
		this.idAccountholder = idAccountholder;
	}

	public Double getValueTransfer() {
		return valueTransfer;
	}

	public void setValueTransfer(Double valueTransfer) {
		this.valueTransfer = valueTransfer;
	}

	public int getIdRecipient() {
		return idRecipient;
	}

	public void setIdRecipient(int idRecipient) {
		this.idRecipient = idRecipient;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public TransactionTransfer(long id,  Timestamp date,  int idAccountholder, int idRecipient, Double valueTransfer) {
		super();
		this.id = id;
		this.idAccountholder = idAccountholder;
		this.valueTransfer = valueTransfer;
		this.idRecipient = idRecipient;
		this.date = date;
	}

	public TransactionTransfer() {

	}

}
