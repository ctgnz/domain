package com.example.demo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BookRepository;

@Controller
public class BookController {
    @Resource
    private BookRepository bookRepo;

    @RequestMapping("/books")
    public String listBooks(ModelMap model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }

}
