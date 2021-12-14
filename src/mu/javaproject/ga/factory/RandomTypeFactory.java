package mu.javaproject.ga.factory;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.crossover.OnePointCrossover;
import mu.javaproject.ga.factory.GeneticConfigurationFactory.OperationType;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.mutation.RandomMutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.RandomSelection;
import mu.javaproject.ga.selection.Selection;

public class RandomTypeFactory extends GeneticFactory {
	Population population;
	RandomTypeFactory(Population population){
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