package se.opionest.server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Configuration;
import se.opionest.server.domain.*;

import java.util.ArrayList;

@Mapper
@Configuration
public interface DataDao{
    @Select("select uid from users_soft where username = #{username}")
    Integer getUid(@Param("username") String username);

    @Select("select id from voteinfo where title = #{title}")
    Integer getId(@Param("title") String title);

    @Select("select * from users_soft where username = #{username}")
    UserPwd getPwdByUsername(@Param("username") String username);

    @Select("select id, title, content from voteinfo limit 10 offset #{offSet}")
    ArrayList<VotesInfo> getVotesInfo(@Param("offSet") int offSet);

    @Select("select count(*) from users_soft where username = #{username}")
    Integer isExist(@Param("username") String username);

    @Select("select pv, id, title, content from voteinfo order by pv desc limit 10 offset #{offSet}")
    ArrayList<VotesInfo> getVotesInfoByPv(@Param("offSet") int offSet);

    @Select("select * from voteinfo where id = #{id}")
    DetailInfo getDetailInfo(@Param("id") int id);

    @Select("select * from voteoptions where id = #{id}")
    ArrayList<Options> getInfo(@Param("id") int id);

    @Select("select * from userinfo where uid = #{uid}")
    DetailInfo2User getUserInfo(@Param("uid")int uid);

    @Select("select * from voteinfo where owns = #{uid}")
    ArrayList<VotesInfo> userVotes(@Param("uid") int uid);

    @Select("select oid from vote_state where uid = #{uid} and id = #{id}")
    Integer voteState(@Param("uid") int uid, @Param("id") int id);

    @Update("INSERT INTO vote_state values(#{uid}, #{id}, #{oid})")
    void voting(@Param("uid") int uid, @Param("id") int id, @Param("oid") int oid);

    @Update("UPDATE voteoptions set num = num + 1 where oid = #{oid} and id = #{id}")
    void voting2Table(@Param("id") int id, @Param("oid") int oid);

    @Update("INSERT INTO users_soft(username, password) values(#{username}, #{password})")
    void register(@Param("username") String username,@Param("password") String password);

    @Update("INSERT INTO voteinfo (title, content, owns, stime, etime) values(#{title}, #{content}, #{uid}, #{stime}, #{etime})")
    void insertBrief(@Param("title") String title,@Param("content") String content,@Param("uid") Integer uid,
                     @Param("stime") String stime,@Param("etime") String etime);

    @Update("INSERT INTO voteoptions (name, id) values (#{name}, #{id})")
    void insertVotes(@Param("name") String name, @Param("id") Integer id);

    @Select("Select count(*) as allPages from voteinfo")
    VotesInfo getAllVotes();

    @Update("INSERT INTO userinfo (name, uid) values (#{username}, #{uid})")
    void addUser(@Param("username") String username, @Param("uid") Integer uid);

    @Update("UPDATE userinfo set name=#{name}, location=#{location}, " +
            "brief=#{brief}, gender=#{gender}, email=#{email} where uid=#{uid}")
    void updateUserInfo(@Param("name") String name, @Param("location") String location, @Param("brief") String brief,
                        @Param("gender") String gender, @Param("email") String email, @Param("uid") Integer uid);
}
