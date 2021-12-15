package mu.javaproject.ga.factory;

import java.util.Random;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.crossover.OnePointCrossover;
import mu.javaproject.ga.crossover.TwoPointCrossover;
import mu.javaproject.ga.factory.GeneticConfigurationFactory.OperationType;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.mutation.RandomMutation;
import mu.javaproject.ga.mutation.SubstituteMutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.RandomSelection;
import mu.javaproject.ga.selection.RankSelection;
import mu.javaproject.ga.selection.Selection;

/**
 * The core class for all operations is GeneticAlgorithmRunner. 
 * This class implements the factory design pattern, which manages the instantiation  *(creation) of various Selection, Reproduction (/Mutation)   * or (/Crossover) objects.
 *
 */

public class GeneticConfigurationFactory extends GeneticFactory {
	/**
	 * This function will create a new crossover class for one of 
	 * the genetic configuration setup's crossover classes..
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
			return new RandomTypeFactory(population);
		} else {
			return new SpecificTypeFactory(population);
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
