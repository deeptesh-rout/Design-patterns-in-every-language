interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Concrete Subject Request Method");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject(); // Lazy Initialization
        }
        realSubject.request();
    }
}

public class ProxyLazy {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
/* 
Concrete Subject Request Method
*/