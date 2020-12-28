package org.corda.year2020;

import org.corda.helper.CollectionHelper;
import org.corda.helper.Facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizD0902Resolver {
    private final List<Long> values;
    private final long goalValue;


    public QuizD0902Resolver(String fileName, long goalValue) throws IOException {

        this.values = Facade.longFromFile( fileName );

        this.goalValue = goalValue;
    }

    public long resolve() {

        List<Long> sumList = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            sumList = new ArrayList<>();

            long sum = 0;
            int j = i;
            while (sum < goalValue) {
                Long curValue = values.get( j );
                sum += curValue;
                sumList.add( curValue );

                if (sum == goalValue)
                    break;
                j++;
            }

            if (sum == goalValue)
                break;
        }

        long smallest = CollectionHelper.smallestElement(sumList  ) ;
        long larger = CollectionHelper.largerElement( sumList  ) ;

        long result = smallest + larger;

        return result;
    }


}
