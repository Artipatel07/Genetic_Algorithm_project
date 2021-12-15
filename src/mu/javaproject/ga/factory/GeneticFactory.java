package mu.javaproject.ga.factory;

import java.util.Random;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.factory.GeneticConfigurationFactory.OperationType;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.Selection;

/**
 * This is the Abstract factory pattern's GeneticFactory class, which is where the user communicates with and requests 
 * a specific version of a *Genetic algorithm. 
 * executeGeneticOperations() is a method for creating Selection, Crossover, and Mutation objects. 
 * In GeneticAlgorithmRunner.java, it is called depending 
 * on the user's input. The kind of configuration 
 * selected determines which types of 
 * selection, crossover, and mutation are used. There are also three abstract methods, as well as a subclass that extends 
 * GeneticFactory, which must be implemented.
 *
 */

public abstract class GeneticFactory {

//	GeneticFactory random;
	

	/**
	 * The main method will call particular methods styled 
	 * for that configuration, based on the configuration that 
	 * was created in 
	 * GeneticAlgorithmRunner.
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
	 * In all relevant configs, this method is defined. 
	 * This is changed by each individual to fit their own needs.
	 *
	 * @param type
	 * @param population
	 * @return Selection
	 */
	protected abstract Selection selectionChoice();

	/**
	 * In all relevant configs, this method is defined. 
	 * This is changed by each individual to fit their own needs.
	 *
	 * @param point
	 * @param population
	 * @return Crossover
	 */

	protected abstract Crossover crossoverChoice();

	/**
	 * In all relevant configs, this method is defined. 
	 * This is changed by each individual to fit their own needs.
	 *
	 * @param mutationPoint
	 * @param population
	 * @return Mutation
	 */

	protected abstract Mutation mutationChance();

	

}
