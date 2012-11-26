
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static void main(String args[]) {
		ArrayList<String> number = new ArrayList<String>();
		number.add("a");
		number.add("alex");
		number.add("bardon");
		number.add("debt");
		MergeSort merger = new MergeSort();
		List<String> results = merger.merge_sort(number);
		System.out.println(results);
	}

	public <T> List<T> merge_sort(List<T> numbers) {
		if (numbers.size() <= 1) {
			return numbers;
		}
		List<T> right = new ArrayList<T>();
		List<T> left = new ArrayList<T>();

		int middle = numbers.size() / 2;
		for (T num : numbers.subList(0, middle)) {
			left.add(num);
		}
		for (T num : numbers.subList(middle, numbers.size())) {
			right.add(num);
		}
		left = merge_sort(left);
		right = merge_sort(right);

		return merge(left, right);
	}

	private <T>  List<T> merge(List<T> leftHalf, List<T> rightHalf) {
		List<T> results = new ArrayList<T>();
		while (leftHalf.size() > 0 || rightHalf.size() > 0) {
			if (leftHalf.size() > 0 && rightHalf.size() > 0) {
				boolean diff = false;
				try{
					diff =  Integer.parseInt(leftHalf.get(0).toString()) <= Integer.parseInt(rightHalf.get(0).toString());
				}catch(NumberFormatException e){
					if(leftHalf.get(0).toString().compareTo(rightHalf.get(0).toString()) <= 0)
						diff = true;
				}
				if (diff) {
					results.add(leftHalf.get(0));
					if (leftHalf.size() > 1)
						leftHalf = leftHalf.subList(1, leftHalf.size());
					else
						leftHalf = new ArrayList<T>();
				} else {
					results.add(rightHalf.get(0));
					if (rightHalf.size() > 1)
						rightHalf = rightHalf.subList(1, rightHalf.size());
					else
						rightHalf = new ArrayList<T>();
				}
			} else if (leftHalf.size() > 0) {
				results.add(leftHalf.get(0));
				if (leftHalf.size() > 1)
					leftHalf = leftHalf.subList(1, leftHalf.size());
				else
					leftHalf = new ArrayList<T>();
			} else if (rightHalf.size() > 0) {
				results.add(rightHalf.get(0));
				if (rightHalf.size() > 1)
					rightHalf = rightHalf.subList(1, rightHalf.size());
				else
					rightHalf = new ArrayList<T>();
			}
		}
		return results;
	}
}