package genetic_algorithm.population;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {
	private int fitness = 0;
	private List<Integer> genes = new ArrayList<>();
	public static final int geneLength = 14;

	public Individual() {
		Random randomNum = new Random();
		// Set genes randomly for each of the individual
		for (int i = 0; i < geneLength; i++) {
			getGenes().add(Math.abs(randomNum.nextInt() % 2));
		}
		setFitness(0);
	}

	// Calculate Individual fitness
	public void calculateIndividualFitness() {
	
		int fitnessCount=0;
		for (int i = 0; i < geneLength; i++) {
			if (getGenes().get(i) == 1) {
				++fitnessCount;
			}
		}
		setFitness(fitnessCount);
	}
	
	/** All the getters and setters invocation **/

	/**
	 * getter for the fitness of each Individual
	 * 
	 * @return fitness
	 */

	public int getFitness() {
		return fitness;
	}

	/**
	 * setter for the fitness of each Individual
	 * 
	 * @param fitness
	 */

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	/**
	 * getter for total length of the genes(Chromosomes)
	 * 
	 * @return gene length
	 */

//	public int getGeneLength() {
//		return geneLength;
//	}
//
//	/**
//	 * setter for length of the genes(Chromosome)
//	 * 
//	 * @param geneLength
//	 */
//
//	public void setGeneLength(int geneLength) {
//		this.geneLength = geneLength;
//	}
//
//	/**
//	 * getter for genes(Chromosomes)
//	 * 
//	 * @return genes
//	 */
//
	public List<Integer> getGenes() {
		return genes;
	}

	/**
	 * setter for genes(Chromosomes)
	 * 
	 * @param genes
	 */

	public void setGenes(List<Integer> genes) {
		this.genes = genes;
	}

}

