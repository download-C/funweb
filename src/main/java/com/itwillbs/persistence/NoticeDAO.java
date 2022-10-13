package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.NoticeVO;

public interface NoticeDAO {
	public Integer getMaxNum();
	
	public void noticeWrite(NoticeVO vo);

	public List<NoticeVO> getNoticeList();
	
//	public List<NoticeVO> getNoticeList();
//	
//	public NoticeVO getNotice();
//	
//	public void updateNotice();
//	
//	public void deleteNotice();

}
