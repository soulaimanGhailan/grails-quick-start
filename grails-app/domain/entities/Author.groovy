package entities

class Author {
    String name
    static hasMany = [books: Book]
    static constraints = {
        name nullable: false, blank: false
    }
}
