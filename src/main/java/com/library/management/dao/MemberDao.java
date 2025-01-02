package com.library.management.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Member;
import com.library.management.repository.MemberRepo;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepo memberrepo;

	public Member saveMember(Member member) {
		return memberrepo.save(member);
	}
	public List<Member> getAllMembers(){
		return memberrepo.findAll();
	}
	
	public Member getMemberById(int id) {
		Optional<Member> member=memberrepo.findById(id);
			if(member.isPresent()) {
			Member presentMember=member.get();
			return presentMember;
		}
		else {
			return null;
		}	
	}
	
	public Member updateMember(Member member ,int id) {
		Optional<Member>Member=memberrepo.findById(id);
		if(Member.isPresent()) {
			Member updatedMember=Member.get();
			updatedMember.setName(member.getName());
			updatedMember.setPhnno(member.getPhnno());
			updatedMember.setEmail(member.getEmail());
			memberrepo.save(updatedMember);
			return updatedMember;
		}
		else return null;
	}

	public void deleteMember(int id) {
		memberrepo.deleteById(id);
	}

}
