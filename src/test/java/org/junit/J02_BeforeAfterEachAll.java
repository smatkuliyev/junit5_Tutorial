package org.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class J02_BeforeAfterEachAll {
/* =========================================== @BeforeEach - @AfterEach ============================================

 A-) @BeforeEach anatosyonu kullanılan bir method, her test methodu çalışmadan önce çalıştırılır.
     Bu özelliği sayesinde test verilerinin ayarlanması (başlatılması) için kullanılabilir.
     Araç --> her vites'te debriyaja basma   Namaz --> her rekatın Fatiha'sı

 B-) @AfterEach anatosyonu kullanılan bir method, her test metodu bittikten sonra çalıştırılır.
     Bu özelliği sayesinde test verilerinin temizlenmesi için kullanılabilir.
     Araç --> her vites'te debriyajdan ayagı cekme   Namaz --> her rekatın ayaga kalkma'sı

 C-) JUnit4 de bu anatosyonlar yerine @Before ve @After kullanıyordu.

 D-) AHAN DA TRİCKKK:  @AfterEach veya  @BeforeEach anotasyonunda yazım sırası önemli değildir. Hangisi önce önce yazılırsa yazılsın JAVA
      önce @BeforeEach  sonra @AfterEach compile eder.

      ========================================== @BeforeAll - @AfterAll ===============================================
A-) @BeforeALl tüm test methodlarından önce BİR KERE çalışan bir method oluşturmak için kullanılır.
       Dolayısıyla veritabanı içeren bir test işleminde ilk olarak veritabanına bağlanmak gerekeceğinden @BeforeAll
       anatosyonu ile bir method tanımlanarak ilk olarak veritabanına bağlanma prosedürü işletilebilir.
        Araç --> kontagı acma   Namaz --> Namazın tekbiri...


B-) @AfterAll ile tüm test metotlari bittikten sonra BİR KERE çalışan bir metot oluşturulabilir.
       Bu özelliği sayesinde testler bittikten sonra veritabani oturumu kapatılabilir.
       Araç --> kontagı kapatma   Namaz --> Namazın selamı...


   AHAN DA TRİCKKK: @BeforeAll ve @AfterAll anotasyonlarının kullanıldığı metotlar static olmalıdır.
   Not2: JUnit4 de @BeforeClass ve  @AfterClass metotları kulanılmaktadır.

   Kıng of TRICKK : @Before ve @After anotasyonları ayrı bir test gibi tek başına  çalışmaz test2lerin çalışma
                   hiyerraşisini organize eder. Anotasyonlarının yazım sırası run sırasını etkilemez anotasyonlar kendi hiyerarşisine göre run olur

   */


    @AfterEach
    void clean(TestInfo info) {
        str = "";
        System.out.println(info.getDisplayName() + " @AfterEach --> clean method'u run edildi");
        System.out.println(" ******** ");
    }

    @BeforeEach
    void setup(TestInfo info) {
        str = "JavaCAN'lara selam olsum";
        System.out.println(info.getDisplayName() + " @BeforeEach --> setup method'u run edildi");
        System.out.println(" ******** ");
    }

    String str = "";

    @AfterAll
    static void veritabaniBaglantiKapatma(){
        System.out.println("@AfterAll --> veritabani baglantisi kapatildi");
    }

    @BeforeAll
    static void veritabaniBaglantiAcma(){
        System.out.println("@BeforeAll --> veritabani baglantisi kuruldu");
    }

    @Test
    @DisplayName("Length method test")
    void testStringLength() {
        int olusan = str.length();
        int beklenen = 24;

        assertEquals(beklenen, olusan, "data'lar farkli");
        System.out.println("test1 - length method u calisti");
    }

    @Test
    @DisplayName("arrays test")
    void testArray() {
        String str = "javacanlara selam olsun ayaginiza das degmesin";
        String olusan[] = str.split(" ");

        String beklenen[] = {"javacanlara", "selam", "olsun", "ayaginiza", "das", "degmesin"};

        assertArrayEquals(beklenen, olusan, "agam array'ler farkli");

        System.out.println("test2 - array method u calisti");

    }
}
