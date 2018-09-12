package com.mfu.servicebean;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.entity.Transac;
import com.mfu.service.TransacService;

	@Stateless
	@Remote(TransacService.class)
	public class TransacServiceBean implements TransacService{

		@PersistenceContext(unitName = "memberDatabase")
		EntityManager em;

		@Override
		public void insert(Transac transac) {
			// TODO Auto-generated method stub
			this.em.persist(transac);
		}

		@Override
		public Transac findTransacById(long transacId) {
			// TODO Auto-generated method stub
			return this.em.find(Transac.class, transacId);
		}

		@Override
		public void update(Transac transac) {
			// TODO Auto-generated method stub
			this.em.merge(transac);
		}

		@Override
		public void delete(long transacId) {
			// TODO Auto-generated method stub
			Transac ts = findTransacById(transacId);
			if (ts != null) {
				this.em.remove(ts);
			}
		}

		@Override
		public List<Transac> getAllTransac() {
			// TODO Auto-generated method stub
			return this.em.createQuery("SELECT x FROM Transac x").getResultList();
		}

		@Override
		public List<Transac> findTransac_detail(String transac_detail){
			// TODO Auto-generated method stub
			return this.em.createQuery("SELECT pm FROM Transac pm WHERE ts.transac_detail LIKE :fn")
					.setParameter("fn", transac_detail + "%").getResultList();
		}
		
		@Override
		public List<Transac> findTransac_date(String transac_date){
			// TODO Auto-generated method stub
			return this.em.createQuery("SELECT pm FROM Transac pm WHERE ts.transac_date LIKE :fn")
					.setParameter("fn", transac_date + "%").getResultList();
		}
		@Override
		public List<Transac> findPhoneByMember(long empId) {
			// TODO Auto-generated method stub
			return this.em.createQuery("SELECT ent FROM Phone ent WHERE ent.member.memberId =:param")
					.setParameter("param", empId).getResultList();
		}
}