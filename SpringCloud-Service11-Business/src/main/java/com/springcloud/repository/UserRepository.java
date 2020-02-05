package com.springcloud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.entitys.User;

/****************************************************************************************
 * 建立Repository 並且使用Spring Data JPA<br>
 * 
 * 1. @Repository: 註冊JPA ;<br>
 * 2. 實作JpaRepository 接口 key一個 Repository對應一個entity，另一個參數為該entity的pk<br>
 * 
 * @author Miles
 ******************************************************************************************/
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findById(Integer id);
// spring data jpa 使用2.0以上 所以不支援類似以下的寫法，必須使用Optional為類型 處理可能Null的情況
//	public User findById(Integer id);

}
