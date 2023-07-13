package zzyzzy.hello.boot.spring5boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zzyzzy.hello.boot.spring5boot.dao.BoardDAO;
import zzyzzy.hello.boot.spring5boot.model.Board;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardDAO bdao;

    @Override
    public boolean saveBoard(Board b) {
        boolean isSaved = false;

        if (bdao.insertBoard(b) > 0) isSaved = true;

        return isSaved;
    }

    @Override
    public List<Board> readBoard(Integer cpg) {
        int stnum = (cpg - 1) * 25;

        return bdao.selectBoard(stnum);
    }

    @Override
    public Board readOneBoard(String bno) {

        return bdao.selectOneBoard(bno);
    }

    @Override
    public int countBoard() {

        return bdao.selectCountBoard();
    }

}
