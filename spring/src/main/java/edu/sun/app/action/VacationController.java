package edu.sun.app.action;

import edu.sun.app.dao.MemberDao;
import edu.sun.app.dao.VacationDao;
import edu.sun.app.entity.Member;
import edu.sun.app.entity.Vacation;
import edu.sun.app.utils.DateUtils2;
import edu.sun.app.utils.VacationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * User: sunqipeng
 * Date: 12-9-13
 */
@Controller
public class VacationController {
    @Autowired
    VacationDao vacationDao;

    @Autowired
    MemberDao memberDao;

    @RequestMapping("list")
    public String list(@RequestParam("memberId") String id, Model model) {

        int currentYear = DateUtils2.getCurrentYear();
        List<Vacation> vacations = vacationDao.listVacationsByMemberId(id, currentYear);

        int sumVacation = 0;
        for (Vacation vacation : vacations) {
            sumVacation += vacation.getDays();
        }
        Member member = memberDao.loadMemberById(id);

        int leftVacation = VacationUtils.calculateMemberVacation(member, sumVacation);

        int originalVacation = VacationUtils.originalMemberVacation(member);

        model.addAttribute("leftVacation", leftVacation);
        model.addAttribute("originalVacation", originalVacation);
        model.addAttribute("member", member);
        model.addAttribute("vacations", vacations);
        model.addAttribute("sumRequiredVacations", sumVacation);
        return "/vacation/list";
    }
}
