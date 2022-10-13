package com.itwillbs.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	// MyBatis 객체 주입
	@Inject
	private SqlSession session;
	
	// noticeMapper 가상 이름 정의	
	private static final String NAMESPACE 
		= "com.itwillbs.mapper.NoticeMapper"; 
	
	public Integer getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	@Override
	public void noticeWrite(NoticeVO vo) {
		session.insert(NAMESPACE+".insertNotice", vo);
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		session.selectList(NAMESPACE+".noticeList");
		return noticeList;
	}

//
//	@Override
//	public NoticeVO getNotice() {
//		return null;
//	}
//
//	@Override
//	public void updateNotice() {
//	}
//
//	@Override
//	public void deleteNotice() {
//	}

}
