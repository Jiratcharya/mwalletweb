package com.mfu.service;

import java.util.List;

import com.mfu.entity.Member;

public interface MemberService {

		public void insert(Member emp);
		public Member findMember(long empId);
		public void update(Member  emp);
		public void delete(long empId);
		public List<Member> getAllMember();
		public List<Member> findMemberFirstname(String name);
		public List<Member> findMemberLastname(String lastname);
		public Member findUserandpassword(String email, String password);
		public Member findUser(String username);
		public Member findMemberById(long memberId);
		List<String> findMember(String username);
		
		
}
