package zzyzzy.hello.boot.spring5boot.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import zzyzzy.hello.boot.spring5boot.model.Board;
import zzyzzy.hello.boot.spring5boot.service.BoardService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    final BoardService bsrv;

    Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("board/list 호출!!");

        m.addAttribute("bds", bsrv.readBoard(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", bsrv.countBoard());

        return "board/list";
    }

    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno) {
        logger.info("board/view 호출!!");

        m.addAttribute("bd", bsrv.readOneBoard(bno));

        return "board/view";
    }

    @GetMapping("/write")
    public String write() {
        logger.info("board/write 호출!!");

        return "board/write";
    }

    @PostMapping("/write")
    public String writeok(Board b) {
        logger.info("board/writeok 호출!!");
        String returnPage = "redirect:/board/fail";

        if (bsrv.saveBoard(b))
            returnPage = "redirect:/board/list/1";

        return returnPage;
    }

}
