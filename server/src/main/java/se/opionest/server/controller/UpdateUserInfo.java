package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.opionest.server.domain.DetailInfo2User;
import se.opionest.server.servers.impl.DaoServiceImpl;

@RestController
public class UpdateUserInfo {
    @Autowired
    DaoServiceImpl daoServiceImpl;

    @PostMapping("/updateUser")
    @ResponseBody
    void updateUser(@RequestBody DetailInfo2User detailInfo2User) {
        String name = detailInfo2User.getName();
        String location = detailInfo2User.getLocation();
        String brief = detailInfo2User.getBrief();
        String gender = detailInfo2User.getGender();
        String email = detailInfo2User.getEmail();
        Integer uid = detailInfo2User.getUid();
        daoServiceImpl.updateUserInfo(name, location, brief, gender, email, uid);
    }
}
