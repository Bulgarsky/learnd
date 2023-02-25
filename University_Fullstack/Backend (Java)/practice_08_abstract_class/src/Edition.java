public abstract class Edition {
    private String title;
    private String author;

    //constructor
    public Edition(String title, String author) {
        this.title = title;
        this.author = author;
    }
    //getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //methods
    public abstract void printInfo();


    //class extends
    //Book
    class Book extends Edition {
        private int year;
        private String publisher;

        //constructor @super
        Book(String title, String author, int year, String publisher) {
            super(title, author);
            this.year = year;
            this.publisher = publisher;
        }
        //methods
        @Override
        public void printInfo() {
            System.out.println("Название книги: "+getTitle()+", Автор :"+getAuthor()+", Год: "+year+", Издатель: "+publisher);
        }

        //Getters
        public int getYear() {
            return year;
        }
        public String getPublisher() {
            return publisher;
        }

        //Setters
        public void setYear(int year) {
            this.year = year;
        }
        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }
    }

    //Article
    class Article extends Edition {
        private String magazine;
        private int issue;
        private int year;
        //constructor @super
        Article(String title, String author, String magazine, int issue, int year) {
            super (title, author);
            this.magazine = magazine;
            this.issue = issue;
            this.year = year;
        }
        //methods
        @Override
        public void printInfo() {
            System.out.println("Журнал: "+magazine+" #"+issue+", статья: "+getTitle()+", Автор :"+getAuthor()+", Год: "+year);
        }

        //getters
        public String getMagazine() {
            return magazine;
        }
        public int getIssue() {
            return issue;
        }
        public int getYear() {
            return year;
        }

        //setters
        public void setMagazine(String magazine) {
            this.magazine = magazine;
        }
        public void setIssue(int issue) {
            this.issue = issue;
        }
        public void setYear(int year) {
            this.year = year;
        }
    }

    class Ebook extends Edition {
        String reference;
        String synopsis;
        //constructor @super
        Ebook(String title, String author, String reference, String synopsis){
            super (title, author);
            this.reference = reference;
            this.synopsis = synopsis;
        }
        //methods
        @Override
        public void printInfo() {
            System.out.println("Название: "+getTitle()+", Автор :"+getAuthor()+", Аннотация: "+synopsis+", Ссылка: "+reference);
        }
        //getters

        public String getReference() {
            return reference;
        }
        public String getSynopsis() {
            return synopsis;
        }
        //setters
        public void setReference(String reference) {
            this.reference = reference;
        }
        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }
    }
}
