package cc.interview.book.problems.data;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image
 * is 4 bytes. Rotate the image by 90 degress.
 */
public class RotateImageInPlace {
    /**
     * Rotate by clockwise.
     * @param image input matrix dimension with N*N.
     */
    public void rotateImage(int[][] image){
        if(image==null)
            return;
        for(int i=0;i<image.length/2;i++){

            for(int j=i;j<image.length-i-1;j++){
                int tmp = image[i][j];
                // the top row
                image[i][j] = image[image.length-1-j][i];
                // the left column
                image[image.length-1-j][i] = image[image.length-1-i][image.length-1-j];
                // the bottom row
                image[image.length-1-i][image.length-1-j] = image[j][image.length-1-i];
                // the right column
                image[j][image.length-1-i]= tmp;
            }
        }
    }
    @Test
    public void test1X1Matrix(){
        int[][] input={
                {1}
        };
        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
        for(int i=0;i<input.length*2;i++)
            System.out.print("=");
        System.out.println();

        rotateImage(input);

        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }
    @Test
    public void test2X2Matrix(){
        int[][] input={
                {1,2},
                {3,4}

        };
        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
        for(int i=0;i<input.length*2;i++)
            System.out.print("=");
        System.out.println();

        rotateImage(input);

        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }

    @Test
    public void test3X3Matrix(){
        int[][] input={
                {1,2,3},
                {4, 5,6},
                {7,8, 9}

        };
        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
        for(int i=0;i<input.length*2;i++)
            System.out.print("=");
        System.out.println();

        rotateImage(input);

        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }

    @Test
    public void test4X4Matrix(){
        int[][] input={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}

        };
        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
        for(int i=0;i<input.length*2;i++)
            System.out.print("=");
        System.out.println();

        rotateImage(input);

        for(int i=0;i<input.length;i++){
            System.out.println(Arrays.toString(input[i]));
        }
    }

}
