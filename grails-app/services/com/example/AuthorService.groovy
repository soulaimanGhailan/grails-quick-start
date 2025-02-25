package com.example

import entities.Author
import exceptions.AuthorNotFound
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@Transactional
class AuthorService {
    def getAuthor(Long id){
        def author = Author.findById(id);
        if(!author) throw new AuthorNotFound("author not found of id :" + id)
        return author
    }

    def createAuthor(String name ){
        def author = new Author(name:  name) ;
        if(!author.validate())  throw new ValidationException("Invalid book data", author.errors)
        author.save(flush: true)
        return author
    }
    def serviceMethod() {

    }
}
