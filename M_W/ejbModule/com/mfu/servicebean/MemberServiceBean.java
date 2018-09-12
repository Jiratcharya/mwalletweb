package com.mfu.servicebean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mfu.entity.Member;
import com.mfu.service.MemberService;

@Stateless
@Remote(MemberService.class)
public class MemberServiceBean implements MemberService {
	
	@PersistenceContext(unitName = "memberDatabase")
	EntityManager em;

	public void insert(Member emp) {
		this.em.persist(emp);
	}

	public Member findMember(long empId) {
		return this.em.find(Member.class, empId);
	}

	public void update(Member emp) {
		this.em.merge(emp);

	}

	public void delete(long empId) {
		Member emp = findMember(empId);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public List<Member> getAllMember() {
		return em.createQuery("SELECT em FROM Member em").getResultList();
	}
	
	@Override
	public Member findMemberById(long memberId) {
		// TODO Auto-generated method stub
		return this.em.find(Member.class, memberId);
	}

	public List<Member> findMemberFirstname(String name) {
		return em.createQuery("SELECT em FROM Member em WHERE em.firstName LIKE :fn ").setParameter("fn", name + "%")
				.getResultList();
	}

	@Override
	public List<Member> findMemberLastname(String lastname) {
		return em.createQuery("SELECT em FROM Member em WHERE em.lastName LIKE :ln ").setParameter("ln", lastname + "%")
				.getResultList();
	}
	
	@Override	
	public Member findUserandpassword(String username, String password) {
		// TODO Auto-generated method stub
		return (Member) this.em.createQuery("SELECT oo FROM Member oo WHERE oo.username =:em AND oo.password =:ps").setParameter("em", username).setParameter("ps", password).getSingleResult();
	}

	@Override
	public Member findUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> findMember(String username) {
		return em.createQuery("SELECT em FROM Member em WHERE em.lastName LIKE :ln ").setParameter("ln", username + "%")
				.getResultList();
	}
}
