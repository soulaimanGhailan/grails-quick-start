package com.example

import entities.Author


class BootStrap {


    def init = { servletContext ->
        Author author = new Author() ;
        author.setName("soulaiman")
        author.save()
    }
    def destroy = {
    }
}
