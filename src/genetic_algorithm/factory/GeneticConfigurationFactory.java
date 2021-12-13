package genetic_algorithm.factory;

import java.util.Random;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.OnePointCrossover;
import genetic_algorithm.crossover.TwoPointCrossover;
import genetic_algorithm.factory.GeneticConfigurationFactory.OperationType;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.mutation.SubstituteMutation;
import genetic_algorithm.mutation.RandomMutation;
import genetic_algorithm.population.Population;
import genetic_algorithm.selection.RandomSelection;
import genetic_algorithm.selection.RankSelection;
import genetic_algorithm.selection.Selection;

/**
 * GeneticAlgorithmRunner is the main class to perform all the operations This
 * class is the implementation of factory design pattern which handles the
 * instantiation (creation) of the different Selection, Reproduction
 * (/Crossover) or Mutation objects.
 *
 * @author AJAY GOVINDASAMY ,20251024
 */

public class GeneticConfigurationFactory extends GeneticFactory {
	/**
	 * This method will generate a new class of one of the crossover classes that
	 * are for this genetic configuration setup.
	 *
	 * @param type Population population
	 * @return Selection
	 */

	public enum OperationType {
		RANDOM, RANK
	};

	public OperationType randomOperationType() {
		OperationType[] values = OperationType.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];

	}

	public GeneticFactory executeGeneticOperations(Population population) {
		if (randomOperationType() == OperationType.RANDOM) {
			return new RandomSelectionMutationFactoryWithOnePointCrossover(population);
		} else {
			return new RankedSelectionMutationFactoryWithTwoPointCrossover(population);
		}
	}

	@Override
	protected Selection selectionChoice() {
		return null;

	}

	@Override
	protected Crossover crossoverChoice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Mutation mutationChance() {
		// TODO Auto-generated method stub
		return null;
	}

}
