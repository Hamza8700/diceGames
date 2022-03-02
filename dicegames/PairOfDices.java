package dicegames;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;

	private int rollBothDices; // opgave 1.5)

	private int numberOfSixRolls;
	private int numberOfFiveRolls;
	private int numberOfFourRolls;
	private int numberOfThreeRolls;
	private int numberOfTwoRolls;
	private int numberOfOneRolls;

	private int sameFaceCount;

	private int highestFaceSum;

	/**
	 * Constructor for objects of class dicegames.PairOfDices
	 */
	// TODO: put the constructor here!

	// opgave 1.1)
	public PairOfDices() {
		die1 = new Die();
		die2 = new Die();
	}

	// opgave 1.2)
	public PairOfDices(int sides1, int sides2) {
		die1 = new Die(sides1);
		die2 = new Die(sides2);
	}

	// opgave 1.3)
	public void rollBothDices() {
		die1.roll();
		die2.roll();
		rollBothDices = rollBothDices + 1;

		if (die1.getFaceValue() == 1) {numberOfOneRolls++;};
		if (die1.getFaceValue() == 2) {numberOfTwoRolls++;};
		if (die1.getFaceValue() == 3) {numberOfThreeRolls++;};
		if (die1.getFaceValue() == 4) {numberOfFourRolls++;};
		if (die1.getFaceValue() == 5) {numberOfFiveRolls++;};
		if (die1.getFaceValue() == 6) {numberOfSixRolls++;};
		if (die2.getFaceValue() == 1) {numberOfOneRolls++;};
		if (die2.getFaceValue() == 2) {numberOfTwoRolls++;};
		if (die2.getFaceValue() == 3) {numberOfThreeRolls++;};
		if (die2.getFaceValue() == 4) {numberOfFourRolls++;};
		if (die2.getFaceValue() == 5) {numberOfFiveRolls++;};
		if (die2.getFaceValue() == 6) {numberOfSixRolls++;};

		if (die1.getFaceValue() == die2.getFaceValue()) {
			sameFaceCount++;
		}

		if (sumOfDices() > highestFaceSum) {
			highestFaceSum = sumOfDices();
		}
	}

	// opgave 1.4)
	public int sumOfDices() {
		int sum = die1.getFaceValue() + die2.getFaceValue();
		return sum;
	}

	// opgave 1.6)

	public int getNumberOfSixRolls() {
		return numberOfSixRolls;
	}

	// opgave 1.7)
	public int getNumberOfFiveRolls() {
		return numberOfFiveRolls;
	}

	public int getNumberOfFourRolls() {
		return numberOfFourRolls;
	}

	public int getNumberOfThreeRolls() {
		return numberOfThreeRolls;
	}

	public int getNumberOfTwoRolls() {
		return numberOfTwoRolls;
	}

	public int getNumberOfOneRolls() {
		return numberOfOneRolls;
	}

	// opgave 1.8)
	public int getSameFaceCount() {
		return sameFaceCount;
	}

	// opgave 1.9)
	public int getHighestFaceSum() {
		return highestFaceSum;
	}

	// opgave 1.10)
	public void resetPairOfDices() {
		rollBothDices = 0;
		numberOfSixRolls = 0;
		numberOfFiveRolls = 0;
		numberOfFourRolls = 0;
		numberOfThreeRolls = 0;
		numberOfTwoRolls = 0;
		numberOfOneRolls = 0;
		sameFaceCount = 0;
		highestFaceSum = 0;
	}

}
