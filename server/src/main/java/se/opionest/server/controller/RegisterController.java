package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.opionest.server.dao.DataDao;
import se.opionest.server.servers.impl.DaoServiceImpl;

@RestController
public class RegisterController {

    @Autowired
    DaoServiceImpl daoServiceImpl;

    @Autowired
    DataDao dataDao;

    @PostMapping("/register")
    @ResponseBody
    public boolean register(String username, String password) {
        if(!daoServiceImpl.isExist(username)){
            return false;
        } else {
            daoServiceImpl.register(username, password);
            Integer uid = daoServiceImpl.getUid(username);
            daoServiceImpl.addUser(username, uid);
            return true;
        }
    }
}
