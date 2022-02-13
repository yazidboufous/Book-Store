public class Encyclopedia extends Book{

    protected int volume;

    //we set the constructor of the Encyclopedia class to have the author characteristic as "no_author"
    public Encyclopedia(String title, int pages, String genre, int numberOfCopies, float price,int volume) {
        super(title, "no_author", pages, genre, numberOfCopies, price);
        this.volume=volume;
    }


    public int getVolume(){
        return volume;
    }

    public void setVolume(int bookVolume){
        this.volume=bookVolume;
    }

    //we override the toString method:
    // we remove the getAuthor from the toString() so that it doesn't display the author:
    public String toString(){

        return "E:\ttite:"+getTitle()+"\t pages:"+getPages()+"\t genre:"+getGenre()
        +"\t copies:"+getNumberOCopies()+"\t price:"+getPrice()+"\t volume:"+getVolume();

    }


    //we override the equals method:
    public boolean equals(Encyclopedia newBook){
        if (title.equalsIgnoreCase(newBook.getTitle()) && author.equalsIgnoreCase(newBook.getauthor())
        && pages==newBook.getPages() && genre.equalsIgnoreCase(newBook.getGenre()) && numberOfCopies==newBook.getNumberOCopies()
        && price==newBook.getPrice() && volume==newBook.getVolume()){
                return true;
        }else{  
            return false;
        }
    }

        
    

    
}
