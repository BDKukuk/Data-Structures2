package p2_package;

public class N2_SortDriverClass
{

	/**
	 *
	 * @param charArr
	 * @param size
	 * @return
	 *
	 * This sort uses two loops and an if statement to iterate through an array
	 * while switching values along the way.
	 */
	public static char[] runBubbleSort(char[] charArr, int size)
	{
		int unsortedArrayIndex;
		int arrayIndex;

		for(unsortedArrayIndex = size - 1; unsortedArrayIndex > 0;
			unsortedArrayIndex--)
		{
			for(arrayIndex = 0; arrayIndex < unsortedArrayIndex; arrayIndex++)
			{
				if(charArr[arrayIndex] > charArr[arrayIndex + 1])
				{
					swapValues(charArr,arrayIndex,arrayIndex + 1);
				}
			}
		}
		return charArr;
	}

	/**
	 *
	 * @param charArr
	 * @param size
	 * @return
	 * This array iterates through an array while having a placeholder to check
	 * against.
	 */
	public static char[] runInsertionSort(char[] charArr,int size)
	{
		int unsortedArrayIndex;
		int arrayIndex;
		char placeholder;

		for( unsortedArrayIndex = 1; unsortedArrayIndex < size;
			 unsortedArrayIndex++)
		{
			placeholder = charArr[unsortedArrayIndex];

			for(arrayIndex = unsortedArrayIndex; arrayIndex > 0
					&& charArr[arrayIndex -1] > placeholder; arrayIndex--)
			{
				charArr[arrayIndex] = charArr[arrayIndex - 1];
			}
			charArr[arrayIndex] = placeholder;
		}
		return charArr;
	}

	public static char[] runSelectionSort(char[] charArr, int size)
	{
		int unsortedArrayIndex;
		int arrayIndex;
		int largestIndex = 0;

		for(unsortedArrayIndex = size - 1; unsortedArrayIndex > 0;
			unsortedArrayIndex--)
		{
			for (arrayIndex = 1; arrayIndex <= unsortedArrayIndex;
				 arrayIndex++)
			{
				if(charArr[arrayIndex] > charArr[largestIndex])
				{
					largestIndex = arrayIndex;
				}
			}
			swapValues(charArr,largestIndex,unsortedArrayIndex);
		}
		return charArr;

	}

	public static char[] runShellSort(char[] charArr,
									  int size)
	{
		int unsortedArrayIndex;
		int gap;
		char placeholder;
		int arrayIndex;


		for(gap  = (size/2); gap > 0; gap /= 2)
		{
			for( unsortedArrayIndex = gap; unsortedArrayIndex < size;
				 unsortedArrayIndex++)
			{
				placeholder = charArr[unsortedArrayIndex];

				arrayIndex = unsortedArrayIndex;

				while(arrayIndex >= gap &&
						charArr[arrayIndex - gap] > placeholder)
				{
					charArr[arrayIndex] = charArr[arrayIndex - gap];
					arrayIndex -= gap;
				}

				charArr[arrayIndex] = placeholder;


			}
		}
		return charArr;
	}

	private static void swapValues(char[] charArray, int indexOne,
								   int indexOther)
	{
		char Placeholder;

		if(indexOne == indexOther)
		{
			return;
		}

		Placeholder = charArray[indexOne];
		charArray[indexOne] = charArray[indexOther];
		charArray[indexOther] = Placeholder;

	}

}

