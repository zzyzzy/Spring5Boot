package zzyzzy.hello.boot.spring5boot.pds;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PdsControllerUnitTest {
    @Autowired private MockMvc mvc;

    @Test
    @DisplayName("PdsController upload Test")
    void writeok() throws Exception {

        String fpath = "C:/Java/gendo.jpg";
        FileInputStream fis = new FileInputStream(fpath);

        // MockMultipartFile(폼이름,파일명,MIME,파일객체)
        MockMultipartFile attach = new MockMultipartFile(
            "attach", "gendo.jpg", "image/png", fis );

        mvc.perform(multipart("/pds/write").file(attach)
                        .param("title","aaa")
                        .param("userid","abc123")
                        .param("contents","bbb")
                        .param("ipaddr","127.0.0.1")
                ).andExpect(status().is3xxRedirection())
                .andDo(print());
    }


}







