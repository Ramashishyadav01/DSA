class Solution {
    public int reverse(int x) {
        int reverseNo = 0;

        while (x != 0) {
            int lastDigit = x % 10;

            // Check overflow before multiplication
            if (reverseNo > Integer.MAX_VALUE / 10 || 
                reverseNo < Integer.MIN_VALUE / 10) {
                return 0;
            }

            reverseNo = (reverseNo * 10) + lastDigit;

            x = x / 10;
        }

        return reverseNo;
    }
}