package zzyzzy.hello.boot.spring5boot.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;
import zzyzzy.hello.boot.spring5boot.model.Board;
import zzyzzy.hello.boot.spring5boot.mybatis.BoardMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("boardMapper select Test")
    void selectBoard() {
        int cpg = 1;
        int stnum = (cpg - 1) * 25;

        List<Board> results = boardMapper.selectBoard(stnum);

        System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("boardMapper selectOne Test")
    void selectOneBoard() {
        String bno = "2961";

        Board result = boardMapper.selectOneBoard(bno);

        assertNotNull(result);
    }

    @Test
    @DisplayName("boardMapper insert Test")
    @Transactional
    void insertBoard() {
        Board b = new Board();
        b.setUserid("abc123"); b.setTitle("테스트");
        b.setContents("테스트"); b.setIpaddr("127.0.0.1");

        int result = boardMapper.insertBoard(b);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("boardMapper update Test")
    @Transactional
    void updateBoard() {
        String bno = "2961";

        int result = boardMapper.updateViewBoard(bno);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("boardMapper countPage Test")
    void countPage() {
        int result = boardMapper.selectCountBoard();

        assertNotNull(result);
    }

    @Test
    @DisplayName("boardMapper findBoard Test")
    void findBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "의료");
        params.put("stnum", 0);

        List<Board> results = boardMapper.selectFindBoard(params);

        assertNotNull(results);
    }

    @Test
    @DisplayName("boardMapper countfindBoard Test")
    void countfindBoard() {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "title");
        params.put("findkey", "이강인");

        int result = boardMapper.countFindBoard(params);

        assertNotNull(result);
    }


}







