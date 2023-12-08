package se.opionest.server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.opionest.server.domain.UserPwd;
import se.opionest.server.domain.VotesInfo;
import se.opionest.server.servers.impl.DaoServiceImpl;

import java.util.ArrayList;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    DaoServiceImpl daoServiceImpl;

}
