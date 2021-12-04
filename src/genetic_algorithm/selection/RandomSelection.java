package genetic_algorithm.selection;

import java.util.Random;

import genetic_algorithm.population.Population;


/**
 * This is RandomSelection class.
 * This class is used to perform a selection process by selecting two random choices.
 * It implements @see GeneticFunctions among individuals in the population.
 *
 * @author ASHI CHAUHAN,21250591
 */

public class RandomSelection implements Selection {
    public RandomSelection(Population population) {
        performSelection(population);
    }


    /**
     * @return population
     * @purpose The Random Selection genetic Operation is carried out using this function.
     */

    public Population performSelection(Population population) {
        Random random = new Random();
        population.setFittestIndividual(population.getIndividuals().get(random.nextInt(population.getPopulationSize())));
        population.setSecondFittestIndividual(population.getIndividuals().get(random.nextInt(population.getPopulationSize())));
        return population;
    }
}


