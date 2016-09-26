/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dsaj.arrays;

public class InsertionSort {

  public static void insertionSort(Character[] data) {
    int n = data.length;
    for (int k = 1; k < n; k++) {
      char cur = data[k].charValue();
      int j = k;
      while (j > 0 && data[j - 1].charValue() > cur) {
        data[j] = new Character(data[j - 1].charValue());
        j--;
      }
      data[j] = new Character(cur);
    }
  }

  public static void main(String[] args) {
    Character[] characterExamples = {'C', 'E', 'B', 'D', 'A', 'I', 'J', 'L', 'K', 'H', 'G', 'F'};
    System.out.println(java.util.Arrays.toString(characterExamples));
    insertionSort(characterExamples);
    System.out.println(java.util.Arrays.toString(characterExamples));
  }
}
