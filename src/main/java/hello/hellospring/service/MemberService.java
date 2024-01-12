package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@Transactional
public class MemberService {
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/**
	 * 회원가입
	 */
	public Long join(Member member) {

//		AOP 적용전 시간측정
//		long start = System.currentTimeMillis();
//
//		try {
//			validateDuplicateMember(member); // 중복 회원 검증
//			memberRepository.save(member);
//			return member.getId();
//		} finally {
//			long finish = System.currentTimeMillis();
//			long timeMs = finish - start;
//			System.out.println("join " + timeMs + "ms");
//		}

		validateDuplicateMember(member); // 중복 회원 검사
		memberRepository.save(member);
		return member.getId();

	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	public List<Member> findMembers() {
//		AOP 적용전 시간측정
//		long start = System.currentTimeMillis();
//		try {
//			return memberRepository.findAll();
//		} finally {
//			long finish = System.currentTimeMillis();
//			long timeMs = finish - start;
//			System.out.println("findMembers " + timeMs + "ms");
//		}
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberRepository.findById(memberId);
	}
}
