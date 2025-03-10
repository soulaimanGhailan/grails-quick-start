package com.example

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class AuthorInterceptorSpec extends Specification implements InterceptorUnitTest<AuthorInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test author interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"author")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
