package edu.sun.app.action;

import edu.sun.app.dao.MemberDao;
import edu.sun.app.entity.Member;
import edu.sun.app.utils.DateUtils2;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("updateMember")
    public String updateMember(@RequestParam("memberId") String id, Model model) {
        if (StringUtils.isEmpty(id)) {
            return queryWorkingMember(model);
        }

        Member member = memberDao.loadMemberById(id);
        model.addAttribute("member", member);
        return "/member/updateMember";
    }

    @RequestMapping("save")
    public String saveMember(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");

        String name = request.getParameter("name");
        String workLong = request.getParameter("workLong");
        String enterDate = request.getParameter("enterDate");
        String memberId = request.getParameter("memberId");

        Member member = new Member();

        if (!StringUtils.isEmpty(id)) {
            member.setId(Integer.parseInt(id));
        }

        member.setMemberId(memberId);
        member.setName(name);
        member.setWorkLong(Integer.parseInt(workLong));
        member.setEnterDate(DateUtils2.parseDate(enterDate));

        memberDao.saveMember(member);

        List<Member> memberList = memberDao.getAllWorkingMember();

        model.addAttribute("memberList", memberList);
        return "redirect:/member/index.do";
    }

    @RequestMapping("create")
    public String createNewMember() {
        return "/member/member";
    }
}
