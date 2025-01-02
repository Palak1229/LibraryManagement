package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.dto.ResponseStructure;
import com.library.management.entity.Member;
import com.library.management.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberservice ; 
	@PostMapping("/save")
    public ResponseEntity<ResponseStructure<Member>> saveMemberData(@RequestBody Member member) {
       return memberservice.saveMemberData(member);
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<List<Member>>> getAllMembers() {
    	return memberservice.getAllMembers();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Member>> getMemberById(@PathVariable int id) {
        return memberservice.getMemberById(id);
    }

   @PutMapping("/update/{id}")
   public ResponseEntity<ResponseStructure<Member>> updateMemberEntity(@RequestBody Member member , @PathVariable int id){
	   return memberservice.updateMember(member, id);
   }
   
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteMember(@PathVariable int id) {
       return memberservice.deleteMember(id);
}

}
