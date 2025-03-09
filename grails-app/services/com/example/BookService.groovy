package com.example

import entities.Author
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
        if(book == null) throw new RuntimeException("book not found of id : " + id)
        return book
    }

    def saveBook(String title, Long authorId , String isbn) {
        def author = Author.findById(authorId)
        if (!author) throw new AuthorNotFound("Author not found")

        def book = new Book(bookName: title, author: author , ISBN: isbn)
        if (!book.validate()) {
            throw new ValidationException("Invalid book data", book.errors)
        }
        return book.save(flush: true)

    }

    def updateBook(Book bookToUpdate , Long authorId , Long bookId) {
        def book = Book.get(bookId)
        if (!book) throw new IllegalArgumentException("Book not found")

        def author = Author.get(authorId)
        if (!author) throw new AuthorNotFound("Author not found")



        book.setBookName(bookToUpdate.getBookName())
        book.setAuthor(author)
        book.setISBN(bookToUpdate.getISBN())
        println(book)


        if (!book.validate()) {
            throw new ValidationException("Invalid book data", book.errors)
        }
        return book.save(flush: true)
    }

    def deleteBook(Long id) {
        def book = Book.get(id)
        if (!book) throw new IllegalArgumentException("Book not found")
        book.delete(flush: true)
    }
}