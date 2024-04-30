package dsa;

import org.junit.Assert;

import java.util.Arrays;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int n = s.length();
        double noOfCharactersInASection = 2 * numRows - 2.0;
        int noOfSections = (int) Math.ceil(n / noOfCharactersInASection);
        int numCols = noOfSections * (numRows-1);

        char[][] mat = new char[numRows][numCols];
        for(char[] row : mat){
            Arrays.fill(row, ' ');
        }

        int row = 0, col = 0;
        int i = 0;

        while (i < n){
            //down
            while (row < numRows && i < n){
                mat[row][col] = s.charAt(i);
                row++;
                i++;
            }

            row -= 2;
            col++;

            //right
            while (row > 0 && col < numCols && i < n){
                mat[row][col] = s.charAt(i);
                row--;
                col++;
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char[] arr : mat){
            for (char ch : arr){
                if (ch != ' '){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }


    public String convert_Optimized(String s, int numRows) throws Exception {
        if (numRows <= 0){
            throw new RuntimeException("numRows can't be "+numRows);
        }
        if (numRows == 1){
            return s;
        }

        int n = s.length();
        int noOfCharsInSection = 2 * (numRows-1);
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++){
            int i = row;

            while (i < n){
                sb.append(s.charAt(i));

                if (row != 0 && row != numRows-1) { // apart from first and last element in each section for each row we have 2 characters
                    int charInBetween = noOfCharsInSection - 2 * row;
                    int nextIndex = i + charInBetween;

                    if (nextIndex < n) {
                        sb.append(s.charAt(nextIndex));
                    }
                }
                i += noOfCharsInSection;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        ZigZagConversion zig = new ZigZagConversion();
        Assert.assertEquals(zig.convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI");
        Assert.assertEquals(zig.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        System.out.println(zig.convert_Optimized("PAYPALISHIRING", 3));
    }
}
