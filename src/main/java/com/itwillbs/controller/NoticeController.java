package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.NoticeVO;
import com.itwillbs.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Inject
	NoticeService service;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		System.out.println("NoticeController write()");
		return "center/write";
	}
	
	@RequestMapping(value="/writePro", method=RequestMethod.POST)
	public String writePro(NoticeVO vo) {
		System.out.println("NoticeController writePro()");
		System.out.println("글쓴이: "+vo.getName());
		System.out.println("제목: "+vo.getSubject());
		
		// 글 DB에 저장
			// MySQL DB 테이블 생성
			// NoticeVO
			// noticeMapper.xml
			// NoticeDAO, NoticeDAOImpl
			// NoticeService, NoticeServiceImpl
		service.noticeWrite(vo);
		
		// 주소 변경하면서 글 목록(notice.jsp)으로 이동
		return "redirect:/notice/noticeList";
	}
	
	@RequestMapping(value="/noticeList", method=RequestMethod.GET)
	public String noticeList(Model model) {
		System.out.println("NoticeController noticeList()");
//		List<NoticeVO> noticeList = service.getNoticeList();
//		model.addAttribute("noticeList", noticeList);
		return "center/notice";
	}
	
	@RequestMapping(value="/content", method = RequestMethod.GET)
	public String content(int notice_num) {
		System.out.println("NoticeController content()");
		
		return "/content?notice_num="+notice_num;
	}
	
}
