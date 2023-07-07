package zzyzzy.hello.boot.spring5boot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import zzyzzy.hello.boot.spring5boot.model.Member;

import java.util.List;

@Mapper
public interface MemberMapper {
    int insertMember(Member m);
    List<Member> selectMember();
}








