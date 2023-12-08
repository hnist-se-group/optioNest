package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.opionest.server.domain.DetailInfo;
import se.opionest.server.domain.Options;
import se.opionest.server.servers.impl.DaoServiceImpl;

import java.util.ArrayList;

@RestController
public class DetailInfoController {

    @Autowired
    DaoServiceImpl daoServiceImpl;

    @GetMapping("/getDetailInfo")
    @ResponseBody
    DetailInfo getDetail(int uid, int id){
            DetailInfo detailInfo = daoServiceImpl.getDetailInfo(id);
            ArrayList<Options> sss = daoServiceImpl.getInfo(id);
            detailInfo.setOptions(sss);
            int num = 0;
            for(Options s : sss) {
                num += s.getNum();
            }
            detailInfo.setNum(num);
            detailInfo.setState(isVoted(uid, id));
           return detailInfo;
    }

    public int isVoted(int uid, int id){
        Integer allVoted = daoServiceImpl.voteState(uid, id);
        if(allVoted == null) {
           return -1;
        }
        return allVoted;
    }
}
