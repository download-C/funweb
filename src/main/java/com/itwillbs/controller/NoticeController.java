package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.NoticeVO;
import com.itwillbs.domain.PageVO;
import com.itwillbs.service.NoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Inject
	NoticeService service;
	
	// http://localhost:8088/funweb/notice/write
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		System.out.println("NoticeController write()");
		return "center/write";
	}
	
	// http://localhost:8088/funweb/notice/writePro
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
		return "redirect:/notice/list";
	}
	
	// http://localhost:8088/funweb/notice/list
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		System.out.println("NoticeController noticeList()");
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		
		// 페이징 관련 사용자 지정 정보
		int pageSize = 15;
		int currentPage = Integer.parseInt(pageNum);
		
		// 페이징 관련 정보 삽입
		PageVO vo = new PageVO();
		vo.setPageNum(pageNum);
		vo.setPageSize(pageSize);
		vo.setCurrentPage(currentPage);
		
		List<NoticeVO> list = service.getNoticeList(vo);
		
		// 전체 글 개수
		int cnt = service.getNoticeCount();
		
		// 페이징 처리
		int pageCount =  cnt/pageSize + (cnt%pageSize == 0?  0:1 ) ;
		int pageBlock = 10;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		// 페이징 처리 정보 삽입
		vo.setPageCount(pageCount);
		vo.setPageBlock(pageBlock);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		
		// 페이징 처리 정보 및 게시판 정보 뷰로 넘기기
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		
		return "center/notice";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String listSearch(HttpServletRequest request, Model model) {
		System.out.println("NoticeController listSearch()");
		
		String pageNum = request.getParameter("pageNum");
		String search = request.getParameter("search");
		String search2 = "%"+search+"%"; // DB 검색용 search 만들기
		if(pageNum==null) pageNum="1";
		
		// 페이징 관련 사용자 지정 정보
		int pageSize = 15;
		int currentPage = Integer.parseInt(pageNum);
		
		// 페이징 관련 정보 삽입
		PageVO vo = new PageVO();
		vo.setPageNum(pageNum);
		vo.setPageSize(pageSize);
		vo.setCurrentPage(currentPage);
		// 검색어
		vo.setSearch(search2);
		
		// 검색한 글 목록
		List<NoticeVO> list = service.getNoticeListSearch(vo);
		// 검색한 글 개수
		int cnt = service.getNoticeCountSearch(vo);
		
		// 페이징 처리
		int pageCount =  cnt/pageSize + (cnt%pageSize == 0?  0:1 ) ;
		int pageBlock = 10;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		// 페이징 처리 정보 삽입
		vo.setPageCount(pageCount);
		vo.setPageBlock(pageBlock);
		vo.setStartPage(startPage);
		vo.setEndPage(endPage);
		// % 없는 검색어 삽입
		vo.setSearch(search);
		
		// 페이징 처리 정보 및 게시판 정보 뷰로 넘기기
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		
		return "center/noticeSearch";
	}
	
	// http://localhost:8088/funweb/notice/content
	@RequestMapping(value="/content", method = RequestMethod.GET)
	public String content(int notice_num) {
		System.out.println("NoticeController content()");
		
		return "/content?notice_num="+notice_num;
	}
	
}
