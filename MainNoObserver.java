import java.util.ArrayList;
import java.util.List;

// Subject (NewsAgency) yang memiliki daftar news readers
class NewsAgencyNoObserver {
    private List<String> newsReaders = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
    }

    // Setiap reader harus manual meminta berita terbaru
    public String getNews(String readerName) {
        return readerName + " is checking the news: " + news;
    }

    // Menambahkan reader ke daftar
    public void addNewsReader(String readerName) {
        newsReaders.add(readerName);
    }

    public List<String> getNewsReaders() {
        return newsReaders;
    }
}

// Main Program tanpa Observer Pattern
public class MainNoObserver {
    public static void main(String[] args) {
        NewsAgencyNoObserver agency = new NewsAgencyNoObserver();
        
        // Membuat beberapa readers
        agency.addNewsReader("Mutiara");
        agency.addNewsReader("Naura");

        // Mengupdate berita, tapi readers tidak otomatis diberi tahu
        agency.setNews("Breaking News: No Observer Pattern in Use!");

        // Setiap reader harus manual meminta berita
        for (String reader : agency.getNewsReaders()) {
            System.out.println(agency.getNews(reader));
        }
    }
}
