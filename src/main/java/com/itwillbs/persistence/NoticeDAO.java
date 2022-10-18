package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.PageVO;

public interface NoticeDAO {
	public Integer getMaxNum();
	
	public void noticeWrite(NoticeVO vo);

	public List<NoticeVO> getNoticeList(PageVO vo);

	public int getNoticeCount();

	public List<NoticeVO> getNoticeListSearch(PageVO vo);

	public int getNoticeCountSearch(PageVO vo);
	
//	public List<NoticeVO> getNoticeList();
//	
//	public NoticeVO getNotice();
//	
//	public void updateNotice();
//	
//	public void deleteNotice();

}
