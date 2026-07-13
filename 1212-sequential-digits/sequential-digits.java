

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        // Start with digits 1 to 9
        for (int i = 1; i <= 9; i++) {
            generate(i, i, low, high, result);
        }

        // Sort the result
        Collections.sort(result);

        return result;
    }

    private void generate(int num, int lastDigit, int low, int high, List<Integer> result) {

        // If number is in range, add it
        if (num >= low && num <= high) {
            result.add(num);
        }

        // If last digit is 9, cannot append next digit
        if (lastDigit == 9) {
            return;
        }

        // Add next sequential digit
        int nextNum = num * 10 + (lastDigit + 1);

        // Avoid exceeding high limit
        if (nextNum <= high) {
            generate(nextNum, lastDigit + 1, low, high, result);
        }
    }
}