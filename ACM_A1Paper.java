/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acm_a1paper;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author tongd
 */
public class ACM_A1Paper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        //int[] quantity = new int[max-1];
        double bigSide = Math.pow(2.0, -3.0/4.0);
        double smallSide = Math.pow(2.0, -5.0/4.0); 
        double initSmall = smallSide;
        double initBig = bigSide;
        double need = 1;
        double tape = 0;
        for (int i = 2; i < max+1; i++) {
            need *= 2; 
            int quantity = sc.nextInt();
            if(i != 2 && i%2==0) smallSide /= 2;
            else if (i != 2) bigSide /= 2;
            if(need < quantity) {
                tape = tape + (smallSide + bigSide)*need*2;
                need -= quantity;
                break;
            }
            else {
                tape = tape + (smallSide + bigSide)*quantity*2;
                need -= quantity;
            }
        }
        if(need > 0) System.out.println("impossible");
        else System.out.println((tape-(initBig+initSmall*2)*2)/2.0);
    }
    
}
