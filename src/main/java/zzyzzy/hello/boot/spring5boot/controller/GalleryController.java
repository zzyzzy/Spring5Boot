package zzyzzy.hello.boot.spring5boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    Logger logger = LogManager.getLogger(GalleryController.class);

    @GetMapping("/list")
    public String list() {
        logger.info("gallery/list 호출!!");

        return "gallery/list";
    }

}
