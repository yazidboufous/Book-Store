import java.util.Scanner;

public class Bookstore {

    // we create an array of type Book that has a length of 10.
    private static Book[] bookArray=new Book[10];
    private static int counter;

    /* we create a method called ensureLength where we are going to link the length of our array
    to a counter, everytine we add a book , the counter is incremented, and when we delete it it is decremented*/

    public static void ensureLength(){
        if (bookArray.length==counter);
        
        /*if our array is full, we create a temporary array of a bigger size
        we transfer all of the elements of our primary array to it
        and after that we copy everything again to our primary array*/

        Book[] bookArray2=new Book[bookArray.length+10];
        for (int i=0; i<bookArray.length;i++){
            bookArray2[i]=bookArray[i];
        }
        bookArray=bookArray2;
    }



	
    public static void addBook(){

        //we are asking for user input for the title and the author of the book

        Scanner input= new Scanner(System.in);
        System.out.print("Enter the title:");
        String bookTitle=input.next();
        System.out.print("Enter the author:");
        String bookAuthor=input.next();
        
        
        //if the title and the author of the book is already found, we increase the number of copiesby 1.
        int check=0;
        for (int i=0;i<counter;i++){
            if (bookArray[i].getTitle().equalsIgnoreCase(bookTitle) && bookArray[i].getauthor().equalsIgnoreCase(bookAuthor)){
                int temp=bookArray[i].getNumberOCopies();
                temp++;
                bookArray[i].setNumberOfCopies(temp);
                check=1;
                break;
            } 
        }

        /* if it's not we ask for the rest of the information , we create an object of class Book
        and add it to the array and increment the counter by 1*/

        if (check==0){
            ensureLength();
            System.out.print("Enter the pages:");
            int bookPages=input.nextInt();
            System.out.print("Enter the genre:");
            String bookGenre=input.next();
            System.out.print("Enter the number of copies:");
            int bookNumberOfCopies= input.nextInt();
            System.out.print("Enter the price :");
            int bookPrice= input.nextInt();
            Book userbook= new Book(bookTitle, bookAuthor, bookPages, bookGenre, bookNumberOfCopies, bookPrice);
            bookArray[counter]=userbook;
            counter++;
    
        }
        
    }


    public static void addEncyclopedia(){

        //we are asking for user input for the title the book

        Scanner input= new Scanner(System.in);
        System.out.print("Enter the title:");
        String bookTitle=input.next();

        //if the title of the Encyclopedia is already found, we increase the number of copies by 1

        boolean check=false;
        for (int i=0;i<counter;i++){
            if(bookArray[i].getTitle().equalsIgnoreCase(bookTitle) && bookArray[i].getauthor().equalsIgnoreCase("no_author")){
                int temp=bookArray[i].getNumberOCopies();
                temp++;
                bookArray[i].setNumberOfCopies(temp);
                check=true;
                break;
            }
        }

        /* else we ask for the rest of the info without asking for the author,create an object of class
        Encyclopedia and then add it to the array and increment the counter by 1*/

        if (check==false){
            ensureLength();

            System.out.print("Enter the pages:");
            int bookPages=input.nextInt();
            System.out.print("Enter the genre:");
            String bookGenre=input.next();
            System.out.print("Enter the number of copies:");
            int bookNumberOfCopies= input.nextInt();
            System.out.print("Enter the price :");
            int bookPrice= input.nextInt();
            System.out.print("Enter the volume :");
            int bookVolume= input.nextInt();
            Book userbook= new Encyclopedia(bookTitle,bookPages, bookGenre, bookNumberOfCopies, bookPrice,bookVolume);
            bookArray[counter]=userbook;
            counter++;

        }


    }



    /*we create a method that's going to go through the array and return the index of the book 
    if the title and author is already found, if not found it returns -1 */

    public static int searchBook(){
        Scanner scan= new Scanner(System.in);
	    System.out.print("Enter the title:");
        String name=scan.next();
        System.out.print("Enter the author:");
        String author=scan.next();

        for (int i=0;i<counter;i++){
            if (bookArray[i].getTitle().equalsIgnoreCase(name) && bookArray[i].getauthor().equalsIgnoreCase(author)){
                return i;
            }
        }
        return -1;
        
    }


    /*same thing for Encyclopedia, but we only ask for name -1 */

    public static int searchEncyclopedia(){
        Scanner scan= new Scanner(System.in);
	    System.out.print("Enter the title:");
        String name=scan.next();

        boolean check=true;
        for (int i=0;i<counter;i++){
            if (bookArray[i].getTitle().equalsIgnoreCase(name)&& bookArray[i].getauthor().equalsIgnoreCase("no_author")){
                check=false;
                return i;
            }
        } 

        return -1;
        
    }   






    public static void deleteBook(){

        //we invoke the searchBook method 

        int j=searchBook();

        //if it returns -1 then the book is not found, and it displays a message.
        if (j==-1){
            System.out.println("The book is not found");

        }
        //  else, it will return the index and we will remove the element at that index.
        else{
            bookArray[j]=null;
            for (int k=0;k<counter;k++){
                if (bookArray[k]==null){             //we set the book in the specified index to null.
                    for (int h=k ;h<counter ;h++){   
                        Book temp = bookArray[h];  //and we shift the null element to the end of the array
                        bookArray[h]=bookArray[h+1];
                        bookArray[h+1]=temp;
                    }
                    counter--;     // and we decrement the counter by 1.
                }
            
            }

        }
        
    }

    

    //same thing for Encyclopedias
    public static void deleteEncyclopedia(){

        int j=searchEncyclopedia();

        if (j==-1){
            System.out.println("The Encyclopedia is not found");
                
        }else{
            bookArray[j]=null;
            for (int k=0;k<counter;k++){ 
                if (bookArray[k]==null){
                    for (int h=k ;h<counter ;h++){
                        Book temp = bookArray[h];
                        bookArray[h]=bookArray[h+1];
                        bookArray[h+1]=temp;
                    }
                    counter--;
                    
                }
            
            }
        }
    }



    public static void sellBook(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter 0 for book and 1 for Encyclopedia: ");
        int choice= scan.nextInt();


        System.out.print("Enter the title:");
        String name = scan.next();


        if (choice==0){

            //if the user enters 0 we ask for the author:
            System.out.print("Enter the author:");
            String author= scan.next();

            // we loop through the array and check if a book with the same name and author exixts.
            boolean check=false;
            for (int i=0; i<counter;i++){
                if (bookArray[i].getTitle().equalsIgnoreCase(name) 
                && bookArray[i].getauthor().equalsIgnoreCase(author)){

                    //if the book is found we decrease the number of copies by 1.
                    check=true;
                    int temp= bookArray[i].getNumberOCopies();
                    temp--;

                    //if the numberofcopies is not 0, then we set the new value of number of copes.
                    if (temp!=0){
                    bookArray[i].setNumberOfCopies(temp);

                    }else{ 
                    /*if it reaches 0 we delete the book / I didn't invoke here the delete method because 
                    it will ask for user input again , so I just implemented the actual code. */
                        bookArray[i]=null;
                        for (int h=i ;h<counter ;h++){
                            Book temp2 = bookArray[h];
                            bookArray[h]=bookArray[h+1];
                            bookArray[h+1]=temp2;
                        }
                        counter--;
                        
                    }   
                }
            }
            //if it's not found we display a message.
            if (check==false){
                System.out.println("This book is not found");
            }

        }
        else
        {
            //same process for Encyclopedia 
            boolean check=false;
            for (int i=0; i<counter;i++){
                if (bookArray[i].getTitle().equalsIgnoreCase(name) 
                && bookArray[i].getauthor().equalsIgnoreCase("no_author")){
                    check=true;
                    int temp= bookArray[i].getNumberOCopies();
                    temp--;
                    if (temp!=0){
                    bookArray[i].setNumberOfCopies(temp);
                    }else{
                        bookArray[i]=null;
                        for (int h=i ;h<counter ;h++){
                            Book temp2 = bookArray[h];
                            bookArray[h]=bookArray[h+1];
                            bookArray[h+1]=temp2;
                        }
                        counter--;
                    }
                }
            }

            //if the Encyclopedia is not found we display a message
            if (check==false){
                System.out.println("This Encyclopedia is not found");
            }
        }

    }


    //we create a method that goes through the elements of the array and display the information usting the toString() method
    public static void listAll(){
        for (int i=0;i<counter;i++){
             System.out.println(bookArray[i].toString());
        }
    }


    public static void main (String[] args){
    
        int count=0;

        //we set a count that's going to get incremented each time the user enterns an invalid input.
        while(count<5){

            System.out.println("1.Add book\n2.Delete book\n3.Sell book\n4.List all\n5.Exit");
            System.out.println("----------------------");

            //we ask for user input to choose:
            Scanner input = new Scanner (System.in);
            System.out.print("Enter your choice:");
            int choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter 0 for book and 1 Encyclopedia");
                    int choice2 = input.nextInt();

                    //if the user enters 0 we invoke the addBook method , else we invoke the addEncyclopedia
                    if (choice2==0){
                        addBook();
                    }else{
                        addEncyclopedia();
                    }       
                break;

                case 2:
                    System.out.println("Enter 0 for book and 1 Encyclopedia");
                    int choice3 = input.nextInt();
                    
                    //if the user enters 0 we invoke the deleteBook method , else we invoke the deleteEncyclopedia
                    if (choice3==0){
                        deleteBook();
                    }else{
                        deleteEncyclopedia();
                    }
                break;
                
                case 3:
                    sellBook();
                break;

                case 4:
                    listAll();
                break;

                case 5:
                //if the user enters 5 we exit the program.
                    System.exit(0);
                break;
 
                default:
                    /* if the user enters an invalid option we display a message, and then ask
                    for input again, if the number of invalid inputs reaches 5, we exit the program*/

                    count++;
                    if (count!=5){
                        System.out.println("Invalid, enter again");
                    }else{
                        System.exit(0);
                    }
                break;
                
                
            }

        }

    }
}

