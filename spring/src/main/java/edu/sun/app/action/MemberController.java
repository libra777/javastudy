package edu.sun.app.action;

import edu.sun.app.dao.MemberDao;
import edu.sun.app.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-11
 */
@Controller
@RequestMapping("/member/*")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberDao memberDao;


    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @RequestMapping("index")
    public String index(Model model) {
        List<Member> memberList = memberDao.getAllWorkingMember();
        model.addAttribute("memberList", memberList);
        return "/member/list";
    }

    @RequestMapping("queryWorkingMember")
    public String queryWorkingMember(Model model) {
        List<Member> memberList = memberDao.getAllWorkingMember();
        model.addAttribute("memberList", memberList);
        return "/member/list";
    }

    @RequestMapping("queryAllMember")
    public String queryAllMember(Model model) {
        List<Member> memberList = memberDao.getAllMember();
        model.addAttribute("memberList", memberList);
        return "/member/list";
    }

    @RequestMapping("save")
    public String saveMember(Model model, Member member) {
        if (member != null)
            memberDao.saveMember(member);
        List<Member> memberList = memberDao.getAllWorkingMember();
        model.addAttribute("memberList", memberList);
        return "redirect:/member/index.do";
    }

    @RequestMapping("create")
    public String createNewMember(Model model) {
        return "/member/member";
    }
}
