package com.neoteric.it;

public class Sample {

       public static void main(String args[])  
       {
 
           String  str1 = new String("OKAY");
           String  str2  =  new String(str1);
           System.out.println(str1 == str2);
           String s1 = "SITHA" ;
           String s2 = "RAMA";
           System.out.println(s1.charAt(0) > s2.charAt(0));
           
           System.out.println(""+("Toolbar".startsWith("bar", 4)));
           String str11 = "one";;
           String str12 = "two";
           System.out.println(str11.concat(str12).equals(str11 + str12)); 		
           String str14 = "Helloww".replace('l', 'w');
           System.out.println(str14);
           
           String str = "Hello";
           
           final StringBuffer sb = new StringBuffer("I am Okay");
           sb.append("and You are Okay");
           System.out.println(sb);
           System.out.println(str); 
           
           
           int x = 99, y = 100 ;
           System.out.println(x / y);
           
    
           
       }

}
