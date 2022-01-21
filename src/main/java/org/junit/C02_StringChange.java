package org.junit;

public class C02_StringChange {
    /*
    Verilen bir String'deki ilk iki harf icinde A var ise bunlari silen method create ediniz.
    AACD -> CD
    ABC  -> BC
    AA   ->""
    A    ->""
    B    ->""
     */

 //   String method(String str){
 //       if (str.substring(0,1).equals("A") || str.equals(str.substring(1,2)).equals("A")){
 //           str =  str.substring(0,2).replaceAll("A","")+str.substring(2);
 //       }
 //       return str;
 //   }

    public String ilkIkiAsil(String str){
        if (str.length()<=2){
            return str.replaceAll("A","");
        }
        String ilkIkıKarakter = str.substring(0,2);
        String ilkIkıKaraktersonrasi = str.substring(2);
        return ilkIkıKarakter.replaceAll("A","")+ilkIkıKaraktersonrasi;
    }


}
