package mu.javaproject.ga.factory;

import java.util.Random;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.factory.GeneticConfigurationFactory.OperationType;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.Selection;

/**
 * This is the GeneticFactory class which is the Abstract factory pattern and
 * this is the place where the user communicate to and asks for a specific
 * version of a Genetic algorithm. executeGeneticOperations() is the method
 * which creates objects of Selection, Crossover and Mutation It is called based
 * on the input passed from the user in GeneticAlgorithmRunner.java Each type of
 * selection, crossover and mutation is specific to the type of configuration
 * chosen. Also includes 3 abstract methods and the sub class which extends
 * GeneticFactory must implement the abstract methods
 *
 * @author AJAY GOVINDASAMY ,20251024
 */

public abstract class GeneticFactory {

//	GeneticFactory random;
	

	/**
	 * Main method, depending on the configuration that was instantiated in
	 * GeneticAlgorithmRunner, it will call specific methods styled for that
	 * configuration.
	 *
	 * @param type,       the type of Selection to perform
	 * @param point,      the type of Point to perform.
	 * @param population, the Population to be worked on.
	 * @return Object
	 */

	public OperationType randomOperationType() {
		OperationType[] values = OperationType.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];

	}

	/**
	 * This method is defined in all relevant configs. Each one alters this to suit
	 * their needs.
	 *
	 * @param type
	 * @param population
	 * @return Selection
	 */
	protected abstract Selection selectionChoice();

	/**
	 * This method is defined in all relevant configs. Each one alters this to suit
	 * their needs.
	 *
	 * @param point
	 * @param population
	 * @return Crossover
	 */

	protected abstract Crossover crossoverChoice();

	/**
	 * This method is defined in all relevant configs. Each one alters this to suit
	 * their needs.
	 *
	 * @param mutationPoint
	 * @param population
	 * @return Mutation
	 */

	protected abstract Mutation mutationChance();

	

}
