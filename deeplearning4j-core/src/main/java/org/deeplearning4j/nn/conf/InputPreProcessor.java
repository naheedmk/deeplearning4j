/*
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package org.deeplearning4j.nn.conf;

import org.deeplearning4j.berkeley.Pair;
import org.deeplearning4j.nn.gradient.Gradient;
import org.nd4j.linalg.api.ndarray.INDArray;

import java.io.Serializable;

/**
 * Input pre processor used
 * for pre processing input before passing it
 * to the neural network.
 *
 * @author Adam Gibson
 */
public interface InputPreProcessor extends Serializable {


    /**
     * Pre process input/activations for a multi layer network
     * @param input the input to pre process
     * @return the input to pre process
     */
    INDArray preProcess(INDArray input);

    /**Reverse the process during backprop. Process Gradient/epsilons before
     * passing them to the layer below.
     * @param Gradient and epsilon - i.e., output of Layer.backpropGradient(...)
     * @return the reverse of the pre process step (if any)
     */
    Pair<Gradient,INDArray> backprop(Pair<Gradient,INDArray> output);

}
