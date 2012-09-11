package edu.sun.app.action;

import edu.sun.app.dao.MemberDao;
import edu.sun.app.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private Member member;
    private List<Member> memberList;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @RequestMapping("index")
    public String index() {
        memberList = memberDao.getAllWorkingMember();
        return "/member/list";
    }

    @RequestMapping("queryWorkingMember")
    public String queryWorkingMember() {
        memberList = memberDao.getAllWorkingMember();
        return "/member/list";
    }

    @RequestMapping("queryAllMember")
    public String queryAllMember() {
        memberList = memberDao.getAllMember();
        return "/member/list";
    }

    @RequestMapping("save")
    public String saveMember() {
        if (member != null)
            memberDao.saveMember(member);
        memberList = memberDao.getAllWorkingMember();
        return "/member/list";
    }

    @RequestMapping("create")
    public String createNewMember() {
        member = new Member();
        logger.info("will create new member");
        return "/member/member";
    }
}
