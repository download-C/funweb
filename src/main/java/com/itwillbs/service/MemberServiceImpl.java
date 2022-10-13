package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	//객체생성
//	MemberDAO dao=new MemberDAOImpl();
	@Inject
	private MemberDAO dao;

	@Override
	public void insertMember(MemberVO vo) {
		System.out.println("MemberServiceImpl insertMember()");
		dao.insertMember(vo);
	}

	@Override
	public MemberVO loginMember(MemberVO vo) {
		System.out.println("MemberServiceImpl loginMember(vo)");
		return dao.loginMember(vo);
	}

	@Override
	public MemberVO loginMember(String userid, String userpw) {
		System.out.println("MemberServiceImpl loginMember(userid, userpw)");
		return dao.loginMember(userid, userpw);
	}

	@Override
	public MemberVO getMember(String id) {
		//메서드 호출
		return dao.getMember(id);
	}

	@Override
	public Integer updateMember(MemberVO uvo) {
		//메서드 호출
		return dao.updateMember(uvo);
	}

	@Override
	public Integer deleteMember(MemberVO dvo) {
		return null;
	}

	@Override
	public List<MemberVO> getMemberList() {
		return dao.getMemberList();
	}

}
