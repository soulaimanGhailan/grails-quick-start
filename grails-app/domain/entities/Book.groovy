package entities

class Book {
    String bookName
    String ISBN
    static belongsTo = [author: Author]
    static constraints = {
        bookName nullable: false, blank: false
    }

    @Override
    String toString() {
        return "bookName :" + this.bookName + " , isbn : " + this.ISBN +", id :" + this.id
    }
}
