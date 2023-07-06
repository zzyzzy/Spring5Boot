package zzyzzy.hello.boot.spring5boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zzyzzy.hello.boot.spring5boot.model.Checkme;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/join")
public class JoinController {

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

    @GetMapping("/joinok")
    public String joinok() {
        logger.info("join/joinok 호출!!");

        return "join/joinok";
    }

}
