package entities

class Book {
    String bookName
    String ISBN
    static belongsTo = [author: Author]
    static constraints = {
        bookName nullable: false, blank: false
    }
}
