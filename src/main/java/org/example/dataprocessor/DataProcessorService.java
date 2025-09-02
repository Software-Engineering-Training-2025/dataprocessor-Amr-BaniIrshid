package org.example.dataprocessor;

import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;


import java.util.*;


public class DataProcessorService {


    public double process(
            CleaningType cleaningType,
            AnalysisType analysisType,
            OutputType outputType,
            List<Integer> data)  {


        double result = analysisType.analyze(
                cleaningType.clean(data)
        );

        outputType.output(result);
        return result;

    }
}

