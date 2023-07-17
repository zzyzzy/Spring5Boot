package zzyzzy.hello.boot.spring5boot.pds;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import zzyzzy.hello.boot.spring5boot.dao.BoardDAO;
import zzyzzy.hello.boot.spring5boot.dao.BoardDAOImpl;
import zzyzzy.hello.boot.spring5boot.dao.PdsDAO;
import zzyzzy.hello.boot.spring5boot.dao.PdsDAOImpl;
import zzyzzy.hello.boot.spring5boot.model.Board;
import zzyzzy.hello.boot.spring5boot.model.Pds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PdsDAOImpl.class)
public class PdsDAOUnitTest {

    @Autowired private PdsDAO pdao;

    @Test
    @DisplayName("PdsDAO select Test")
    void selectPds() {
        int cpg = 1;
        int stnum = (cpg - 1) * 25;

        List<Pds> results = pdao.selectPds(stnum);
        assertNotNull(results);
    }

    @Test
    @DisplayName("PdsDAO selectOne Test")
    void selectOnePds() {
        String pno = "5";

        Pds result = pdao.selectOnePds(pno);
        assertNotNull(result);
    }

}








