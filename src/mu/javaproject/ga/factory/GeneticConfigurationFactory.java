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
