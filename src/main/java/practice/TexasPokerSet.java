package practice;

import java.util.*;

/**
 * Created by yang on 27/03/2017.
 */
public class TexasPokerSet implements Comparable<TexasPokerSet> {

	private final PokerFaceType handType;
	private final String[] origin;
	
	private final int maxSum;
	
	private HashMap<Integer, List<Integer>> numPerFace = new HashMap<>();
	
	TexasPokerSet(String[] origin) {
		this.origin = origin;
		List<Integer> values = convertValues(origin);
		Collections.sort(values);
		
		this.maxSum = populateFaceValue(values);
		
		this.handType = FaceDetermineHelper.determineFaceType(convertColors(origin), values, maxSum);
		
	}
	
	private List<Integer> convertValues(String []faces){
        List<Integer>  vals = new ArrayList<>();
        for(String i: faces){
            int val = Integer.parseInt(i.substring(1));
            val = val==1? 14:val;
            vals.add(val);
        }
        Collections.sort(vals);
        return vals;
    }
    private HashSet<String> convertColors(String []faces){
        HashSet<String> colors = new HashSet<>();
        for(String face:faces){
            colors.add(face.substring(0,1));
        }
        return colors;
    }
    
	private int compareValues(TexasPokerSet o) {

		for (int i = 4; i >= 1; i--) {
			List<Integer> cards = numPerFace.get(i);
			List<Integer> ocards = o.numPerFace.get(i);
			if (cards == null)
				continue;

			for (int j = 0; j < cards.size(); j++) {
				if (cards.get(j) - ocards.get(j) > 0)
					return 1;
				if (cards.get(j) - ocards.get(j) < 0)
					return -1;
			}
		}
		return 0;
	}

	// get the count of occurrence of each card value
	private int populateFaceValue(List<Integer> values) {
		int curSum = 1;
		int maxSum = 1;
		int first = values.get(values.size() - 1);
		int firstIndex = values.size() - 1;
		while (firstIndex-- > 0) {
			if (values.get(firstIndex).equals(first)) {
				curSum++;
				maxSum = Math.max(maxSum, curSum);
			} else {
				if (!numPerFace.containsKey(curSum)) {
					numPerFace.put(curSum, new ArrayList<Integer>());
					numPerFace.get(curSum).add(first);
				} else
					numPerFace.get(curSum).add(first);

				first = values.get(firstIndex);
				curSum = 1;
			}
		}
		
		// append the last card
		if (!numPerFace.containsKey(curSum)) {
			numPerFace.put(curSum, new ArrayList<Integer>());
			numPerFace.get(curSum).add(first);
		} else
			numPerFace.get(curSum).add(first);
		
		return maxSum;
	}
	

	@Override
	public int compareTo(TexasPokerSet o) {
		int diff = this.handType.getValue() - ((TexasPokerSet) o).handType.getValue();
		if (diff != 0)
			return diff;
		return compareValues((TexasPokerSet) o);
	}

	public PokerFaceType getFacetype() {
		return handType;
	}

	@Override
	public String toString() {
		return Arrays.toString(origin) + handType;
	}
}
