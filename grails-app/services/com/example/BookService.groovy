package com.example

import entities.Book
import exceptions.AuthorNotFound
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@Transactional
class BookService {

    def listAll() {
        return Book.list()
    }

    def getById(Long id) {
        Book book = Book.findById(id) ;
        if(book != null) throw new RuntimeException("book not found of id : " + id)
        return book
    }

    def saveBook(String title, Long authorId , String isbn) {
        def author = Author.get(authorId)
        if (!author) throw new AuthorNotFound("Author not found")

        def book = new Book(bookName: title, author: author , ISBN: isbn)
        if (!book.validate()) {
            throw new ValidationException("Invalid book data", book.errors)
        }
        book.save(flush: true)
        return book
    }

    def updateBook(Long id, String title, Long authorId) {
        def book = Book.get(id)
        if (!book) throw new IllegalArgumentException("Book not found")

        def author = Author.get(authorId)
        if (!author) throw new AuthorNotFound("Author not found")

        book.title = title
        book.author = author

        if (!book.validate()) {
            throw new ValidationException("Invalid book data", book.errors)
        }
        book.save(flush: true)
        return book
    }

    def deleteBook(Long id) {
        def book = Book.get(id)
        if (!book) throw new IllegalArgumentException("Book not found")
        book.delete(flush: true)
    }
}