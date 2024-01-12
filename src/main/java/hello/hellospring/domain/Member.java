package hello.hellospring.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name = "username") db 컬럼 명, 컬럼명과 spring 변수명이 다를때 매핑
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
