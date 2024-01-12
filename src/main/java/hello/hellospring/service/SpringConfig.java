package hello.hellospring.service;

import java.security.PublicKey;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.repository.PostgresqlMemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class SpringConfig {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	
//	@PersistenceContext
//	private EntityManager em;
//	
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		super();
//		this.em = em;
//	}
	
//	@Autowired DataSource dataSource;
//	
//	public SpringConfig(DataSource dataSource) {
//		super();
//		this.dataSource = dataSource;
//	}

	

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
//		return new MemberService(memberRepository());
	}
	

//	@Bean
//	public MemberRepository memberRepository() {
//		return new JpaMemberRepository(em);
//		return new JdbcTemplateMemberRepository(dataSource);
//		return new PostgresqlMemberRepository(dataSource);
//		return new MemoryMemberRepository();
//		
//	}
	
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
}
