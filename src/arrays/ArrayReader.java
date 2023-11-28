package arrays;

import java.lang.reflect.Array;

public class ArrayReader {

    public Object getArrayElement(Object array, int index) {
        int arrayLength = Array.getLength(array);

        if (index >= 0) {
            for (int i = 0; i < arrayLength; i++)
                if (i == index) return Array.get(array, i);

        } else {
            int counter = 0;
            int i = arrayLength - 1;
            while (++counter < index * (-1)) i--;
            return Array.get(array, i);
        }

        return null;
    }

}
