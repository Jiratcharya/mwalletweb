package com.mfu.service;

import java.util.List;

import com.mfu.entity.*;

public interface TopupService {

		public void insert(Topup tp);
		public Topup findTopupById(long topupId);
		public void update(Topup  tp);
		public void delete(long tpId);
		public List<Topup> getAllTopup();
		public List<Topup> findPhoneByMember(long empId);
		

}