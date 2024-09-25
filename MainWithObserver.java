import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update(String message);
}

// Interface Subject
interface Subject {
    void attach(Observer observer);   // Tambah observer
    void detach(Observer observer);   // Hapus observer
    void notifyObservers();           // Notifikasi ke observer
}

// Concrete Subject yang menyimpan state dan memberi tahu observer jika ada perubahan
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();  // Saat ada berita baru, beri tahu observers
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);  // Kirim berita ke semua observers
        }
    }
}

// Concrete Observer yang menerima notifikasi dari Subject
class NewsReader implements Observer {
    private String name;

    public NewsReader(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

// Penggunaan Observer Pattern
public class MainWithObserver {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        // Membuat beberapa observer (news readers)
        NewsReader reader1 = new NewsReader("Mutiara");
        NewsReader reader2 = new NewsReader("Naura");

        // Mendaftarkan observers ke subject
        agency.attach(reader1);
        agency.attach(reader2);

        // Update berita yang akan otomatis memberi tahu observers
        agency.setNews("Breaking News: Observer Pattern is Active!");
    }
}
