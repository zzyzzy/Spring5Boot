package zzyzzy.hello.boot.spring5boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zzyzzy.hello.boot.spring5boot.model.Checkme;
import zzyzzy.hello.boot.spring5boot.model.Member;
import zzyzzy.hello.boot.spring5boot.service.MemberService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/join")
public class JoinController {

    @Autowired MemberService msrv;

    Logger logger = LogManager.getLogger(JoinController.class);

    @GetMapping("/agree")
    public String agree() {
        logger.info("join/agree 호출!!");

        return "join/agree";
    }

    @GetMapping("/checkme")
    public String checkme() {
        logger.info("join/checkme 호출!!");

        return "join/checkme";
    }

    @PostMapping("/checkme")
    public String checkmeok(Checkme checkme, HttpSession sess) {
        logger.info("join/checkmeok 호출!!");
        // checkme에 보낸 개인정보를 세션에 저장하고
        // joinme로 이동
        String viewPage = "redirect:/join/checkme";

        if (checkme.getName() != null) {
            sess.setAttribute("checkme", checkme);
            viewPage = "redirect:/join/joinme";
        }

        return viewPage;
    }

    @GetMapping("/joinme")
    public String joinme() {
        logger.info("join/joinme 호출!!");

        return "join/joinme";
    }

    @PostMapping("/joinme")
    public String joinmeok(Member m) {
        logger.info("join/joinmeok 호출!!");
        String viewPage = "redirect:/join/fail";

        if (msrv.saveMember(m))
            viewPage = "redirect:/join/joinok";

        return viewPage;
    }


    @GetMapping("/joinok")
    public String joinok() {
        logger.info("join/joinok 호출!!");

        return "join/joinok";
    }


    // 우편번호 검색
    // /join/zipcode?dong=동이름
    // /join/zipcode/동이름
    // 검색결과는 뷰페이지 없이 바로 응답으로 출력 : RESTful 방식
    // 서블릿에서 제공하는 HttpServletResponse 객체를 이용하면
    // 스프링의 뷰리졸버 없이 바로 응답으로 출력할 수 있음
    // 단, 응답유형은 JSON 형식으로 함
    @GetMapping("/zipcode")
    @ResponseBody
    public void findzip(String dong, HttpServletResponse res) throws IOException {

        // 우편번호 조회결과를 JSON 형식으로 보냄
        // 따라서, 응답유형을 JSON형식으로 지정
        res.setContentType("application/json; charset=utf-8");
        // 검색된 결과를 뷰 없이 바로 응답response으로 출력
        res.getWriter().print( msrv.findzip(dong) );

    }


}
