package com.example.jpatestproject.jpaSample.repository;

import com.example.jpatestproject.jpaSample.entity.Guestbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>, QuerydslPredicateExecutor {
}
