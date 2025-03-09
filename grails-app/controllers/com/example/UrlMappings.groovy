package com.example

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        get "/authors/$id"(controller: "author" , action: "getAuthor")
        post "/authors/$name"(controller: "author" , action: "createAuthor")

        get "/books/$id"(controller: "book" , action: "getBook")
        post "/books/$authorId"(controller: "book" , action: "saveBook")
        put "/books/$authorId/$bookId"(controller: "book" , action: "updateBook")
        delete "/books/$id"(controller: "book" , action: "deleteBook")
    }
}
