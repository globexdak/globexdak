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
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tstDak.vo.TestVo;
import com.tstDak.service.TestService;
 
@Controller //���������� �����ϴ� ��Ʈ�ѷ� ������ ���
public class TestController {
	private Logger logger = LogManager.getLogger(this.getClass());
	
    //MemberService �ν��Ͻ��� ���Խ�Ŵ
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
		
		return "com/tstDak/home";	// JSP ���
	}
	
    @RequestMapping("user/list.do") //url mapping
    public String memberList(Model model) {
        List<TestVo> list=testService.selectList_User();
        model.addAttribute("list", list);
        //WEB-INF/views/userList.jsp�� ������
        return "com/tstDak/userList";
    }

    //@RequestParam  : request.getParameter("������") ��ü    
    @RequestMapping("user/view.do")
    public String view(@RequestParam String userid, Model model) {
        //�𵨿� �ڷ� ����
        model.addAttribute("item", testService.selectOne_User(userid));
        // view.jsp�� ������
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
    
    //@ModelAttribute : ������ ���޵� ���� �����ϴ� ��ü    
    @RequestMapping("user/insert.do")
    public String insert(@ModelAttribute TestVo vo) {
        //System.out.println(vo);        
        int cnt = testService.insert_User(vo);
        return "redirect:/user/list.do";
    }
    
    @RequestMapping("user/update.do")
    public String update(@ModelAttribute TestVo vo, Model model) {
        //��й�ȣ üũ
        boolean result=testService.checkPassWd(vo.getId(), vo.getPasswd());
        if(result) { //��й�ȣ�� ������
            //ȸ������ ����
        	int cnt = testService.update_User(vo);
            //���� �� ������� �̵�
            return "redirect:/user/list.do"; //redirect
        }else { //��й�ȣ�� Ʋ����
            model.addAttribute("item", vo);
            model.addAttribute("message", "��й�ȣ�� Ȯ���ϼ���.");
            return "com/tstDak/modify"; //forward
        }
    }
    @RequestMapping("user/delete.do")
    public String delete(@RequestParam String userid, @RequestParam String passwd, Model model) {
    	boolean result=testService.checkPassWd(userid, passwd);
        if(result) { //����� ������ ���� => ������� �̵�
        	int cnt = testService.delete_User(userid);
            return "redirect:/user/list.do";
        }else { //����� Ʋ���� �ǵ��ư�
            model.addAttribute("message","��й�ȣ�� Ȯ���ϼ���.");
            model.addAttribute("item", testService.selectOne_User(userid));
            return "com/tstDak/view";
        }
    }
}
