package zzyzzy.hello.boot.spring5boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zzyzzy.hello.boot.spring5boot.model.Pds;
import zzyzzy.hello.boot.spring5boot.mybatis.PdsMapper;

@Repository("pdao")
public class PdsDAOImpl implements PdsDAO {

    @Autowired
    private PdsMapper pdsMapper;

    @Override
    public int insertPds(Pds p) {
        int cnt = pdsMapper.insertPds(p);

        if (cnt > 0)
            cnt = pdsMapper.lastPdsPno();

        return cnt;
    }

}
