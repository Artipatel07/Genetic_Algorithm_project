package genetic_algorithm.factory;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.OnePointCrossover;
import genetic_algorithm.crossover.TwoPointCrossover;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.mutation.SubstituteMutation;
import genetic_algorithm.mutation.RandomMutation;
import genetic_algorithm.population.Population;
import genetic_algorithm.selection.RandomSelection;
import genetic_algorithm.selection.RankSelection;
import genetic_algorithm.selection.Selection;

/**
 * GeneticAlgorithmRunner is the main class to perform all the operations
 * This class is the implementation of factory design pattern which handles the 
 * instantiation (creation) of the different Selection, Reproduction (/Crossover) or Mutation objects.
 *
 * @author AJAY GOVINDASAMY ,20251024
 */

public class GeneticConfigurationFactory extends GeneticFactory {
    /**
     * This method will generate a new class of one of the crossover classes that are for this genetic configuration setup.
     *
     * @param type Population population
     * @return Selection
     */

	public enum OperationType {RANDOM,RANK};
	public enum PointType {ONE,TWO};
	
	
    @Override
    protected Selection selectionChoice(OperationType type, Population population) {

        if (type.equals(OperationType.RANDOM)) {
            return new RandomSelection(population);
        } else if (type.equals(OperationType.RANK)) {
            return new RankSelection(population);
        } else {
            throw new IllegalArgumentException("Illegal Argument" + type);
        }
    }

    /**
     * crossoverChoice() will generate a new class of one of the crossover classes that are for this genetic configuration setup.
     *
     * @param point, the type of crossover to be done.
     * @return a Crossover object
     */

    protected Crossover crossoverChoice(PointType point, Population population) {
        if (point.equals(PointType.ONE)) {
            return new OnePointCrossover(population);
        } else if (point.equals(PointType.TWO)) {
            return new TwoPointCrossover(population);
        } else throw new IllegalArgumentException("Illegal Argument" + point);
    }


    /**
     * This mutationChance will call the biased style 10% of the time.
     *
     * @param population The population to be worked on
     * @return Mutation
     */

    protected Mutation mutationChance(PointType point, Population population) {
        if (point.equals(PointType.ONE)) {
            return new RandomMutation(population);
        } else if (point.equals(PointType.TWO)) {
            return new SubstituteMutation(population);
        } else throw new IllegalArgumentException("Illegal Argument" + point);
    }

}
