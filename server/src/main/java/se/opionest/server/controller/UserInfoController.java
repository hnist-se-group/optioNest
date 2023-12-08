package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.opionest.server.domain.DetailInfo2User;
import se.opionest.server.servers.impl.DaoServiceImpl;

@RestController
public class UserInfoController {

    @Autowired
    DaoServiceImpl daoServiceImpl;

    @GetMapping("/loadUser/{uid}")
    @ResponseBody
    DetailInfo2User display(@PathVariable  int uid){
        DetailInfo2User detailInfo2User = daoServiceImpl.getUserInfo(uid);
        detailInfo2User.setVotes(daoServiceImpl.userVotes(uid));
        return detailInfo2User;
    }
}
