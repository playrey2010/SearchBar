package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MessageRepository extends CrudRepository <Message, Long>{
    // This is a demo of some queries allowed by CrudRepository
    // in Message findby... it will look inside of Message objects in the Repo, specifically the title field, and search a String (title) inside. It does so once
    // because you specificed just 1 Message. That is why we use Iterable.
//    Iterable<Message> findByTitle(String title);
//    Message findByTitle(String title);
    ArrayList<Message> findByTitle(String title);
}
