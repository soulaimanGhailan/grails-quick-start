package com.example


class AuthorInterceptor {

    boolean before() {
        if('test'.equals(params.name)) {
            println("name equals tests")
            println("the action will not be executed")
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
