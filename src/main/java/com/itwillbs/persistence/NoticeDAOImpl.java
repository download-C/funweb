package com.itwillbs.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.PageVO;

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
	public List<NoticeVO> getNoticeList(PageVO vo) {
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		noticeList = session.selectList(NAMESPACE+".getNoticeList", vo);
		return noticeList;
	}

	@Override
	public int getNoticeCount() {
		return session.selectOne(NAMESPACE+".getNoticeCount");
	}

	@Override
	public List<NoticeVO> getNoticeListSearch(PageVO vo) {
		return session.selectList(NAMESPACE+".getNoticeListSearch",vo);
	}

	@Override
	public int getNoticeCountSearch(PageVO vo) {
		return session.selectOne(NAMESPACE+".getNoticeCountSearch",vo);
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
