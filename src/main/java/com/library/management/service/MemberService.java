package com.library.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.management.dao.MemberDao;
import com.library.management.dto.ResponseStructure;
import com.library.management.entity.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberdao ;
	
	public ResponseEntity<ResponseStructure<Member>> saveMemberData( Member member) {
        Member saved = memberdao.saveMember(member);
        ResponseStructure<Member> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Member saved");
        structure.setData(saved);

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

	public ResponseEntity<ResponseStructure<List<Member>>> getAllMembers() {
        List<Member> members = memberdao.getAllMembers();
        ResponseStructure<List<Member>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Members fetched successfully");
        structure.setData(members);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
	

    public ResponseEntity<ResponseStructure<Member>> getMemberById( int id) {
        Member member = memberdao.getMemberById(id);
        ResponseStructure<Member> structure = new ResponseStructure<>();

        if (member != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Member found");
            structure.setData(member);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Member not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
	
    public ResponseEntity<ResponseStructure<Member>> updateMember( Member member,  int id) {
        Member updatedMember = memberdao.updateMember(member, id);
        ResponseStructure<Member> structure = new ResponseStructure<>();

        if (updatedMember != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Member updated successfully");
            structure.setData(updatedMember);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Member not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    
	 public ResponseEntity<ResponseStructure<String>> deleteMember( int id) {
	        try {
	            memberdao.deleteMember(id);
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.OK.value());
	            structure.setMessage("Member deleted successfully");
	            structure.setData("Deleted member with ID: " + id);
	            return new ResponseEntity<>(structure, HttpStatus.OK);
	        } catch (Exception e) {
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	            structure.setMessage("Member not found");
	            structure.setData(null);
	            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	        }
	    }
}
