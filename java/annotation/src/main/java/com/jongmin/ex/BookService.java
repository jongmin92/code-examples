package com.jongmin.ex;

public class BookService {

    @Inject
    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
