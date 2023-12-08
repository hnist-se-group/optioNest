package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.opionest.server.servers.impl.DaoServiceImpl;

@RestController
public class VotingController {

    @Autowired
    DaoServiceImpl daoServiceImpl;

    @GetMapping("/voting")
    @ResponseBody
    public void voting(int uid, int id, int oid) {
        daoServiceImpl.voting(uid, id, oid);
        daoServiceImpl.voting_1(id, oid);
    }
}
