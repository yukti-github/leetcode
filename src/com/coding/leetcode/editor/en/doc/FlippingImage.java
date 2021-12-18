class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int temp;

        for(int i=0; i<image.length;i++)
        {
            for(int j=0; j<=(image[0].length-1)/2; j++)
            {
                temp = image[i][j];
                image[i][j]= image[i][image[0].length-j-1]^1;
                image[i][image[0].length-j-1]= temp^1;
            }
        }

        return image;
    }

}