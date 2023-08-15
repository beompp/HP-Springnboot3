package com.example.firstproject.repository;

import com.example.firstproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
public interface MemberRepository extends CrudRepository<Member, Long> {
=======
import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {
    @Override
    ArrayList<Member> findAll();
>>>>>>> home
}
