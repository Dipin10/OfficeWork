package com.dipinprojectmatra.repository;

import com.dipinprojectmatra.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {




    }

