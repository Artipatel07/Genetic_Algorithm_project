package genetic_algorithm.crossover;

import java.util.Random;

import genetic_algorithm.population.Individual;
import genetic_algorithm.population.Population;

/**
 * This class is used to take two points from the parents and to swap the genes
 * to perform the crossover Operation, it implements @see GeneticFunctions
 *
 * @author AJAY GOVINDASAMY ,20251024
 */

public class TwoPointCrossover implements Crossover {

    public TwoPointCrossover(Population population) {
    	performCrossover(population);
    }

    /**
     * @param population
     * @return population
     * @purpose This function executes the operation of the TwoPointCrossover genetic 
     * function
     */

    public Population performCrossover(Population population) {

        Random randomNum = new Random();
        //Ashi changing logic for getting points for crossover
        int crossPoint1 = randomNum.nextInt(Individual.geneLength-4);
        int crossPoint2 = crossPoint1 + 3;

        // Ensure crossPoints are different 
//        if (crossPoint1 == crossPoint2) {
//            if (crossPoint1 == 0) {
//                crossPoint2++;
//            } else {
//                crossPoint1--;
//            }
//        }
//        // and crossPoint1 is lower than crossPoint2
//        if (crossPoint2 < crossPoint1) {
//            int temp = crossPoint1;
//            crossPoint1 = crossPoint2;
//            crossPoint2 = temp;
//        }
//
        // Swap values among Individuals
        //Ashi changed logic for if condition
        for (int i = 0; i < Individual.geneLength; i++) {
            if (i > crossPoint1 && i < crossPoint2) {
                int temp = population.getFittestIndividual().getGenes().get(i);
                population.getFittestIndividual().getGenes().set(i, population.getSecondFittestIndividual()
                        .getGenes().get(i));
                population.getSecondFittestIndividual().getGenes().set(i, temp);
            }
        }
        return population;
    }
}
