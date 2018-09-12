package com.mfu.servicebean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.entity.Topup;
import com.mfu.entity.Transac;
import com.mfu.service.TopupService;

	@Stateless
	@Remote(TopupService.class)
	public class TopupServiceBean implements TopupService{

		@PersistenceContext(unitName = "memberDatabase")
		EntityManager em;

		@Override
		public void insert(Topup topup) {
			// TODO Auto-generated method stub
			this.em.persist(topup);
		}

		@Override
		public Topup findTopupById(long topupId) {
			// TODO Auto-generated method stub
			return this.em.find(Topup.class, topupId);
		}

		@Override
		public void update(Topup topup) {
			// TODO Auto-generated method stub
			this.em.merge(topup);
		}

		@Override
		public void delete(long topupId) {
			// TODO Auto-generated method stub
			Topup ts = findTopupById(topupId);
			if (ts != null) {
				this.em.remove(ts);
			}
		}

		@Override
		public List<Topup> getAllTopup() {
			// TODO Auto-generated method stub
			return this.em.createQuery("SELECT x FROM Topup x").getResultList();
		}
		
		@Override
		public List<Topup> findPhoneByMember(long empId) {
			// TODO Auto-generated method stub
			return this.em.createQuery("SELECT ent FROM Phone ent WHERE ent.member.memberId =:param")
					.setParameter("param", empId).getResultList();
		}

}