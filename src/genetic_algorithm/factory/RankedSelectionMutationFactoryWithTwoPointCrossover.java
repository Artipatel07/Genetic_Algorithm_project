package genetic_algorithm.factory;

import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.crossover.TwoPointCrossover;
import genetic_algorithm.factory.GeneticConfigurationFactory.OperationType;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.mutation.SubstituteMutation;
import genetic_algorithm.population.Population;
import genetic_algorithm.selection.RankSelection;
import genetic_algorithm.selection.Selection;

public class RankedSelectionMutationFactoryWithTwoPointCrossover extends GeneticFactory {
	Population population;

	RankedSelectionMutationFactoryWithTwoPointCrossover(Population population) {
		this.population = population;
		selectionChoice();
		crossoverChoice();
		mutationChance();
	}

	@Override
	protected Selection selectionChoice() {
		// TODO Auto-generated method stub
		return new RankSelection(population);
	}

	@Override
	protected Crossover crossoverChoice() {
		// TODO Auto-generated method stub
		return new TwoPointCrossover(population);
	}

	@Override
	protected Mutation mutationChance() {
		// TODO Auto-generated method stub
		return new SubstituteMutation(population);
	}

}
