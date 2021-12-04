package genetic_algorithm.selection;


import genetic_algorithm.population.Population;

/**
 * This class implements @see GeneticFunctions and is used to perform a selection process by selecting the first and second fittest individuals   * from a population.
 *
 * @author ASHI CHAUHAN,21250591
 */

public class RankSelection implements Selection {

    public RankSelection(Population population) {
        performSelection(population);
    }

    /**
     * @return population
     * @purpose The Rank Selection genetic Process has been carried out by this function.
     */

    public Population performSelection(Population population) {
        population.setFittestIndividual(population.getMostFittest());
        population.setSecondFittestIndividual(population.getSecondFittest());
        return population;
    }
}



