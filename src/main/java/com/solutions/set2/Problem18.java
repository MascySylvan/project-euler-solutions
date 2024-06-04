package com.solutions.set2;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Problem18 {

    public static void main(String[] args) throws JsonProcessingException {
		int[][] triangle = {
                                    {75},
                                  {95, 64},
                                {17, 47, 82},
                              {18, 35, 87, 10},
                            {20,  4, 82, 47, 65},
                          {19,  1, 23, 75,  3, 34},
                        {88,  2, 77, 73,  7, 63, 67},
                      {99, 65,  4, 28,  6, 16, 70, 92},
                    {41, 41, 26, 56, 83, 40, 80, 70, 33},
                  {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
              {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
          {63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        { 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}
        };

        int baseLength = triangle[triangle.length - 1].length;
        int maxSum = 0;
        List<Integer> maxSumGroup = new ArrayList<>();

        for (int i = 0; i < baseLength; i++) {
            int tempSum = 0;
            List<Integer> tempSumGroup = new ArrayList<>();
            int prevIndex = 0;
            for (int k = triangle.length - 1; k >= 0; k--) {
                if (k == triangle.length - 1) { //First Base Value
                    tempSum += triangle[k][i];
                    tempSumGroup.add(triangle[k][i]);
                    prevIndex = i;
                } else {
                    int leftV = prevIndex >  0 ? triangle[k][prevIndex - 1] : 0;
                    int rightV = prevIndex < triangle[k].length ? triangle[k][prevIndex] : 0;

                    if (leftV >= rightV) {
                        prevIndex = prevIndex - 1;
                        tempSumGroup.add(leftV);
                    } else {
                        tempSumGroup.add(rightV);
                    }

                    tempSum += Math.max(leftV, rightV);
                }
            }

            if (tempSum >= maxSum) {
                maxSum = tempSum;
                maxSumGroup = new ArrayList<>(tempSumGroup);
            }

            System.out.println("GROUP");
            System.out.println(new ObjectMapper().writeValueAsString(tempSumGroup));
            System.out.println("SUM");
            System.out.println(tempSum);
        }

        System.out.println("MAX GROUP");
        System.out.println(new ObjectMapper().writeValueAsString(maxSumGroup));
        System.out.println("MAX SUM");
        System.out.println(maxSum);
    }
    
}
