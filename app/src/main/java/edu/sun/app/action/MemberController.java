package edu.sun.app.action;

import edu.sun.app.dao.MemberInfoDao;
import edu.sun.app.model.MemberInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("memberController")
public class MemberController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private MemberInfo memberInfo = new MemberInfo();
    private List<MemberInfo> memberInfos;

    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(MemberInfo memberInfo) {
        this.memberInfo = memberInfo;
    }

    public MemberInfoDao getMemberInfoDao() {
        return memberInfoDao;
    }

    public void setMemberInfoDao(MemberInfoDao memberInfoDao) {
        this.memberInfoDao = memberInfoDao;
    }

    public List<MemberInfo> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(List<MemberInfo> memberInfos) {
        this.memberInfos = memberInfos;
    }

    @Autowired
    private MemberInfoDao memberInfoDao;


    public void test() {
    }

    public void saveMember() {

    }
}
