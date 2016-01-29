package com.lihuanyu.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Transactional
public interface UserDao extends CrudRepository<User,Long>{
    public User findById(long id);
    public User findByMail(String mail);
}
