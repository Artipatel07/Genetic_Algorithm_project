package genetic_algorithm.crossover;
import genetic_algorithm.population.Population;

/**
 * Crossover is my interface and two different types of crossovers
 * -1)OnePointCrossover,2)TwoPointCrossover are implemented by the sub class
 * which invokes this interface
 *
  */

public interface Crossover {

	abstract Population performCrossover(Population population);
}
