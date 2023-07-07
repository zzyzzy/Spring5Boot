package zzyzzy.hello.boot.spring5boot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import zzyzzy.hello.boot.spring5boot.dao.MemberDAO;
import zzyzzy.hello.boot.spring5boot.dao.MemberDAOImpl;
import zzyzzy.hello.boot.spring5boot.model.Member;
import zzyzzy.hello.boot.spring5boot.service.MemberService;
import zzyzzy.hello.boot.spring5boot.service.MemberServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({MemberServiceImpl.class, MemberDAOImpl.class})
public class MemberServiceUnitTest {
    @Autowired private MemberService msrv;

    @Test
    @DisplayName("MemberService save Test")
    void saveMember() {
        Member m = new Member(null,"","","",
            "","","","","",null);

        boolean result = msrv.saveMember(m);
        System.out.println(result);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("MemberService read Test")
    void readMember() {
        List<Member> results = msrv.readMember();

        System.out.println(results);
        assertNotNull(results);
    }

}







