package com.tstDak.controller;

import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.util.Date;
import javax.inject.Inject;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tstDak.vo.TestVo;
import com.tstDak.service.TestService;
 
@Controller //스프링에서 관리하는 컨트롤러 빈으로 등록
public class TestController {
	private Logger logger = LogManager.getLogger(this.getClass());
	
    //MemberService 인스턴스를 주입시킴
    @Inject
    TestService testService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome to TestController! The client locale is {}."+ locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
	
		model.addAttribute("serverTime", date );
		return "com/tstDak/home";
	}
    
	@RequestMapping(value="/urlTest", method=RequestMethod.GET)
	public String urlTest() {
		
		return "com/tstDak/home";	// JSP 경로
	}
	
    @RequestMapping("user/list.do") //url mapping
    public String memberList(Model model) {
        List<TestVo> list=testService.selectList_User();
        model.addAttribute("list", list);
        //WEB-INF/views/userList.jsp로 포워딩
        return "com/tstDak/userList";
    }
    
    @RequestMapping("user/list2.do") //url mapping
    public ModelAndView memberList(ModelAndView mv) {
        List<TestVo> list=testService.selectList_User();
        // 데이터와 뷰를 동시에 설정이 가능
        mv.setViewName("com/tstDak/userList"); // 뷰의 이름
        mv.addObject("list", list); // 뷰로 보낼 데이터 값
        
        return mv;
    }

    //@RequestParam  : request.getParameter("변수명") 대체    
    @RequestMapping("user/view.do")
    public String view(@RequestParam String userid, Model model) {
        //모델에 자료 저장
        model.addAttribute("item", testService.selectOne_User(userid));
        // view.jsp로 포워딩
        return "com/tstDak/view";
    }
    
    @RequestMapping("user/register.do") //url mapping
    public String register() {
        return "com/tstDak/register";
    }
    
    @RequestMapping("user/modify.do") //url mapping
    public String modify(@RequestParam String userid, Model model) {
    	model.addAttribute("item", testService.selectOne_User(userid));
        return "com/tstDak/modify";
    }
    
    //@ModelAttribute : 폼에서 전달된 값을 저장하는 객체    
    @RequestMapping("user/insert.do")
    public String insert(@ModelAttribute TestVo vo) {
        //System.out.println(vo);        
        int cnt = testService.insert_User(vo);
        return "redirect:/user/list.do";
    }
    
    @RequestMapping("user/update.do")
    public String update(@ModelAttribute TestVo vo, Model model) {
        //비밀번호 체크
        boolean result=testService.checkPassWd(vo.getId(), vo.getPasswd());
        if(result) { //비밀번호가 맞으면
            //회원정보 수정
        	int cnt = testService.update_User(vo);
            //수정 후 목록으로 이동
            return "redirect:/user/list.do"; //redirect
        }else { //비밀번호가 틀리면
            model.addAttribute("item", vo);
            model.addAttribute("message", "비밀번호를 확인하세요.");
            return "com/tstDak/modify"; //forward
        }
    }
    @RequestMapping("user/delete.do")
    public String delete(@RequestParam String userid, @RequestParam String passwd, Model model) {
    	boolean result=testService.checkPassWd(userid, passwd);
        if(result) { //비번이 맞으면 삭제 => 목록으로 이동
        	int cnt = testService.delete_User(userid);
            return "redirect:/user/list.do";
        }else { //비번이 틀리면 되돌아감
            model.addAttribute("message","비밀번호를 확인하세요.");
            model.addAttribute("item", testService.selectOne_User(userid));
            return "com/tstDak/view";
        }
    }
}
