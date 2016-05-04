package com.lihuanyu.dao;

import com.lihuanyu.model.CustomUser;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Transactional
public interface CustomUserDao extends CrudRepository<CustomUser,Long>{
    public CustomUser findById(long id);
    public CustomUser findByMail(String mail);
    public CustomUser findByNickname(String nickname);
    public Iterable<CustomUser> findAll(Sort orders);
}
