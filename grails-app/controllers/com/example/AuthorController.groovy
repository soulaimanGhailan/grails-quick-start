package com.example

import entities.Author
import groovy.util.logging.Slf4j


@Slf4j
class AuthorController {
    static responseFormats = ['json' , 'xml']
    AuthorService authorService
    def getAuthor(Long id) {
        try {
            def author = authorService.getAuthor(id)
            respond(author , status: 200)
        } catch (Exception e) {
            log.error(e.getMessage())
            respond(error: e.getMessage(), status: 404)
        }
    }
    def createAuthor(String name){
       try {
           def author = authorService.createAuthor(name)
           respond(author , status: 200)
       }catch (Exception e){
           log.error(e.getMessage())
           respond(error: e.getMessage() , status: 404)
       }
    }






}
