package zzyzzy.hello.boot.spring5boot.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zzyzzy.hello.boot.spring5boot.model.Member;

import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    // mybatis를 사용하기 위해 필요한 객체 DI
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertMember(Member m) {

        // insert(insert관련맵핑, 매개변수)
        return sqlSession.insert("member.insertMember", m);
    }

    @Override
    public List<Member> selectMember() {
        return null;
    }
}
