package zzyzzy.hello.boot.spring5boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzyzzy.hello.boot.spring5boot.dao.MemberDAO;
import zzyzzy.hello.boot.spring5boot.model.Member;

import java.util.List;

@Service("msrv")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO mdao;

    @Override
    public boolean saveMember(Member m) {
        boolean isSaved = false;

        if (mdao.insertMember(m) > 0) isSaved = true;

        return isSaved;
    }

    @Override
    public List<Member> readMember() {

        return mdao.selectMember();
    }
}
