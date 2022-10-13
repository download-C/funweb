package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.itwillbs.domain.NoticeVO;
import com.itwillbs.persistence.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Inject
	NoticeDAO dao;

	@Override
	public void noticeWrite(NoticeVO vo) {
		vo.setReadcount(0);
		vo.setRe_lev(0);
		vo.setRe_seq(0);
		
		if(dao.getMaxNum() == null) {
		//글이 하나도 없을 경우
			vo.setNotice_num(1);
			vo.setRe_ref(1);
		} else {
		// 글이 있을 경우 제일 큰 번호+1
			vo.setNotice_num(dao.getMaxNum()+1);
			vo.setRe_ref(dao.getMaxNum()+1);
		}
		dao.noticeWrite(vo);
	}

	@Override
	public void getNoticeList() {
		
		
	}
}
