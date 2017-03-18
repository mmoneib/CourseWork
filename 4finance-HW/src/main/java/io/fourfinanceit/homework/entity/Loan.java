package io.fourfinanceit.homework.entity;

import static javax.persistence.GenerationType.AUTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LOAN")
public class Loan {
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "amount")
	private int amount;

	@Column(name = "term")
	private int term;

	@Column(name = "request_addr")
	private String requesterAddr;

	public Loan(String firstName, String lastName, String amount, String term,
			String requesterAddr) {
		setDate(new Date());
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAmount(Integer.valueOf(amount));
		this.setTerm(Integer.valueOf(term));
		this.setRequesterAddr(requesterAddr);
	}

	public Loan() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public String getRequesterAddr() {
		return requesterAddr;
	}

	public void setRequesterAddr(String requesterAddr) {
		this.requesterAddr = requesterAddr;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}