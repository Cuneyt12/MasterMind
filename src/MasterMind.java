import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    public static void main(String[] args) {
        int sifreUret[] = new int[5];
        int sifre[] = new int[5];
        int tahmin[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        sifre = sifreUret(sifreUret);
        int tahminler = 0;
        String dizi[] = new String[5];
        boolean yeter = true;
        int istek = 0;
        String goster;


        System.out.println("Master Mind oyununa hoş geldiniz!");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("5 adet tahmin hakkınız bulunmaktadır.");

       do {
           for (int i = 1; i <= 5; i++){
               System.out.print(i + ". tahmininiz: ");
               tahminler = scanner.nextInt();
               tahmin[i - 1] = tahminler;
           }

           for (int i =1; i <= 5; i++){
               if (i == 1){
                   System.out.print("\t\t\t\t\tTahmininiz\t\t: ");
                   for (int j = 0; j < tahmin.length; j++){
                       System.out.print(tahmin[j] + "  ");
                   }
                   System.out.print("\n\t\t\t\t\tGizli Kod\t\t:");
               }
           }

           for (int k = 0; k < sifre.length; k++){
               for (int l = 0; l < sifre.length; l++){
                   if (tahmin[k] == sifre[k]){
                       dizi[k] = "[" + sifre[k] + "]";
                       break;
                   }
                   else if (tahmin[k] == sifre[l]){
                       dizi[k] = "[+]";
                       break;
                   }
                   else if (l == 4){
                       dizi[k] = "[ ]";
                       break;
                   }
               }
           }
           for (String s: dizi)
               System.out.print(s);

           int count = 0;

           for (int a = 0; a < sifre.length; a++){
               for (int b = 0; b < sifre.length; b++){
                   if (tahmin[a] == sifre[b])
                       count++;
               }
           }

           if (count == tahmin.length){
               System.out.print("\nTebrikler doğru tahmin!!!!");
               yeter = false;
           }

           System.out.println("\nŞifre:");
           for (int ss: sifre)
               System.out.print(ss + " ");
           if (yeter){
               System.out.println("\nOyuna devam etmek için 1'e, oyundan çıkmak için 2'ye basınız:");
               istek = scanner.nextInt();
           }
           if (istek == 2)
               yeter = false;
       }while (yeter);
    }

    public static int[] sifreUret(int[] array){
        Random random = new Random();
        int temp = 0;
        array[0] = random.nextInt(10);
        for (int i = 1; i < array.length; i++){
            temp = random.nextInt(10);
            for (int j = 0; j < i; j++){
                if (temp == array[j]){
                    i--;
                    break;
                }
                array[i] = temp;
            }
        }

       return array;
    }
}
