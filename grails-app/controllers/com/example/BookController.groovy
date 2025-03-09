package com.example

import entities.Book

class BookController {
    static responseFormats = ['json' , 'xml']
    BookService bookService
    def index() { }

    def getBook(Long id){
        try {
            def book = bookService.getById(id)
            respond(book , Status: 200)
        }catch (Exception e){
            e.printStackTrace()
            respond(error: e.getMessage() , status: 404)
        }
    }

    def saveBook(Long authorId){
        def data =  request.getJSON()
        try {
            def book = bookService.saveBook(data.bookName, authorId, data.ISBN)
            respond(book)
        }catch (Exception e){
            e.printStackTrace()
            respond(error: e.getMessage() , status: 404)
        }
    }

    def updateBook(Long authorId , Long bookId){
        def bookData = request.getJSON()
        Book bookToUpdate =  new Book(bookName: bookData.bookName , ISBN: bookData.ISBN)
        println(bookToUpdate.toString())
        println(bookToUpdate.getBookName())

        try {
            def book = bookService.updateBook(bookToUpdate, authorId , bookId)
            respond(book , status: 200)
        }catch (Exception e){
            e.printStackTrace()
            respond(error: e.getMessage() , status: 404)
        }
    }

    def deleteBook(Long id){
        try {
            bookService.deleteBook(id)
            respond(message: "book of "+id + " has been deleted" , status: 200)
        }catch (Exception e)
        {
            e.printStackTrace()
            respond(error : e.getMessage()  , status: 404)
        }
    }

}
