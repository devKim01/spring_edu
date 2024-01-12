package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	
	@Test
	public void join(){ 
		//given
		Member member = new Member();
		member.setName("hell");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}
	
	@Test
	public void validateDupicateMember(){
		//given
		Member member1 = new Member();
		member1.setName("Spring");
		
		Member member2 = new Member();
		member2.setName("Spring");
		
		//when
		memberService.join(member1);
		
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		try {
//			memberService.join(member2);
//			fail();
//		}catch(IllegalStateException e) {
//			assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		}
		
		//then
//		Member findMember = memberService.findOne(saveId).get();
//		assertThat(member1.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void findOne(){
		
	}
}
