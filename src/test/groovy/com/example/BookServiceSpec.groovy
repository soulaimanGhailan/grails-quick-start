package com.example

import entities.Author
import entities.Book
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import groovy.mock.interceptor.MockFor
import org.mockito.Mock
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

 // Tells Grails this is a unit test for BookService

class BookServiceSpec extends Specification implements ServiceUnitTest<BookService> ,  DomainUnitTest<Book>  {






    @Rollback(false) // Ensure test data persists
    def setup() {
        new Book(id: 1L, bookName: "Found Book", ISBN: "0000" , author: new Author(name: "okay")).save(flush: true, failOnError: true)
    }

    void "test GetById"() {
        when:
        def book = service.getById(1L)

        then:
        book != null
        book.bookName == "Found Book"
    }

    //    def "ListAll"() {
//    }


//    def "SaveBook"() {
//    }
//
//    def "UpdateBook"() {
//    }
//
//    def "DeleteBook"() {
//    }
}
