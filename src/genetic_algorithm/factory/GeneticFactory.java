package genetic_algorithm.factory;


import genetic_algorithm.crossover.Crossover;
import genetic_algorithm.factory.GeneticConfigurationFactory.OperationType;
import genetic_algorithm.factory.GeneticConfigurationFactory.PointType;
import genetic_algorithm.mutation.Mutation;
import genetic_algorithm.population.Population;
import genetic_algorithm.selection.Selection;

/**
 * This is the GeneticFactory class which is the Abstract factory pattern and this is the place where the user communicate to and asks for a specific version of a Genetic algorithm.
 * executeGeneticOperations() is the method which creates objects of Selection, Crossover and Mutation
 * It is called based on the input passed from the user in GeneticAlgorithmRunner.java
 * Each type of selection, crossover and mutation is specific to the type of configuration chosen.
 * Also includes 3 abstract methods and the sub class which extends GeneticFactory must implement the abstract methods
 *
 * @author AJAY GOVINDASAMY ,20251024
 */

public abstract class GeneticFactory {

    Selection select;
    Crossover cross;
    Mutation mutate;

    /**
     * Main method, depending on the configuration that was instantiated in GeneticAlgorithmRunner, it will call
     * specific methods styled for that configuration.
     *
     * @param type,        the type of Selection to perform
     * @param point,  the type of Point to perform.
     * @param population, the Population to be worked on.
     * @return Object
     */

    public Object executeGeneticOperations(OperationType type, PointType point, Population population) {
        select = selectionChoice(type, population);
        cross = crossoverChoice(point, population);
        mutate = mutationChance(point, population);
        return null;
    }

    public Selection getSelection() {
        return select;
    }

    public Crossover getCrossover() {
        return cross;
    }

    public Mutation getMutation() {
        return mutate;
    }


    /**
     * This method is defined in all relevant configs.
     * Each one alters this to suit their needs.
     *
     * @param type
     * @param population
     * @return Selection
     */
    protected abstract Selection selectionChoice(OperationType type, Population population);


    /**
     * This method is defined in all relevant configs.
     * Each one alters this to suit their needs.
     *
     * @param point
     * @param population
     * @return Crossover
     */

    protected abstract Crossover crossoverChoice(PointType point, Population population);

    /**
     * This method is defined in all relevant configs.
     * Each one alters this to suit their needs.
     *
     * @param mutationPoint
     * @param population
     * @return Mutation
     */

    protected abstract Mutation mutationChance(PointType point, Population population);

}
