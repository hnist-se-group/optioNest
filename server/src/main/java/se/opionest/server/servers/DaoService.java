package se.opionest.server.servers;

import se.opionest.server.domain.*;

import java.util.ArrayList;

public interface DaoService {
    public UserPwd getData(String username);
    public ArrayList<VotesInfo> getVotesInfo(int offSet);
    public ArrayList<VotesInfo> getVotesInfoByPv(int offSet);
    DetailInfo getDetailInfo(int id);
    public ArrayList<Options> getInfo(int id);
    DetailInfo2User getUserInfo(int uid);
    ArrayList<VotesInfo> userVotes(int uid);
    Integer voteState(int uid, int id);
    void voting(int uid, int id, int oid);
    void voting_1(int id, int oid);
    void register(String username, String password);
    boolean isExist(String username);
    void insertBrief(String title, String content, Integer uid, String stime, String etime);
    void insertVotes(String name, Integer id);
    Integer getId(String title);
    VotesInfo getAllVotes();
    void addUser(String username, Integer uid);
    Integer getUid(String username);
    void updateUserInfo(String name, String location, String brief, String gender, String email, Integer uid);
}
