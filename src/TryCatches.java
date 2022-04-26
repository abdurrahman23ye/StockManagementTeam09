import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatches {

    /* Karşılaşılabilecek problemler sebebiyle Try-Catches ayrı bir classa alındı.
     * Daha sonra eklenebilecek yeni durumlar için dinamik olmayan sorunları try catch e eklenmedi.
     * Sorunların parent-child ilişkisine dikkat edildi.
     * Çözümler genel yönlendirmelere değil, spesifik yönlendirmelerebağlandı.
     * Try-catch ile scannerın birlikte kullanımında sık sık ortaya çıkan dummy problemi için özel çözüm methoda eklendi.(satır 23 ve 24)
     //*** (Ekleme Mehmet Mağden Bey'in katkılarıyla: Scanner kullanırken bir hata durumunda Try bloğundaki alınan değer exeption gerektiriyorsa
     ve bu durum handle edilmişse Java Scan satırından catch satırına atlıyor.( alttaki örnekte 30'dan 38 ve sonrasına geçiş yapması gibi..) Bu durum da
     dummy problemine yol açıyor ve bir dummy obje ile çözülebiliyor ama bizim create ettiğimiz exceptionlarda ise( Mesela uygunsuz bir yerde negatif değer
     girme-> new IllegalArgument vs. (Örnek: satır 38-40)) girilen arguman bir exeption olmadığı için biz throw ile exeption üretene kadar bu durum
     yaşanmıyor. Catch sonrası çoğu zaman yeniden giriş isteyeceğimiz için scan sonra değil önce ortaya çıkan bir Dummy sorunu yaşanıyor.

     Çözümü aşağıda bulunmaktadır.

     */




    static Scanner scan = new Scanner(System.in);


    public static int tryCatchesInt() {
        int giris = 0;
        boolean flag1=false;

        do {

            try {
                if (flag1==true){scan.nextLine();        //Dummy1(39 ve 40. satırlar için)
                    flag1=false;}

                giris = scan.nextInt();

                if (giris < 0) {
                    throw new IllegalArgumentException();
                }
                scan.nextLine();        //Dummy1

            } catch (IllegalArgumentException e) {
                flag1=true;
                System.out.println("lütfen pozitif bir sayi giriniz");
            } catch (InputMismatchException e) {
                flag1=true;
                System.out.println("lütfen bir rakam giriniz");
            } catch (Exception e) {
                flag1=true;
                System.out.println("lütfen geçerli bir giriş yapınız");
            }


        } while (flag1);


        return giris;

    }

    public static int tryCatchesMiktar() {
        int giris = 0;
        boolean flag1=false;

        do {

            try {
                if (flag1==true){scan.nextLine();        //Dummy1(39 ve 40. satırlar için)
                    flag1=false;}

                giris = scan.nextInt();

                if (giris < 0) {
                    throw new IllegalArgumentException();

                } else if(giris > Urunler.urunListesiMap.get(DepoIslemler.urunID).getMiktar()){ throw  new IllegalAccessException();}
                scan.nextLine();        //Dummy1



            } catch (IllegalArgumentException e) {
                flag1=true;
                System.out.println("lütfen pozitif bir sayi giriniz");
            } catch (InputMismatchException e) {
                flag1=true;
                System.out.println("lütfen bir rakam giriniz");
            } catch (IllegalAccessException e) { flag1=true;
                System.out.println("depoda yeterli miktarda ürün yok");

            } catch (Exception e){flag1=true;
                System.out.println("lütfen geçerli bir giriş yapınız");}


        } while (flag1);


        return giris;

    }
}