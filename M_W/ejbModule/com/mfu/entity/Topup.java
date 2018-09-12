package com.mfu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Topup implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long topupId;
	private String topupdate;
	private int topuphistory;
	private int topupprice;
	
	public long getTopupId() {
		return topupId;
	}
	public void setTopupId(long topupId) {
		this.topupId = topupId;
	}

	public String getTopupdate() {
		return topupdate;
	}
	public void setTopupdate(String topupdate) {
		this.topupdate = topupdate;
	}

	public int getTopupprice() {
		return topupprice;
	}
	public void setTopupprice(int topupprice) {
		this.topupprice = topupprice;
	}
	public int getTopuphistory() {
		return topuphistory;
	}
	public void setTopuphistory(int topuphistory) {
		this.topuphistory = topuphistory;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Member memberId;
	private Member balance;


	public Member getMemberId() {
		return memberId;
	}
	public void setMemberId(Member memberId) {
		this.memberId = memberId;
	}
	
	public Member getBalance() {
		return balance;
	}
	public void setBalance(Member balance) {
		this.balance = balance;
	
}
}
