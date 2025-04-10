class SiparisKalemi {
    Yemek yemek;
    int adet;

    public SiparisKalemi(Yemek yemek, int adet) {
        this.yemek = yemek;
        this.adet = adet;
    }

    public double toplamFiyat() {
        return yemek.getFiyat() * adet;
    }

    @Override
    public String toString() {
        return adet + " x " + yemek.getAd() + " = TL " + String.format("%.2f", toplamFiyat());
    }
}
