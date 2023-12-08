package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import se.opionest.server.domain.VotesInfo;
import se.opionest.server.servers.impl.DaoServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class VoteInfoController {

    @Autowired
    DaoServiceImpl daoServiceImpl;

    @GetMapping("/getVotes/{page}")
    @ResponseBody
    public ArrayList<VotesInfo> display(@PathVariable int page){
        int offSet = (page - 1) * 10;
        return daoServiceImpl.getVotesInfo(offSet);
    }

    @GetMapping("/rankByPv/{page}")
    @ResponseBody
    public ArrayList<VotesInfo> showInfo(@PathVariable int page){
        int offSet = (page - 1) * 10;
        return daoServiceImpl.getVotesInfoByPv(offSet);
    }

    @GetMapping("/allPages")
    @ResponseBody
    public HashMap<String, Integer> allPages() {
        HashMap<String, Integer> pages = new HashMap<>();
        Integer allVotes = daoServiceImpl.getAllVotes().getAllPages();
        Integer allPages = (int) Math.ceil(allVotes / 10.0);
        pages.put("allPages", allPages);
        return pages;
    }
}

