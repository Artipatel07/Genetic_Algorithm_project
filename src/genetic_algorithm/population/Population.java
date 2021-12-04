package genetic_algorithm.population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the SINGLETON class. As every class in the project should work on the
 * same population class,thats why it employs singleton instance. (i.e.,) it has
 * only one instance to work on the same data throughout the project. I have
 * implemented thread safe lazy initialization using wrapperClass because I want
 * to have the Population instance to be created only if the Genetic Algorithm
 * Runner class starts running (i.e.,) only when the application starts running
 * 
 * @author AISHWARYA SUKALE,20251514: 
 */
public class Population {

	private List<Individual> individuals = new ArrayList<>();
	private Individual fittestIndividual;
	private Individual secondFittestIndividual;
	private int populationSize = 0;
	private int fittest = 0;
	private static Population _instance =null;
	// Single Instance concurrency across the application is maintained as every
	// class is working on the same population.
	// Making the constructor private so that only one instance of the Population
	// can be loaded
	private Population() {

	}

	// instance is created only when the Genetic Algorithm runs
	/*** thread safe lazy initialization ***/
	// private _instance variable which will load Population object only when it is
	// called through getInstance()
	public static Population getInstance() {
		
		if (_instance == null) {
			_instance = new Population();
		}
		return _instance;
	}

	/**
	 * @param size       is the population size
	 * @param initialise is the number of genes an individual will have
	 */
	public void initialPopulation(int size, Boolean initialise) {
		this.setPopulationSize(size);
		List<Individual> tempArray = new ArrayList<Individual>();
		if (initialise) {
			for (int i = 0; i < size; i++) {
				tempArray.add(new Individual());
				//tempArray[i] = new Individual();
			}
			this.setIndividuals(tempArray);
		}
	}

	// Calculate fitness f(x) of each individual
	public void fitnessFunction() {

		for (int i = 0; i < getPopulationSize(); i++) {
			getIndividuals().get(i).calculateIndividualFitness();
		}
		getMostFittest();
	}

	/**
	 * function to get the most fittest individual among the population
	 * 
	 * @return Individual
	 */

	public Individual getMostFittest() {
		int maximumFit = Integer.MIN_VALUE;
		int maximumFitIndex = 0;
		for (int i = 0; i < getPopulationSize(); i++) {
			if (maximumFit <= getIndividuals().get(i).getFitness()) {
				maximumFit = getIndividuals().get(i).getFitness();
				maximumFitIndex = i;
			}
		}
		setFittest(getIndividuals().get(maximumFitIndex).getFitness());
		return getIndividuals().get(maximumFitIndex);
	}

	/**
	 * function to get Total maximum fitness(Genes) that can be obtained
	 * 
	 * @return fitness length
	 */

	public int getMaximumFitness() {
		int fitnessLength = Individual.geneLength-2;
		return fitnessLength;
	}

	/**
	 * function to get the second most fittest individual among the population
	 * 
	 * @return Individual
	 */

	public Individual getSecondFittest() {
		int maxFit1 = 0;
		int maxFit2 = 0;
		for (int i = 0; i < getPopulationSize(); i++) {
			if (getIndividuals().get(i).getFitness() > getIndividuals().get(maxFit1).getFitness()) {
				maxFit2 = maxFit1;
				maxFit1 = i;
			} else if (getIndividuals().get(i).getFitness() > getIndividuals().get(maxFit1).getFitness()) {
				maxFit2 = i;
			}
		}
		return getIndividuals().get(maxFit2);
	}

	/**
	 * function to get index of least fittest individual
	 * 
	 * @return Individual
	 */

	public int getLeastFittestIndex() {
		int minFitVal = Integer.MAX_VALUE;
		int minFitIndex = 0;
		for (int i = 0; i < getPopulationSize(); i++) {
			if (minFitVal >= getIndividuals().get(i).getFitness()) {
				minFitVal = getIndividuals().get(i).getFitness();
				minFitIndex = i;
			}
		}
		return minFitIndex;
	}

	/** Each Individual in a population **/
	
	/**
	 * getter for the Object of each Individual.
	 * 
	 * @return individuals
	 */

	public List<Individual> getIndividuals() {
		return individuals;
	}

	/**
	 * setter for the Object of each Individual.
	 * @param individuals
	 */

	public void setIndividuals(List<Individual> individuals) {
		this.individuals = individuals;
	}

	/**
	 * getter for population size
	 * 
	 * @return populationSize
	 */
	public int getPopulationSize() {
		return populationSize;
	}

	/**
	 * setter for population size
	 * @param populationSize set value of the fitness of population
	 */
	public void setPopulationSize(int populationSize) {
		this.populationSize = populationSize;
	}

	/**
	 * getter for fittest
	 * 
	 * @return fittest
	 */

	public int getFittest() {
		return fittest;
	}

	/**
	 * setter for fittest
	 * 
	 * @param fittest value of the fittest of the population
	 */

	public void setFittest(int fittest) {
		this.fittest = fittest;
	}

	/**
	 * getter to calculate the fitness of every single individual in the population
	 * 
	 * @return fittest individual amoung population
	 */

	public Individual getFittestIndividual() {
		return fittestIndividual;
	}

	/**
	 * setter to calculate the fitness of every single individual in the population
	 * 
	 * @param fittestIndividual
	 */

	public void setFittestIndividual(Individual fittestIndividual) {
		this.fittestIndividual = fittestIndividual;
	}

	/**
	 * getter to calculate the second fittest of every single individual in the
	 * population
	 * 
	 * @return second fittest individual amoung population
	 */

	public Individual getSecondFittestIndividual() {
		return secondFittestIndividual;
	}

	/**
	 * setter to calculate the second fittest of every single individual in the
	 * population
	 * 
	 * @param secondFittestIndividual
	 */

	public void setSecondFittestIndividual(Individual secondFittestIndividual) {
		this.secondFittestIndividual = secondFittestIndividual;
	}

}
