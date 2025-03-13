CREATE DATABASE HRManagementInformationDB;
USE HRManagementInformationDB;

-- Roller Tablosu
CREATE TABLE roller (
    rol_id INT AUTO_INCREMENT PRIMARY KEY,
    rol_basligi VARCHAR(255) NOT NULL,
    rol_aciklamasi TEXT
);

-- Departmanlar Tablosu
CREATE TABLE departmanlar (
    departman_id INT AUTO_INCREMENT PRIMARY KEY,
    departman_adi VARCHAR(255) NOT NULL
);

-- Kullanıcılar Tablosu
CREATE TABLE kullanicilar (
    kullanici_id INT AUTO_INCREMENT PRIMARY KEY,
    ad VARCHAR(255) NOT NULL,
    soyad VARCHAR(255) NOT NULL,
    dogum_tarihi DATE,
    email VARCHAR(255) UNIQUE,
    telefon VARCHAR(20) UNIQUE,
    ise_baslama_tarihi DATE,
    rol_id INT,
    departman_id INT,
    parola VARCHAR(255),
    tc_no VARCHAR(11) UNIQUE,
    FOREIGN KEY (rol_id) REFERENCES roller(rol_id),
    FOREIGN KEY (departman_id) REFERENCES departmanlar(departman_id)
);

-- Maaşlar Tablosu
CREATE TABLE maaslar (
    maas_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    maas_tutari DECIMAL(10,2),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- Bordro Kayıtları Tablosu
CREATE TABLE bordro_kayitlari (
    bordro_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    bordro_tarihi DATE,
    temel_maas DECIMAL(10,2),
    ikramiye DECIMAL(10,2),
    kesintiler DECIMAL(10,2),
    net_maas DECIMAL(10,2),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- İşe Alım Tablosu
CREATE TABLE ise_alimlar (
    ise_alim_id INT AUTO_INCREMENT PRIMARY KEY,
    aday_adi VARCHAR(255),
    basvuru_tarihi DATE,
    pozisyon_id INT,
    durum VARCHAR(50),
    notlar TEXT
);

-- Mülakatlar Tablosu
CREATE TABLE mulakatlar (
    mulakat_id INT AUTO_INCREMENT PRIMARY KEY,
    ise_alim_id INT,
    kullanici_id INT,
    mulakat_tarihi DATE,
    geri_bildirim TEXT,
    FOREIGN KEY (ise_alim_id) REFERENCES ise_alimlar(ise_alim_id),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- İş Teklifleri Tablosu
CREATE TABLE is_teklifleri (
    teklif_id INT AUTO_INCREMENT PRIMARY KEY,
    ise_alim_id INT,
    teklif_tarihi DATE,
    teklif_durumu VARCHAR(50),
    teklif_maasi DECIMAL(10,2),
    geri_bildirim TEXT,
    FOREIGN KEY (ise_alim_id) REFERENCES ise_alimlar(ise_alim_id)
);

-- Çalışan Devam Durumu Tablosu
CREATE TABLE calisan_devam_durumu (
    devam_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    devam_tarihi DATE,
    giris_saati TIME,
    cikis_saati TIME,
    mesai_saatleri DECIMAL(5,2),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- Aylık Hedefler Tablosu
CREATE TABLE aylik_hedefler (
    hedef_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    yil INT,
    ay INT,
    hedef_aciklama VARCHAR(255),
    hedef_degeri DECIMAL(10,2),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- Terfiler Tablosu
CREATE TABLE terfiler (
    terfi_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    eski_pozisyon_id INT,
    yeni_pozisyon_id INT,
    terfi_tarihi DATE,
    maas_artis_orani DECIMAL(5,2),
    notlar TEXT,
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- Belgeler Türleri Tablosu
CREATE TABLE belge_turleri (
    belge_turu_id INT AUTO_INCREMENT PRIMARY KEY,
    belge_adi VARCHAR(255),
    aciklama TEXT
);

-- Çalışan Belgeleri Tablosu
CREATE TABLE calisan_belgeleri (
    belge_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    belge_turu_id INT,
    dosya_yolu VARCHAR(255),
    yukleme_tarihi DATE,
    gecerlilik_tarihi DATE,
    durum VARCHAR(50),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id),
    FOREIGN KEY (belge_turu_id) REFERENCES belge_turleri(belge_turu_id)
);

-- Sigorta Türleri Tablosu
CREATE TABLE sigorta_turleri (
    sigorta_turu_id INT AUTO_INCREMENT PRIMARY KEY,
    sigorta_turu_adi VARCHAR(255),
    aciklama TEXT
);

-- Sigorta Kayıtları Tablosu
CREATE TABLE sigorta_kayitlari (
    sigorta_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    sigorta_turu_id INT,
    baslangic_tarihi DATE,
    bitis_tarihi DATE,
    sigorta_numarasi VARCHAR(50) UNIQUE,
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id),
    FOREIGN KEY (sigorta_turu_id) REFERENCES sigorta_turleri(sigorta_turu_id)
);

-- Çıkış Kayıtları Tablosu
CREATE TABLE cikis_kayitlari (
    cikis_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    cikis_tarihi DATE,
    neden TEXT,
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id)
);

-- İzin Türleri Tablosu
CREATE TABLE izin_turleri (
    izin_turu_id INT AUTO_INCREMENT PRIMARY KEY,
    izin_turu_tipi VARCHAR(255),
    aciklama VARCHAR(255)
);

-- İzinler Tablosu
CREATE TABLE izinler (
    izin_id INT AUTO_INCREMENT PRIMARY KEY,
    kullanici_id INT,
    izin_turu_id INT,
    baslangic_tarihi DATE,
    bitis_tarihi DATE,
    toplam_gun DECIMAL(5,2),
    durum VARCHAR(50),
    FOREIGN KEY (kullanici_id) REFERENCES kullanicilar(kullanici_id),
    FOREIGN KEY (izin_turu_id) REFERENCES izin_turleri(izin_turu_id)
);
