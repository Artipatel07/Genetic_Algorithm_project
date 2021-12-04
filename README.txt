WELCOME TO GENETIC ALGORITHM DEMO


/** Team Members: **/

1)AJAY GOVINDASAMY,20251024
2)AISHWARYA ARUN SUKALE,20251514
3)HRITIK GUPTA,20251132

All of the the above mentioned authors have contributed equally i.e 100% in the development of Genetic Algorithm project.

--> GeneticAlgorithmRunner.java inside genetic_algorithm.runner package is the start point for the compilation of the code


The project contains six packages in Total.

* genetic_algorithm.runner - runner package to compile the Algorithm with Strategy design pattern to allow different GA Selection,Crossover or Mutation Implementations(or strategies) at run-time.
* genetic_algorithm.factory - factory design pattern(Abstract factory is implemented) to handle the instantiation (creation) of the different Selection, Reproduction (/Crossover) or Mutation objects. 
* genetic_algorithm.selection/genetic_algorithm.crossover/genetic_algorithm.mutation - All the Operations of the Genetic Algorithm are invoked
* genetic_algorithm.population - SINGLETON class Population with the concept of lazy-initialisation and thread-safe implementation.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

OUTPUT OF THE PROJECT :

Generation: 1 Fittest: 5
Generation: 2 Fittest: 5
Generation: 3 Fittest: 4
Generation: 4 Fittest: 6
Generation: 5 Fittest: 5
Generation: 6 Fittest: 5
Generation: 7 Fittest: 5
Generation: 8 Fittest: 5
Generation: 9 Fittest: 5
Generation: 10 Fittest: 6
Generation: 11 Fittest: 5
Generation: 12 Fittest: 5
Generation: 13 Fittest: 4
Generation: 14 Fittest: 5
Generation: 15 Fittest: 5
Generation: 16 Fittest: 5
Generation: 17 Fittest: 5
Generation: 18 Fittest: 4
Generation: 19 Fittest: 5
Generation: 20 Fittest: 5
Generation: 21 Fittest: 5
Generation: 22 Fittest: 5
Generation: 23 Fittest: 5
Generation: 24 Fittest: 7
Generation: 25 Fittest: 5
Generation: 26 Fittest: 5
Generation: 27 Fittest: 5
Generation: 28 Fittest: 4
Generation: 29 Fittest: 4
Generation: 30 Fittest: 4
Generation: 31 Fittest: 4
Generation: 32 Fittest: 4
Generation: 33 Fittest: 6
Generation: 34 Fittest: 6
Generation: 35 Fittest: 4
Generation: 36 Fittest: 4
Generation: 37 Fittest: 3
Generation: 38 Fittest: 3
Generation: 39 Fittest: 4
Generation: 40 Fittest: 6
Generation: 41 Fittest: 5
Generation: 42 Fittest: 5
Generation: 43 Fittest: 6
Generation: 44 Fittest: 6
Generation: 45 Fittest: 6
Generation: 46 Fittest: 5
Generation: 47 Fittest: 5
Generation: 48 Fittest: 5
Generation: 49 Fittest: 6
Generation: 50 Fittest: 6
Generation: 51 Fittest: 8
Solution found in generation 51
Fitness: 8
Genes: 11111111


--> The above output states that we have found the solution which means maximum fitness function f(x) for the Genetic Algorithm problem in the 51st Generation

--> The program initially checks whether it can find a maximum fitness in the 1st generation and if it is not found, the algorithm loops over SELECTION,CROSSOVER and MUTATION operations in every 
    generation until to find the maximum possible fitness f(x) in a particular generation which is the solution.

----------------------------------------------------------------------------------------------------------------------------------


__singleton pattern__ :


--> Singleton pattern is implemented in Population.java class as every class in the project should work on the same population class, thats why it employs singleton instance.


From the below code,

        //Single Instance concurrency across the application is maintained as every class is working on the same population.
	//Making the constructor private so that only one instance of the Population can be loaded
	private Population() {

	}

	//instance is created only when the Genetic Algorithm runs

	/*** thread safe lazy initialisation using wrapperClass***/
	private static class WrapperClass {
		static Population instance = new Population();
	}

	//private instance variable which will load Population object only when it is called through getInstance()
	public static Population getInstance() {
		return WrapperClass.instance;
	}

--> We have implemented thread safe lazy initialisation using wrapperClass because we want to have the Population instance to be created only if the Genetic Algorithm Runner class starts running (i.e.,) only when the application starts running.


__strategy pattern__:

--> Strategy pattern is invoked in GeneticAlgorithmRunner.java stating a class behaviour or its algorithm can be changed at run time (i.e.,) the strategy object changes the executing algorithm of the context object.

From the below code,

configurationFactory.executeGeneticOperations(OperationType.RANK, PointType.ONE , population);

--> The implementation context of the Strategy is changed based on the parameter passed(OperationType.RANK, PointType.ONE) which symbolises different GA Selection,Crossover or Mutation Implementations(or strategies) can be decided at run-time.

//Strategy of the Genetic Operations changes based on the parameters type and point passed below

public Object executeGeneticOperations(OperationType type, PointType point, Population population) {
        select = selectionChoice(type, population);
        cross = crossoverChoice(point, population);
        mutate = mutationChance(point, population);
        return null;
    }


__factory pattern__ :

--> We have implemented Abstract factory design pattern in GeneticFactory.java and and this is the place where the user communicates to and asks for a specific version of a Genetic algorithm.

--> GeneticFactory.java creates an interface to invoke all the Genetic operations but leaves the creation to concrete factory classes inside GeneticConfigurationFactory.java

For Example,
From the below code,

//Selection operation
protected Selection selectionChoice(OperationType type, Population population) {

        if (type.equals(OperationType.RANDOM)) {
            return new RandomSelection(population);
        } else if (type.equals(OperationType.RANK)) {
            return new RankSelection(population);
        } else {
            throw new IllegalArgumentException("Illegal Argument" + type);
        }
    }

--> Corresponding to the type passed, the instantiation (creation) of the different Selection, Reproduction (/Crossover) or Mutation Operator objects are handled and this shows the separation of behaviours and implementation in factory Design pattern.
--------------------------------------------------------------------------------------------------------------------------------------------
