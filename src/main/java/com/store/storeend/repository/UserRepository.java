package com.store.storeend.repository;

import com.store.storeend.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<SysUser,Integer> {
    List<SysUser> findByUserName(String userName);
    List<SysUser> findByPhone(String phone);
    List<SysUser> findByEmail(String email);
}
