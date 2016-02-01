package com.lihuanyu.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by skyADMIN on 16/1/27.
 */
@Transactional
public interface CustomUserDao extends CrudRepository<CustomUser,Long>{
    public CustomUser findById(long id);
    public CustomUser findByMail(String mail);
    public CustomUser findByName(String name);
}
