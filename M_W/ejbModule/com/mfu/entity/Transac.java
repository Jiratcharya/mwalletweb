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
public class Transac implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transacId;
	
	private String transac_detail;
	private int transac_price;
	private String transac_date;
	
	
	public long getTransacId() {
		return transacId;
	}
	public void setTransacId(long transacId) {
		this.transacId = transacId;
	}
	public String getTransac_detail() {
		return transac_detail;
	}
	public void setTransac_detail(String transac_detail) {
		this.transac_detail = transac_detail;
	}
	public int getTransac_price() {
		return transac_price;
	}
	public void setTransac_price(int transac_price) {
		this.transac_price = transac_price;
	}
	public String getTransac_date() {
		return transac_date;
	}
	public void setTransac_date(String transac_date) {
		this.transac_date = transac_date;
	}

}
