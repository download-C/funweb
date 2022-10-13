package com.itwillbs.service;

import com.itwillbs.domain.NoticeVO;

public interface NoticeService {
	
	public void noticeWrite(NoticeVO vo);

	public void getNoticeList();
}
