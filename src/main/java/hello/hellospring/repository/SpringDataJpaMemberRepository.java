package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
//	SELECT m FROM MEMBER m WHERE m.NAME= ? 
	@Override
	Optional<Member> findByName(String name);
}
