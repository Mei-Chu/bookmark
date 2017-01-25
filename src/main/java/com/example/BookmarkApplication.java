package com.example;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.example.entities.Account;
import com.example.entities.Bookmark;
import com.example.repository.AccountRepository;
import com.example.repository.BookmarkRepository;

@SpringBootApplication
public class BookmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
			BookmarkRepository bookmarkRepository){
		return (evt) -> Arrays.asList("jhoeller,dsyer,pwebb,ogieke,rwinch,mfisher,mpollack,jlong".split(","))
						.forEach(
								a -> {
									Account account = accountRepository.save(new Account(a,"password"));
									bookmarkRepository.save(new Bookmark(account,
											"http://bookmark.com/1/" + a, "A description"));
									bookmarkRepository.save(new Bookmark(account,
											"http://bookmark.com/2/" + a, "A description"));
									
								});
	}
}
