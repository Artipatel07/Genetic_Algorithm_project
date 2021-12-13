package genetic_algorithm.factory;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.OnePointCrossover;
import genetic_algorithm.factory.GeneticConfigurationFactory.OperationType;

import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.mutation.RandomMutation;
import genetic_algorithm.population.Population;
import genetic_algorithm.selection.RandomSelection;
import genetic_algorithm.selection.Selection;

public class RandomSelectionMutationFactoryWithOnePointCrossover extends GeneticFactory {
	Population population;
	RandomSelectionMutationFactoryWithOnePointCrossover(Population population){
		this.population = population;
		selectionChoice();
		crossoverChoice();
		mutationChance();
	}
	@Override
	protected Selection selectionChoice() {

		return new RandomSelection(population);
	}

	@Override
	protected Crossover crossoverChoice( ) {

		return new OnePointCrossover(population);
	}

	@Override
	protected Mutation mutationChance() {

		return new RandomMutation(population);
	}

}
