package genetic_algorithm.runner;


import genetic_algorithm.factory.GeneticConfigurationFactory;
import genetic_algorithm.factory.GeneticConfigurationFactory.OperationType;
import genetic_algorithm.factory.GeneticConfigurationFactory.PointType;
import genetic_algorithm.factory.GeneticFactory;
import genetic_algorithm.population.Individual;
import genetic_algorithm.population.Population;

/**
 * This is the runner class for the project.
 * It will first create a SINGLE instance(Singleton) of Population class to make sure every class is working on the same population instance.
 * I have created the Factory to be GeneticFactory and this is the Abstract Factory Pattern where all the Genetic Operations are abstracted.
 * At First, We are Creating a initial population and calculating fitness function f(x) to find the fittest person.
 * If maximum fitness is not obtained, genetic operations will start with SELECTION,CROSSOVER and MUTATION process and the loop goes on until we find the maximum fitness in any particular generation
 *  
 * @author HRITIK GUPTA, 20251132
 */


public class GeneticAlgorithmRunner {

	private static Population population;
	private static int generationCount = 1;

	/**
	 * Starting point of Genetic Algorithm Operations
	 *
	 * @param args this is used to pass the variable in runtime. But here we are not
	 *             using this
	 */

	public static void main(String[] args) {

		population = Population.getInstance();

		GeneticFactory configurationFactory = new GeneticConfigurationFactory();


		// Initialize the population
		population.initialPopulation(5, true);

		// calculate the fitness of the initial population
		population.fitnessFunction();
		System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittest());

		//Loop until maximum fitness is found 
		while (population.getFittest() < population.getMaximumFitness()) {

			++generationCount;

			/** Strategy Design pattern to allow different GA Selection,Crossover or Mutation Implementations(or strategies) at run-time **/
			configurationFactory.executeGeneticOperations(OperationType.RANK, PointType.ONE , population);

			//calculate new fitness of the Individuals
			population.fitnessFunction();
			System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittest());
		}

		//prints the final solution
		System.out.println("Solution found in generation " + generationCount);
		System.out.println("Fitness: " + population.getMostFittest().getFitness());
		System.out.print("Genes: ");
		for (int i = 0; i < Individual.geneLength; i++) {
			System.out.print(population.getMostFittest().getGenes().get(i));
		}

		System.out.println("");

	}
}
