package mu.javaproject.ga.factory;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.crossover.TwoPointCrossover;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.mutation.SubstituteMutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.RankSelection;
import mu.javaproject.ga.selection.Selection;

public class SpecificTypeFactory extends GeneticFactory {
	Population population;

	SpecificTypeFactory(Population population) {
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
