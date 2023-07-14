package zzyzzy.hello.boot.spring5boot.dao;

import zzyzzy.hello.boot.spring5boot.model.Pds;
import zzyzzy.hello.boot.spring5boot.model.PdsAttach;

public interface PdsDAO {

    int insertPds(Pds p);

    int insertPdsAttach(PdsAttach pa);

}
