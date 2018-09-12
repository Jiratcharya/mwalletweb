package com.mfu.service;

import java.util.List;

import com.mfu.entity.Transac;

public interface TransacService {

		public void insert(Transac tansac);
		public Transac findTransacById(long TransacId);
		public void update(Transac  tan);
		public void delete(long tanId);
		public List<Transac> getAllTransac();
		public List<Transac> findTransac_detail(String transac_detail);
		public List<Transac> findTransac_date(String transac_date);
		public List<Transac> findPhoneByMember(long empId);
}