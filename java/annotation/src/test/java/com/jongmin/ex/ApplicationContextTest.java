package com.jongmin.ex;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void testGetInstance() throws Exception {
        final BookRepository bookRepository = ApplicationContext.get(BookRepository.class);
        assertThat(bookRepository, notNullValue());
    }

    @Test
    public void testGetSingletonInstance() throws Exception {
        final BookRepository bookRepository = ApplicationContext.get(BookRepository.class);
        assertThat(bookRepository, notNullValue());

        final BookRepository bookRepository2 = ApplicationContext.get(BookRepository.class);
        assertThat(bookRepository2, notNullValue());

        assertThat(bookRepository, is(bookRepository2));
    }

    @Test
    public void testGetDependencyInjectionInstance() throws Exception {
        final BookService bookService = ApplicationContext.get(BookService.class);
        assertThat(bookService, notNullValue());
        assertThat(bookService.getBookRepository(), notNullValue());

        final BookRepository bookRepository = ApplicationContext.get(BookRepository.class);
        assertThat(bookRepository, notNullValue());
        assertThat(bookRepository, is(bookService.getBookRepository()));
    }
}
