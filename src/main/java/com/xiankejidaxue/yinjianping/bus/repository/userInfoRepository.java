package com.xiankejidaxue.yinjianping.bus.repository;

import com.xiankejidaxue.yinjianping.bus.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:yinjianping
 * @Description:
 * @Date:Created in 13:09 2019/4/22
 * @Modified By:
 */
@Repository
public interface userInfoRepository extends JpaRepository<UserInfo,Integer> {

    List<UserInfo> findByName(String name);

//    @Query(value = "select uid,username,password,salt,status,name from user_info where username = :name")
//    UserInfo findAStatus(@Param("name") String name);
}
