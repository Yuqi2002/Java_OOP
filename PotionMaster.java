// Yuqi Zhou	
// yu894053
// COP 3330, Spring 2023

import java.util.*;

public class PotionMaster
{
	public static Map<String, Set<String>> potionToReagentsMap(List<PotionInfo> potionsManual)
	{
		// initialize return map
		Map<String, Set<String>> potionsMap = new HashMap<>();

		// add potion to reagents pair to our Map
		for (int i = 0; i < potionsManual.size(); i++)
		{
			Set<String> reagentsSet = new HashSet<>(potionsManual.get(i).reagents);
			potionsMap.put(potionsManual.get(i).name, reagentsSet);
		}

		return potionsMap;
	}

	public static Map<String, Set<String>> reagentToPotionsMap(List<PotionInfo> potionsManual)
	{
		Map<String, Set<String>> reagentsMap = new HashMap<>();

		// loop through every potion in potionsManual
		for (int i = 0; i < potionsManual.size(); i++)
		{
			// loop through every reagent in each potion
			for (int j = 0; j < potionsManual.get(i).reagents.size(); j++)
			{
				
				// update value set if we encounter a potion name that has a reagent we have in our map
				if (reagentsMap.containsKey(potionsManual.get(i).reagents.get(j)))
					reagentsMap.get(potionsManual.get(i).reagents.get(j)).add(potionsManual.get(i).name);
				
				// put value in our map if the reagent we encounter does not exist in our map
				else
				{
					Set<String> potionsSet = new HashSet<>();
					potionsSet.add(potionsManual.get(i).name);
					reagentsMap.put(potionsManual.get(i).reagents.get(j), potionsSet);
				}
			}
		}
		return reagentsMap;
	}

	public static boolean canBrewPotion(PotionInfo potionInfo, Set<String> reagentsOnHand)
	{
		// check for every reagent in potion info if we have that reagent in our reagentsOnHand
		for (int i = 0; i < potionInfo.reagents.size(); i++)
		{
			if (reagentsOnHand.contains(potionInfo.reagents.get(i)) == false)
				return false;
		}
		return true;
	}

	public static boolean canBrewPotion(String potionToBrew,
	                                    Map<String, Set<String>> potionToReagentsMap,
	                                    Set<String> reagentsOnHand)
	{
		// find the reagent set in the map and store it into an Arraylist
		ArrayList<String> reagentsNeeded = new ArrayList<>(potionToReagentsMap.get(potionToBrew));

		// create a new Potioninfo instance
		PotionInfo potionInfo = new PotionInfo(potionToBrew, "", reagentsNeeded);

		// call the original canBrewPotion
		return canBrewPotion(potionInfo, reagentsOnHand);
	}

	public static Set<String> allPossiblePotions(Map<String, Set<String>> potionToReagentsMap,
	                                             Map<String, Set<String>> reagentToPotionsMap,
	                                             Set<String> reagentsOnHand)
	{
		Set<String> ret = new HashSet<>();
		// check if canBrewPotion is true for each potion to reagent set in the map 
		for (Map.Entry<String,Set<String>> potion : potionToReagentsMap.entrySet())
		{	
			// create an arraylist that stores the reagents required for each potion
			ArrayList<String> reagentsNeeded = new ArrayList<>(potionToReagentsMap.get(potion.getKey()));

			// create a new Potioninfo instance
			PotionInfo potionInfo = new PotionInfo(potion.getKey(),"", reagentsNeeded);

			// add potion name to the return set if we can brew it 
			if (canBrewPotion(potionInfo, reagentsOnHand) == true)
				ret.add(potion.getKey());
			
		}
		return ret;
	}

	public static double difficultyRating()
	{
		return 1.0;
	}

	public static double hoursSpent()
	{
		return 3.0;
	}
}
