class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int low=0;
        int high=cols-1;
        while(low<=high){
            int midcol=low+(high-low)/2;
            int maxrow=0;
            for(int row=1;row<rows;row++){
                if(mat[row][midcol] > mat[maxrow][midcol]){ maxrow=row;}
            }
            int current=mat[maxrow][midcol];
            int left = (midcol > 0)
                    ? mat[maxrow][midcol - 1]
                    : -1;

            int right = (midcol < cols - 1)
                    ? mat[maxrow][midcol + 1]
                    : -1;
        if (current > left && current > right) {
                return new int[]{maxrow, midcol};
            }

            // Bigger element is on the right
            if (right > current) {
                low = midcol + 1;
            }

            // Bigger element is on the left
            else {
                high = midcol - 1;
            }
        }

        return new int[]{-1, -1};
    }
    }
