WELCOME TO GENETIC ALGORITHM PROJECT OVERVIEW:


/** Team Members: **/

1)ARTI PATEL,21250524
2)ASHI CHAUHAN,21250591
3)PRIYANKA SHIVAJI DUDHE,21250504
4)SANTHOSH KUMAR JAYAVEL,20250813

All of the the above mentioned members have contributed equally( 25 % EACH )  i.e 100% in the development of Genetic Algorithm project.

--> GeneticAlgorithmRunner.java inside mu.javaproject.ga.runner package is the start point for the compilation of the code.


The project contains six packages in Total.

* mu.javaproject.ga.runner - runner package to compile the Algorithm with Strategy design pattern to allow different GA Selection,Crossover or Mutation Implementations(or strategies) at run-time.
* mu.javaproject.ga.factory - factory design pattern(Abstract factory is implemented) to handle the instantiation (creation) of the different Selection, Reproduction (/Crossover) or Mutation objects. 
* mu.javaproject.ga.selection/mu.javaproject.ga.crossover/mu.javaproject.ga.mutation - All the Operations of the Genetic Algorithm are invoked
* mu.javaproject.ga.population - SINGLETON class Population with the concept of lazy-initialisation and thread-safe implementation.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

OUTPUT OF THE PROJECT :

--Output of the projetc is mention in the output.txt file.


--> The above output states that we have found the solution which means maximum fitness function f(x) for the Genetic Algorithm problem in the 51st Generation

--> The code initially attempts to see if it can achieve a maximum fitness in the first generation, and if it can't, it repeats the process. In each generation, perform SELECTION, CROSSOVER, and MUTATION operations until you discover the greatest feasible fitness f(x) in that generation, which is the solution.

----------------------------------------------------------------------------------------------------------------------------------

1.singleton pattern:


--> In Population class, the singleton pattern is used. Because every class in the project should operate with the same population class, singleton instances are used.


From the below code,

        //Because every class is working on the same population, single instance concurrency is maintained throughout the program.
	//Making the constructor private so that only one instance of the Population can be loaded.
	private Population() {

	}

	//Only when the Genetic Algorithm runs is an instance created.

	/**thread safe lazy initialisation using getInstance**/

	public static Population getInstance() {
		if (_instance == null) {
		// synchronized block to remove overhead
		synchronized (Population.class) {
		if (_instance == null) {
		_instance = new Population();
		}
		}
	}
		return _instance;
		}
	

--> We used the getInstance static method of the population class to provide thread safe lazy initialization since we only want the Population instance to be generated when the Genetic Algorithm Runner class starts running (i.e., only when the application starts running).
--if the population runs again then what problems we could have face.-- need to write comment about it.


2.strategy pattern:

--> in 'GeneticAlgorithm Runner' file we have used the Strategy pattern. A class's behavior or algorithm can be altered during runtime in Java (i.e., the strategy object alters the context object's execution algorithm).

From the below code,

configurationFactory.executeGeneticOperations(OperationType.RANK, PointType.ONE , population);

--> The Strategy's implementation environment is altered based on the parameter given (OperationType.RANK, PointType.ONE), which represents multiple GA Selection, Crossover, or Mutation Implementations(or strategies) that may be chosen at run-time.

//The Genetic Operations strategy differs depending on the kind of parameter and point passed below.

public Object executeGeneticOperations(OperationType type, PointType point, Population population) {
        select = selectionChoice(type, population);
        cross = crossoverChoice(point, population);
        mutate = mutationChance(point, population);
        return null;
    }


3.factory pattern:



--> We have implemented Abstract factory design pattern in GeneticFactory.java and and this is the place where the user communicates to and asks for a specific version of a Genetic algorithm.

--> GeneticFactory.java offers an interface that may be used to call all of the genetic processes, but it leaves the construction to the concrete factory classes in GeneticConfigurationFactory.java.

For Example,

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

--> The instantiation (creation) of the various Selection, Reproduction (/Crossover), or Mutation Operator objects is handled according to the type supplied, demonstrating the separation of behaviors and implementation in the factory Design pattern.

-- For the better understanding about the abstact factory pattern diagram is attached into the  (AbstractFactoryPattern.png) file.


4. Data Abstraction - It is used in the packages Crossover, Selection, and Mutation.
5. Data hiding - Individual class it's gene and fitness is private and can be accessed through getter and setter method.
GeneticAlgorithmRunner class has private Population  object.
In Population class data like fittestIndividual, secondFittestIndividual, size and all individual details are private and only accessible through getter setter and outside Population class nobody should be able to change these data directly.
---------------------------------------------------------------------------------------------------------------------------------------
