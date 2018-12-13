/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic_algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Kumoko
 */
public class TSP_GA {
public static void main(String[] args) {
    String fileName = "E:\\kuliah\\OKH\\datasets\\small2.csv";
    File file = new File(fileName);
    try {
        Scanner inputStream = new Scanner(file);
        
        int isi=inputStream.nextInt();
        City a[]=new City[isi];
        
       int  index=0;
        while (inputStream.hasNext()){
            String data=inputStream.next();
            String array1[]= data.split(",");
            
            a[index]=new City(Integer.parseInt(array1[0]),Integer.parseInt(array1[1]));
            TourManager.addCity(a[index]);
            index++; 

        }
        inputStream.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        // Initialize population
        Population pop = new Population(5000, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations 
        pop = GA.evolvePopulation(pop);
        
        int  iterasi=0;
        for (int i = 0; i < 10; i++) {
            pop = GA.evolvePopulation(pop);
            iterasi++;
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest()); 
        System.out.println("Jumlah Iterasi:" + iterasi);

    }
}