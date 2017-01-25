package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import com.example.entities.*;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long>{
	Collection<Bookmark> findByAccountUsername(String username);
}
