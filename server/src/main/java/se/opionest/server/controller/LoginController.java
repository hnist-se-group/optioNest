package se.opionest.server.controller;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import se.opionest.server.domain.DetailInfo2User;
import se.opionest.server.domain.LoginInfo;
import se.opionest.server.domain.UserPwd;
import se.opionest.server.servers.impl.DaoServiceImpl;

import java.util.Map;

@Configuration
@RestController
public class LoginController {
    @Autowired
    DaoServiceImpl daoServiceImpl;
    
    @PostMapping("/login")
    @ResponseBody
    public LoginInfo verify(String username, String password){
        LoginInfo loginInfo = new LoginInfo();
        UserPwd userPwd = daoServiceImpl.getData(username);
        if(!userPwd.getPassword().equals(password)){
            loginInfo.setUid(-1);
            loginInfo.setHeadImg(null);
            return loginInfo;
        }
        loginInfo.setUid(userPwd.getUid());
        DetailInfo2User detailInfo2User = daoServiceImpl.getUserInfo(userPwd.getUid());
        if(detailInfo2User.getImg() != null)
            loginInfo.setHeadImg(detailInfo2User.getImg());
        return loginInfo;
    }
}
