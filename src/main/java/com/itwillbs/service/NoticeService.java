package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.PageVO;

public interface NoticeService {
	
	public void noticeWrite(NoticeVO vo);

	public List<NoticeVO> getNoticeList(PageVO vo);

	public int getNoticeCount();

	public List<NoticeVO> getNoticeListSearch(PageVO vo);

	public int getNoticeCountSearch(PageVO vo);
}
