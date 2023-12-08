package se.opionest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.opionest.server.domain.NewVote;
import se.opionest.server.domain.Options;
import se.opionest.server.servers.impl.DaoServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class AddVoteController {

    @Autowired
    DaoServiceImpl daoServiceImpl;

    @PostMapping("/addVote")
    @ResponseBody
    public void addVote(@RequestBody NewVote newVote){
        Integer uid = newVote.getUid();
        String title = newVote.getTitle();
        String content = newVote.getContent();
        String stime = newVote.getStime();
        String etime = newVote.getEtime();
        Instant instant1 = Instant.parse(stime);
        Instant instant2 = Instant.parse(etime);
        // 将 Instant 对象转换为 LocalDateTime 对象
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneId.of("UTC"));
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, ZoneId.of("UTC"));
        // 定义目标时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 使用格式化器格式化 LocalDateTime 对象
        String formattedTime1 = localDateTime1.format(formatter);
        String formattedTime2 = localDateTime2.format(formatter);
        System.out.println(formattedTime1 + '\n' + formattedTime2);
        ArrayList<Options> options = newVote.getOptions();
        daoServiceImpl.insertBrief(title, content, uid, formattedTime1, formattedTime2);
        //System.out.println(daoServiceImpl.getId("王者荣耀"));
        Integer current_id = daoServiceImpl.getId(title);
        for(Options op: options) {
            daoServiceImpl.insertVotes(op.getName(), current_id);
        }
        System.out.println(newVote);
    }
}
