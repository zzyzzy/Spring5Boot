package zzyzzy.hello.boot.spring5boot.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import zzyzzy.hello.boot.spring5boot.model.Board;
import zzyzzy.hello.boot.spring5boot.mybatis.BoardMapper;

import java.util.List;

@Repository("bdao")
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    // @Autowiried 없이 DI 구현
    final BoardMapper boardMapper;

    @Override
    public int insertBoard(Board b) {
        return 0;
    }

    @Override
    public List<Board> selectBoard(int stnum) {

        return boardMapper.selectBoard(stnum);
    }

    @Override
    public Board selectOneBoard(String bno) {

        return boardMapper.selectOneBoard(bno);
    }
}
