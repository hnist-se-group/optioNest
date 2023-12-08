package se.opionest.server.servers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import se.opionest.server.dao.DataDao;
import se.opionest.server.domain.*;
import se.opionest.server.servers.DaoService;

import java.util.ArrayList;

@Configuration
public class DaoServiceImpl implements DaoService {
    @Autowired
    DataDao dataDao;


    @Override
    public UserPwd getData(String username) {
        return dataDao.getPwdByUsername(username);
    }

    @Override
    public ArrayList<VotesInfo> getVotesInfo(int offSet) {
        return dataDao.getVotesInfo(offSet);
    }

    @Override
    public ArrayList<VotesInfo> getVotesInfoByPv(int offSet) {
        return dataDao.getVotesInfoByPv(offSet);
    }

    @Override
    public DetailInfo getDetailInfo(int id) {
        return dataDao.getDetailInfo(id);
    }

    @Override
    public ArrayList<Options> getInfo(int id) {
        return dataDao.getInfo(id);
    }

    @Override
    public DetailInfo2User getUserInfo(int uid) {
        return dataDao.getUserInfo(uid);
    }

    @Override
    public ArrayList<VotesInfo> userVotes(int uid) {
        return dataDao.userVotes(uid);
    }

    @Override
    public Integer voteState(int uid, int id) {
        return dataDao.voteState(uid, id);
    }

    @Override
    public void voting(int uid, int id, int oid) {
        dataDao.voting(uid, id, oid);
    }

    @Override
    public void voting_1(int id, int oid) {
        dataDao.voting2Table(id, oid);
    }

    @Override
    public void register(String username, String password) {
        dataDao.register(username, password);
    }

    @Override
    public boolean isExist(String username) {
        return dataDao.isExist(username) < 1;
    }

    @Override
    public void insertBrief(String title, String content, Integer uid, String stime, String etime) {
        dataDao.insertBrief(title, content, uid, stime, etime);
    }

    @Override
    public void insertVotes(String name, Integer id) {
        dataDao.insertVotes(name, id);
    }

    @Override
    public Integer getId(String title) {
       return dataDao.getId(title);
    }

    @Override
    public VotesInfo getAllVotes() {
        return dataDao.getAllVotes();
    }

    @Override
    public void addUser(String username, Integer uid) {
        dataDao.addUser(username, uid);
    }

    @Override
    public Integer getUid(String username) {
        return dataDao.getUid(username);
    }

    @Override
    public void updateUserInfo(String name, String location, String brief, String gender, String email, Integer uid) {
        dataDao.updateUserInfo(name, location, brief, gender, email, uid);
    }
}
