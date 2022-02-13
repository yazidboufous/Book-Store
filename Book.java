public class Book {
    protected String title;
    protected String author;
    protected int pages;
    protected String genre;
    protected int numberOfCopies;
    protected float price;



    public Book (String title,String author,int pages, String genre, int numberOfCopies, float price){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.pages=pages;
        this.numberOfCopies=numberOfCopies;
        this.price=price;
    }



    public String getTitle(){
        return title;
    }

    public void setTitle(String bookName){
        this.title=bookName;
    }

    public String getauthor(){
        return author;
    }

    public void setAuthor(String bookAuthor){
        this.author=bookAuthor;
    }

    public int getPages(){
        return pages;
    }

    public void setPages(int bookPages){
        this.pages=bookPages;
    }

    public  String getGenre(){
        return genre;
    }

    public void setGenre(String bookGenre){
        this.genre=bookGenre;
    }

    public int getNumberOCopies(){
        return numberOfCopies;
    }

    public void setNumberOfCopies(int bookNumberOfCopies){
        this.numberOfCopies=bookNumberOfCopies;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float bookPrice){
        this.price=bookPrice;
    }


    public String toString(){
        return "title:"+getTitle()+"\t"+"author:"+getauthor()+"\t pages:"
        +getPages()+"\t genre:"+getGenre()+"\t copies:"+getNumberOCopies()+"\t price:"+getPrice();
    }


    public boolean equals(Book newBook){
        if (title.equalsIgnoreCase(newBook.getTitle()) && author.equalsIgnoreCase(newBook.getauthor())
        && pages==newBook.getPages() && genre.equalsIgnoreCase(newBook.getGenre()) && numberOfCopies==newBook.getNumberOCopies()
        && price==newBook.getPrice()){
                return true;
        }else{
            return false;
        }

        

    }
    





    


}
