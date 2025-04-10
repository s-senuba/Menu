import java.util.*;

public class RestoranSiparisUygulamasi {

    private static Map<Integer, Yemek> menu = new HashMap<>();
    private static List<SiparisKalemi> siparis = new ArrayList<>();
    private static int yemekSayaci = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuOlustur();
        menuGoster();
        siparisAl();
        siparisOzetiGoster();
        scanner.close();
    }

    private static void menuOlustur() {
        menu.put(yemekSayaci++, new Yemek("Mercimek Çorbası", 15.00));
        menu.put(yemekSayaci++, new Yemek("Izgara Köfte", 35.50));
        menu.put(yemekSayaci++, new Yemek("Tavuk Sote", 30.00));
        menu.put(yemekSayaci++, new Yemek("Pilav", 12.00));
        menu.put(yemekSayaci++, new Yemek("Salata", 18.00));
        menu.put(yemekSayaci++, new Yemek("Ayran", 8.00));
    }

    private static void menuGoster() {
        System.out.println("\n*** RESTORAN MENÜSÜ ***");
        for (Map.Entry<Integer, Yemek> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println("*************************\n");
    }

    private static void siparisAl() {
        System.out.println("Sipariş vermek için menüden yemek numaralarını girin (örneğin: 1 2 1) veya '0' tuşlayarak siparişi tamamlayın.");
        int secim;
        while (true) {
            System.out.print("Seçiminiz: ");
            if (scanner.hasNextInt()) {
                secim = scanner.nextInt();
                if (secim == 0) {
                    break;
                } else if (menu.containsKey(secim)) {
                    Yemek secilenYemek = menu.get(secim);
                    System.out.print(secilenYemek.getAd() + " kaç porsiyon? ");
                    if (scanner.hasNextInt()) {
                        int adet = scanner.nextInt();
                        if (adet > 0) {
                            siparis.add(new SiparisKalemi(secilenYemek, adet));
                            System.out.println(secilenYemek.getAd() + " (" + adet + " adet) siparişinize eklendi.");
                        } else {
                            System.out.println("Geçersiz porsiyon sayısı.");
                        }
                    } else {
                        System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                        scanner.next(); // Geçersiz girdiyi temizle
                    }
                } else {
                    System.out.println("Geçersiz menü numarası.");
                }
            } else {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                scanner.next(); // Geçersiz girdiyi temizle
            }
        }
    }

    private static void siparisOzetiGoster() {
        System.out.println("\n*** SİPARİŞ ÖZETİ ***");
        double toplamTutar = 0;
        if (siparis.isEmpty()) {
            System.out.println("Henüz siparişiniz bulunmuyor.");
        } else {
            for (SiparisKalemi kalem : siparis) {
                System.out.println(kalem);
                toplamTutar += kalem.toplamFiyat();
            }
            System.out.println("----------------------");
            System.out.println("Toplam Tutar: TL " + String.format("%.2f", toplamTutar));
        }
        System.out.println("***********************\n");
        System.out.println("Afiyet olsun!");
    }
}
